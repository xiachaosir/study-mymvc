package com.daojia.study.id;

/**
 * @author xiachao
 * @date 2019/8/30 17:46
 */

/**
 * 技术基础：机器数、真值、源码、反码、补码、模运算、运算符
 * [+1] = [00000001]原 = [00000001]反 = [00000001]补
 * [-1] = [10000001]原 = [11111110]反 = [11111111]补
 * 1 - 1 = 1 + (-1) = [0000 0001]原 + [1000 0001]原 = [1000 0010]原 = -2
 * 1 - 1 = 1 + (-1) = [0000 0001]原 + [1000 0001]原 = [0000 0001]反 + [1111 1110]反 = [1111 1111]反 = [1000 0000]原 = -0
 * 1 - 1 = 1 + (-1) = [0000 0001]原 + [1000 0001]原 = [0000 0001]补 + [1111 1111]补 = [0000 0000]补 = [0000 0000]原 = 0
 * (-1) + (-127) = [1000 0001]原 + [1111 1111]原  = [1111 1111]补 + [1000 0001]补 = [1000 0000]补 = -128
 * 每个id用一个64bit的正整数标示
 * 第1个bit：0代表正整数
 * 后41个bit：代表当前时间减twepoch
 * 后10个bit：代表服务器标示
 * 后12个bit：代表同一毫米内的不同id
 */
public class IdWorker {
    // 集群唯一表示
    private final long clusterId;
    // 服务器唯一标示，服务获取
    private final long workerId;
    // 时间从2016-01-01开始
    private static final long twepoch = 1451577600000L;
    // 数据中心表示占5位，可以支持32个数据中心
    private static final int clusterIdBits = 5;
    // 服务器标示占5位,id生成器可以有32个机器
    private static final int workerIdBits = 5;
    // 每毫米内的id占12位
    private static final int sequenceBits = 12;
    // 服务器标示左移位数
    private static final int workerIdShift = sequenceBits;
    // 数据中心左移位数
    private static final int clusterIdShift = sequenceBits + workerIdBits;
    // 时间戳左移位数
    private static final int timestampLeftShift = sequenceBits + workerIdBits + clusterIdBits;
    // 最大数据中心
    private static final int maxDatacenterId = -1 ^ -1 << clusterIdBits;
    // 服务器标示最大值
    private static final int maxWorkerId = -1 ^ -1 << workerIdBits;
    // 最大种子值
    private static final int maxSeed = -1 ^ -1 << (workerIdBits + clusterIdBits);
    // 序列号掩码
    private static final int sequenceMask = -1 ^ -1 << sequenceBits;

    // 上一毫秒
    private long lastTimestamp = -1L;
    // 限制每毫米产生的数据大小不能超过最大数
    private long lastTimestampSequenceSize = 0;
    // 跨毫米递增
    private long sequence = -1L;

    public IdWorker(int seed) {
        super();
        if (seed > maxSeed || seed < 0) {
            throw new IllegalArgumentException(String.format("seed Id can't be greater than %d or less than 0", maxSeed));
        }
        this.clusterId = seed >> workerIdBits & maxDatacenterId;
        this.workerId = seed & maxWorkerId;
    }

    /**
     * 指定id初始化
     *
     * @param workerId
     */
    public IdWorker(int clusterId, int workerId) {
        super();
        if (clusterId > maxDatacenterId || clusterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.clusterId = clusterId;
        this.workerId = workerId;
    }

    /**
     * 获取一个id
     *
     * @return
     */
    public synchronized long nextId() {
        long timestamp = this.timeGen();
        // 同一毫秒内取多个id
        if (this.lastTimestamp == timestamp) {
            this.lastTimestampSequenceSize = this.lastTimestampSequenceSize + 1 & sequenceMask;
            // 一毫秒内取的id次数大于上限，等待下一毫秒
            if (this.lastTimestampSequenceSize == 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            lastTimestampSequenceSize = 0;
        }
        this.sequence = this.sequence + 1 & sequenceMask;
        // 运维可能会修改系统时间，如果重启服务那就完蛋了！！！lastTimestamp做持久化性能会大打折扣
        if (timestamp < this.lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;
        return timestamp - twepoch << timestampLeftShift | clusterId << clusterIdShift | workerId << workerIdShift | this.sequence;
    }

    /**
     * 获取id中的时间
     *
     * @param id
     * @return
     */
    public long decodeTime(long id) {
        return (id >> timestampLeftShift) + twepoch;
    }

    /**
     * 获取种子
     *
     * @param id
     * @return
     */
    public int decodeSeed(long id) {
        return (int) (id >> workerIdShift & maxSeed);
    }

    /**
     * 获取id中的数据中心
     *
     * @param id
     * @return
     */
    public int decodeDatacenterId(long id) {
        return (int) (id >> clusterIdShift & maxDatacenterId);
    }

    /**
     * 获取id中的服务编号
     *
     * @param id
     * @return
     */
    public int decodeWorkerId(long id) {
        return (int) (id >> workerIdShift & maxWorkerId);
    }

    /**
     * 获取id中的序列
     *
     * @param id
     * @return
     */
    public int decodeSequence(long id) {
        return (int) (id & sequenceMask);
    }

    /**
     * 等待下一个毫米数
     *
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    /**
     * 当前时间的毫米数
     *
     * @return
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker(0, 0);
        long id = 116603368553578496L;
        System.out.println("id=" + id);
        System.out.println("timestamp = " + idWorker.decodeTime(id) + ";datacenterId = " + idWorker.decodeDatacenterId(id) + ";workerId = " + idWorker.decodeWorkerId(id) + ";sequence = " + idWorker.decodeSequence(id));
        System.out.println(idWorker.nextId());
        System.out.println(idWorker.nextId());System.out.println(idWorker.nextId());
        System.out.println(idWorker.nextId());


    }
}

