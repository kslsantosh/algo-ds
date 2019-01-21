package com.santosh.practise.arrays;

public class LargestSumContiguousSubarray {
	
	public void maxContiguousSum(int[] arr) {
		int maxTillNow = arr[0];
        int sumTillNow = arr[0];
        int overallMax = arr[0]; // useful when all given values are negative
        int positiveSum = arr[0] > 0 ? arr[0] : 0;
        boolean allNegative = true;
        if(arr[0] > 0) {
            allNegative = false;
        }
        for(int i=1 ; i<arr.length; i++) {
            if(arr[i] > 0) {
                positiveSum += arr[i];
                allNegative = false;
            }
            int tempSum = sumTillNow + arr[i];
            if(sumTillNow < tempSum) {
                // some increasing number has come
                if(sumTillNow > 0) {
                    sumTillNow = tempSum;
                    if(sumTillNow > maxTillNow) {
                        maxTillNow = sumTillNow;
                    }
                }
                else {
                    sumTillNow = arr[i];
                    if(sumTillNow > maxTillNow) {
                        maxTillNow = sumTillNow;
                    }
                }
            }
            else {
                sumTillNow = tempSum;
            }
            if(overallMax < arr[i]) {
                overallMax = arr[i];
            }
        }
        if(allNegative) {
            System.out.print(overallMax);
        }
        else {
            System.out.print(maxTillNow);
        }
        System.out.print(" ");
        if(allNegative) {
            System.out.print(overallMax);
        }
        else {
            System.out.print(positiveSum);
        }
        System.out.println();
	}
}
