package com.mort.leetCode;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Author:  lining17
 * Date :  2020-03-28
 */
public class Cache {

    private long EXPIRED = 5*1000l;

    private long MAX_SIZE ;

    private AtomicLong CURRENT_SIZE ;

    private ConcurrentHashMap<Object,Object> CACHE_VALUE =  new ConcurrentHashMap<>();

    private LinkedHashMap<Object, Long > TIME_INFO;

    private Object lock =  new Object();


    boolean putValue(Object key, Object value) {
        if (CURRENT_SIZE.get() > MAX_SIZE) {
            //expire

        }
        CACHE_VALUE.put(key, value);
        synchronized (lock) {
            TIME_INFO.put(key, new Date().getTime());
        }
        return true;
    }


    Object get(String key) {
        //被动过期
        if (TIME_INFO.get(key) < new Date().getTime() - EXPIRED) {
            CACHE_VALUE.remove(key);
            return null;
        }
        return CACHE_VALUE.get(key);
    }

    //线程主动过期

}
