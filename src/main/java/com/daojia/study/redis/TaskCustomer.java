/*
package com.daojia.study.redis;

import redis.clients.jedis.Jedis;

*/
/**
 * @author xiachao
 * @date 2019/8/29 11:43
 *//*

public class TaskCustomer {

    private static volatile Jedis jedis = new Jedis("192.168.189.128", 6379);

    */
/*public TaskCustomer(Jedis jedis) {
        this.jedis = jedis;
    }
*//*

    public static void custom() {
        while (true) {
            String taskId = jedis.rpoplpush("task-queue", "tmp-queue");
            System.out.println("从task-queue取出taskId=" + taskId + "到tmp-queue");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            Integer integer = Integer.valueOf(taskId);
            if (integer % 2 == 0) {
                jedis.rpoplpush("tmp-queue", "task-queue");
                System.out.println("处理失败,从tmp-queue取出"+taskId+"重新放入task-queue");
            } else {
                jedis.rpop("tmp-queue");
                System.out.println("从tmp-queue移除taskId=" + taskId);
            }
        }
    }
}
*/
