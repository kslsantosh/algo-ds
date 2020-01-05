package com.santosh.practise.arrays;

public class DriverLargestSumContiguousSubarray {
	public static void main(String[] args) {
		LargestSumContiguousSubarray obj = new LargestSumContiguousSubarray();
		obj.maxContiguousSum(new int[] {-2, -1,-2});
		obj.maxContiguousSum(new int[] {-2,-3,4,-1,-2,1,5,-3});
		obj.maxContiguousSum(new int[] {-1,2,3,-4,5,10});
		obj.maxContiguousSum(new int[] {-5, -11, -6, -4, -3, -10, -11, -1, -10 });
	}

    static class HeapNode {
        int data;
        int row;
        int column;

        HeapNode(int data, int row, int column) {
            this.data = data;
            this.row = row;
            this.column = column;
        }
    }
}