package com.wjb.java.juc.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 分段锁
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
    }
}
