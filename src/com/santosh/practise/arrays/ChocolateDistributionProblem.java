package com.santosh.practise.arrays;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/chocolate-distribution-problem/
 */
public class ChocolateDistributionProblem {
    public static void main(String[] args) {
//        int[] arr = new int[]{7, 3, 2, 4, 9, 12, 56}; int k = 3;
        int[] arr = new int[]{3, 4, 1, 9, 56, 7, 9, 12}; int k = 5;

        findOptimalChocolateDistribution(arr, k);
    }

    private static void findOptimalChocolateDistribution(int[] arr, int k) {
        Arrays.sort(arr);
        if(k > arr.length) {
            System.out.println("Number of packets are less than number of students");
            return;
        }
        if(k == 1) {
            System.out.println(arr[0]);
            return;
        }

        int start  = 0;
        int end = k-1;

        int minimumStartIndex = 0;
        int minimumTillNow = Integer.MAX_VALUE;

        while(end <= arr.length-1) {
            if((arr[end] - arr[start]) < minimumTillNow) {
                minimumStartIndex = start;
                minimumTillNow = arr[end] - arr[start];
            }
            start++;
            end++;
        }
        System.out.println("minimum start index" + minimumStartIndex);
        for(int i = 0; i < k; i++) {
            System.out.println(arr[minimumStartIndex]);
            minimumStartIndex++;
        }
    }
}
