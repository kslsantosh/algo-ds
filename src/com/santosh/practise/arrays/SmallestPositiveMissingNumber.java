package com.santosh.practise.arrays;

import java.util.Arrays;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        //int[] arr = new int[]{ 2, 3, -7, 6, 8, 1, -10, 15 };
        int[] arr = new int[]{1000,-1};
        int missingNumber = findSmallestPositiveMissingNumber(arr);
        System.out.println(missingNumber);
    }

    private static int findSmallestPositiveMissingNumber(int[] arr) {

        if(arr.length == 1 && arr[0] != 1) return 1;

        int[] positiveNumberArray = segregatePositiveAndNegative(arr);
        for(int i = 0; i < positiveNumberArray.length; i++) {
            int currentNumber = Math.abs(positiveNumberArray[i]);
            if(currentNumber < positiveNumberArray.length) {
                if(positiveNumberArray[currentNumber] > 0) {
                    positiveNumberArray[currentNumber] = positiveNumberArray[currentNumber] * -1;
                }
            }
        }
        int i=0;
        for (i = 0; i < positiveNumberArray.length; i++)
            if (arr[i] > 0)
                return i + 1;
        return positiveNumberArray.length+1;
    }

    private static int[] segregatePositiveAndNegative(int[] arr) {
        int j = -1;
        for(int i = 0; i < arr.length; i++) {
            // swap arr[j] and current element
            if(arr[i] <= 0) {
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        j++;
        return Arrays.copyOfRange(arr, j, arr.length);
    }
}
