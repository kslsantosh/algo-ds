package com.santosh.practise.arrays;

public class ZigZagArray {
    public static void main(String[] args) {
        int[] arr = new int[]{ 4, 3, 7, 8, 6, 2, 1 };
        zigZagArray(arr);
        for(int i : arr) {
            System.out.println(i);
        }
    }

    private static void zigZagArray(int[] arr) {
        int direction = 0;

        for(int i = 0; i< arr.length-1; i++) {
            if(direction == 0) {
                // for direction = 0, a should be less than b -> a < b
                // if it is not, swap it
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
                direction = 1;
            }
            else if(direction == 1) {
                // if direction = 1, a should be > b -> a > b
                // if not , swap it
                if(arr[i] < arr[i+1]) {
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;

                }
                direction = 0;
            }
        }
    }
}
