package com.daojia.study.redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiachao
 * @date 2019/8/29 11:43
 */
public class TaskProducer{

    private static volatile Jedis jedis = new Jedis("192.168.189.128", 6379);

    private static volatile AtomicInteger value = new AtomicInteger(1);

    public TaskProducer() {

    }

    /*public TaskProducer(Jedis jedis) {
        this.jedis = jedis;
    }*/

    public static void addWorks() {
        String taskValue = String.valueOf(value.getAndIncrement());
        System.out.println("taskValue=" + taskValue);
        Long result = jedis.lpush("task-queue", taskValue);
        System.out.println("插入一条数据,task-queue大小为" + result + ",value=" + taskValue);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5 ; i++) {
            TaskProducer.addWorks();
        }
    }
}
