package com.santosh.practise.arrays;

public class LargestSumContiguousSubarray {
	
	public void maxContiguousSum(int[] arr) {
		int maxTillNow = arr[0];
		int currentSum = arr[0];

		for(int i = 1; i < arr.length; i++) {

		    if(arr[i] > maxTillNow) {
		        maxTillNow = arr[i];
            }
		    currentSum = currentSum + arr[i];

		    // check if this current sum is > max we have till now
            if(currentSum > maxTillNow) {
                maxTillNow = currentSum;
            }
            // if current sum is negative, there is no point in taking this sum more forward, because it will not increase the sum
            // So set it to 0 so that atleast from now if we get positive numbers it can increase the global sum.
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        System.out.println("Max number is:" + maxTillNow);
	}
}
