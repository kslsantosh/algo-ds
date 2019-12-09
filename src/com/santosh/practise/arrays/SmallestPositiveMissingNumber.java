package com.santosh.practise.arrays;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{ 2, 3, -7, 6, 8, 1, -10, 15 };
        int missingNumber = findSmallestPositiveMissingNumber(arr);
    }

    private static int findSmallestPositiveMissingNumber(int[] arr) {
        int missingNumber = 0;

        int shift = segregatePositiveAndNegative(arr);

        return 0;
    }

    private static int segregatePositiveAndNegative(int[] arr) {
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            // swap arr[j] and current element
            if(arr[i] < 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        return j;
    }
}
