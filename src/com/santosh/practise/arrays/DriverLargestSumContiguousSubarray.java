package com.santosh.practise.arrays;

import java.util.Scanner;

public class DriverLargestSumContiguousSubarray {
	public static void main(String[] args) {
		LargestSumContiguousSubarray obj = new LargestSumContiguousSubarray();
		Scanner s = new Scanner(System.in);
		int numTestCases = s.nextInt();
		for(int i = 0 ; i < numTestCases; i++) {
			int arrSize = s.nextInt();
			int[] arr = new int[arrSize];
			for(int j = 0; j< arrSize; j++) {
				arr[j]= s.nextInt();
			}
			obj.maxContiguousSum(arr);
		}
		//obj.maxContiguousSum(new int[] {-2,-3,4,-1,-2,1,5,-3});
		//obj.maxContiguousSum(new int[] {-1,2,3,-4,5,10});
	}
}