package com.daojia.study.redis;

import redis.clients.jedis.Jedis;

/**
 * @author xiachao
 * @date 2019/8/27 15:07
 */
public class TestRedis {





    public static void main(String[] args) {


        for (int i = 0; i < 100 ; i++) {
            TaskProducer.addWorks();
        }

        TaskCustomer.custom();

    }
}
