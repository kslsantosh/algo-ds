package com.santosh.practise.arrays;

/**
 * LeetCode 153
 */
public class RotatedSortedArrayMinimum {

    public static void main(String[] args) {
        int[] arr = new int[10];

        findMinimum(arr);
    }

    private static int findMinimum(int[] arr) {
        if(arr.length == 1) return arr[0];

        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            int mid = (start + end ) / 2;
            if(mid == 0) return Math.min(arr[0], arr[1]);

            if(arr[mid] < arr[mid-1]) {
                return arr[mid];
            } else if(arr[mid] > arr[mid+1]) {
                return arr[mid+1];
            }

            if(arr[mid] > arr[end]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return arr[start];
    }
}
