package com.santosh.practise.arrays;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class BinarySearch {
    static boolean found = false;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int trainsCount = s.nextInt();
        System.out.println("Enter values: ");
        int[] arr = new int[trainsCount];

        for(int i = 0; i < trainsCount; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("Enter the number to search: ");
        int k = s.nextInt();
        //binarySearch(arr, 0, arr.length-1, k);
        binarySearchRecursion(arr, 0, arr.length-1, k);
        if(!found) {
            System.out.println("Element not found");
        }
    }


    private static void binarySearch(int[] arr, int start, int end, int k) {
        while(! found && start <= end) {
            if(arr[start] == k) {
                found = true;
                System.out.println("Found at index: " + start);
                return;
            }
            else if(arr[end] == k) {
                found = true;
                System.out.println("Found at index: " + end);
                return;
            }
            int mid = (start + end) / 2;
            if(arr[mid] == k) {
                found = true;
                System.out.println("Found at index: " + mid);
                return;
            } else if(k > arr[mid]) {
                start = mid+1;
            } else if(k < arr[mid]) {
                end = mid-1;
            }
        }
    }

    private static void binarySearchRecursion(int[] arr, int start, int end, int k) {
        if(! found && start <= end) {
            if(arr[start] == k) {
                found = true;
                System.out.println("Found at index: " + start);
                return;
            }
            else if(arr[end] == k) {
                found = true;
                System.out.println("Found at index: " + end);
                return;
            }
            int mid = (start + end) / 2;
            System.out.println("Mid: " + mid);
            if(arr[mid] == k) {
                found = true;
                System.out.println("Found at index: " + mid);
            } else if(k > arr[mid]) {
                start = mid+1;
                binarySearchRecursion(arr, start, end, k);
            } else if(k < arr[mid]) {
                end = mid-1;
                binarySearchRecursion(arr, start, end, k);
            }
        }
    }
}
