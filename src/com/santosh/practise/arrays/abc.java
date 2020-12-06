package com.santosh.practise.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class abc {
    public static void main(String[] args) {
        Map<String, Integer> strinFreqMap = new HashMap<String, Integer>();

        strinFreqMap.getOrDefault("s", 0);
        AtomicInteger freq = new AtomicInteger();
        for (Map.Entry<String, Integer> entry : strinFreqMap.entrySet()) {
            String a = entry.getKey();
            Integer b = entry.getValue();
            a.toUpperCase();
            freq.getAndIncrement();
        }
    }
}
