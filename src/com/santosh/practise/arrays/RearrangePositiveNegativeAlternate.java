package com.santosh.practise.arrays;

public class RearrangePositiveNegativeAlternate {
    public static void main(String[] args) {
        //[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int[] arr = {5, 2, -5, -2, 4, 7, 1, 8, 0, -8};
        int[] arr2 = {5, 2, -5, -2, 4, 7, 1, -8, 0, 8};
        //int[] arr = {5, -32, -5, -2, 4, -7, -1, -8, 0, 8};
        //reArrange(arr);
        reArrange_new(arr);
    }

    private static void reArrange(int[] arr) {
        int length = arr.length;
        // first segregate +ve and -ve numbers inside the array
        // bring -ve to the start of the array

        int positiveStartIndex = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                positiveStartIndex++;
                int temp = arr[i];
                arr[i] = arr[positiveStartIndex];
                arr[positiveStartIndex] = temp;
            }
        }
        positiveStartIndex ++;
        int currentPointer = 0;
        while(positiveStartIndex < length && currentPointer < positiveStartIndex){
            int temp = arr[positiveStartIndex];
            arr[positiveStartIndex] = arr[currentPointer];
            arr[currentPointer] = temp;
            positiveStartIndex++;
            currentPointer +=2;
        }
        for (int anArr : arr) {
            System.out.println(anArr);
        }

    }

    private static void reArrange_new(int[] arr) {
        int positiveStartIndex = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                positiveStartIndex++;
                int temp = arr[positiveStartIndex];
                arr[positiveStartIndex] = arr[i];
                arr[i] = temp;
            }
        }
        positiveStartIndex++;

        System.out.println("positive start index: " + positiveStartIndex);

        for(int i = 1; i < positiveStartIndex && positiveStartIndex < arr.length; i = i+2) {
            if(arr[i] < 0 && arr[positiveStartIndex] >= 0) {
                int temp = arr[i];
                arr[i] = arr[positiveStartIndex];
                arr[positiveStartIndex] = temp;
                positiveStartIndex++;
            } else {
                break;
            }
        }
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }
}
