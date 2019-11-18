package com.santosh.practise.heap;

import java.util.*;

/**
 * Leet Code 347
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,1,1,2,2,3};
        int[] arr = new int[]{5,3,1,1,1,3,73,1};
        int k = 2;
        List<Integer> topKFrequentElements = getTopKFrequentElements(arr, k);
        System.out.println("Number of elements having higher or equal rank are:" + topKFrequentElements);

    }

    private static List<Integer> getTopKFrequentElements(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        List<Integer> resultSet = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>(k);

        for(Integer i : arr) {
            int currentFreq = freqMap.getOrDefault(i, 0);
            int increasedFrequency = ++currentFreq;
            freqMap.put(i, increasedFrequency);
        }
        freqMap.forEach((integer, frequency) -> {
            if(minHeap.size() < k) {
                minHeap.add(frequency);
            }
            else if(minHeap.size() == k) {
                int currentMinFrequency = minHeap.peek();
                if(frequency > currentMinFrequency) {
                    minHeap.poll();
                    minHeap.add(frequency);
                }
            }
        });
        int minMostFrequency = minHeap.size() > 0 ? minHeap.poll() : arr.length+1;
        if(minMostFrequency <= arr.length) {
            freqMap.forEach((integer, frequency) -> {
                if(frequency >= minMostFrequency) {
                    resultSet.add(integer);
                }
            });
        }
        return resultSet;
    }
}
