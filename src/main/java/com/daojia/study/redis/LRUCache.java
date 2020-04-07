package com.daojia.study.redis;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xiachao
 * @date 2019/5/9 16:31
 */
public class LRUCache extends LinkedHashMap<String, String> {

    private final int CACHE_SIZE;

    public LRUCache(int cacheSize) {
        super( (int) (Math.ceil(cacheSize / 0.75 ) + 1 ), 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry entry) {
        return size() > CACHE_SIZE;
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put("key1","value1");
        System.out.println("1---"+lruCache);
        lruCache.put("key2", "value2");
        System.out.println("2---"+lruCache);
        Set<Map.Entry<String, String>> entrySet = lruCache.entrySet();
        /*for (Map.Entry entry : entrySet) {
            lruCache.removeEldestEntry(entry);
            System.out.println(entry.getKey() + "----"+ lruCache);
        }
        System.out.println("lru result----"+ lruCache);*/

        lruCache.put("key3", "value3");
        System.out.println("3---"+lruCache);
        System.out.println("result----"+ lruCache);

    }


}
