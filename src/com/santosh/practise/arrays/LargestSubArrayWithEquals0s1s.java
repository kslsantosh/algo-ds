package com.santosh.practise.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode - 525
 */
public class LargestSubArrayWithEquals0s1s {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,0,0,1,1,0,0,1,1};
        int[] arr = new int[]{};
        int maxLength = findMaxLength(arr);
        System.out.println("Max Length: " + maxLength);
    }

    public static int findMaxLength(int[] arr) {
        int length = arr.length;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sumTillNow = 0;

        for(int i = 0; i < length; i++) {
            if(arr[i] == 0) {
                sumTillNow = sumTillNow - 1;
            } else {
                sumTillNow = sumTillNow + 1;
            }

            if(sumTillNow == 0) {
                maxLength = i+1;
            } else {
                if(map.containsKey(sumTillNow)) {
                    // already found the sum previously, get the index of it.
                    int previousIndex = map.get(sumTillNow);
                    int currentLength = i+length - previousIndex;
                    maxLength = Math.max(maxLength, currentLength);
                } else {
                    // sum is found for the first time, save it.
                    map.put(sumTillNow, i+length);
                }
            }

        }
        return maxLength;
    }
}
