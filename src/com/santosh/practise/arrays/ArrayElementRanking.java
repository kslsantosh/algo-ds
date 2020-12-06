package com.santosh.practise.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * There will be n elements in the array (duplicates also), if given rank = 3, then we need to tell the count of elements which are <= that rank
 *
 *
 */
public class ArrayElementRanking {
    public static void main(String[] args) {
        int requiredMaxRank = 3;
//        int[] arr = new int[]{5,6,7,1,3,3,3,7,5,3,2,7,8,5,4,3};
//        int[] arr = new int[]{13,12,12,14,17,12,13,11,11};
        int[] arr = new int[]{70,11,12,20,80,11,11,10};
        Integer topKRankElementCount = getTopKRankElements(arr, requiredMaxRank);
        System.out.println("Number of elements having higher or equal rank are:" + topKRankElementCount);

    }

    private static Integer getTopKRankElements(int[] arr, int requiredMaxRank) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(requiredMaxRank);
        Map<Integer, Integer> freqMap = new HashMap<>(requiredMaxRank);
        Integer numberOfElements = 0;
        System.out.println(freqMap.size());
        for(Integer i  : arr) {
            if(freqMap.containsKey(i)) {
                freqMap.put(i, freqMap.get(i) + 1);
                numberOfElements = numberOfElements + 1;
//                minHeap.add(i);
            } else {
                if(freqMap.size() < requiredMaxRank) {
                    freqMap.put(i, 1);
                    minHeap.add(i);
                    numberOfElements = numberOfElements + 1;
                } else if(freqMap.size() == requiredMaxRank) {
                   // get the min most element (first element from min heap and then delete it from heap, delete it from map also)
                    Integer currentMinElement = minHeap.peek();
                    if(i > currentMinElement) {
                        minHeap.poll();
                        numberOfElements = numberOfElements - freqMap.get(currentMinElement);

                        freqMap.remove(currentMinElement);

                        minHeap.add(i);
                        freqMap.put(i, 1);

                        numberOfElements = numberOfElements + 1;
                    }
                }
            }
        }
        System.out.println("Min heap" + minHeap);
        System.out.println(freqMap);
        return numberOfElements;
    }


}
