package com.santosh.practise.arrays;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        subArraySumEqualsK(new int[] {1, 4, 0, 0, 3, 10, 5}, 7);

    }

    private static void subArraySumEqualsK(int[] arr, int k) {
        int currentSum = arr[0];
        int startingIndex = 0;
        for(int i = 1; i < arr.length-1; i++) {
            currentSum = currentSum+arr[i];

            if(currentSum > k) {
                // need to increment the starting pointer
                while(startingIndex < i && currentSum > k) {
                    currentSum = currentSum - arr[startingIndex];
                    startingIndex++;
                }
            }
            if(currentSum == k) {
                System.out.println("Found sum begenning: " + startingIndex + " end index: " + i);
            }
        }
    }
}
