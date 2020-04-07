package com.daojia.study.redis;

import redis.clients.jedis.Jedis;

/**
 * @author xiachao
 * @date 2019/8/29 15:28
 */
public class JedisUtil {

    private static volatile Jedis jedis = new Jedis("192.168.189.128", 6379);

    public static Jedis getJedis() {
        return jedis;
    }
}
