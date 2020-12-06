package com.santosh.practise.arrays;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode 239
 */
public class SlidingWindowMaximumSum {
    public static void main(String[] args) {
        //int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        //int[] arr = new int[]{1, -1};
        int[] arr = new int[]{7,2,4};
        int k = 2; // window size

        int[] result = getSlidingWindowsMaximum(arr, k);
        System.out.println("Result is");
        for(int i : result) {
            System.out.println(i);
        }
    }

    // Logic, for each element, remove elements from the end of dq till whose value is less than the current value
    // by this way we are getting rid of useless elements.
    // and then at the end add the current element.

    public static int[] getSlidingWindowsMaximum(int[] arr, int k) {
        int resultArrSize = arr.length - k + 1;
        int[] result = new int[resultArrSize];

        int resultArrayIndex = 0;

        // Have a Double ended Queue
        Deque<Integer> dq = new LinkedList<>();

        // dequeue will have indexes not the elements
        // dequeue will have the index of the maximum element of the window's index at the start
        // minimum element index at the end
        int i;
        for(i = 0; i < k ; i++) {

            // remove indexes of all the elements which are having value less than the current element
            while ( ! dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            System.out.println("Adding to DQ: " + i);
            dq.addLast(i);
        }

        System.out.println("DQ after first window: " + dq);

        for(; i < arr.length; i++) {
            System.out.println("Max of current window index is :"  + dq.peekFirst() + " and element is : " + arr[dq.peekFirst()]);
            result[resultArrayIndex] = arr[dq.peekFirst()]; // first element index in the dq is the largest element
            resultArrayIndex++;

            // remove the element indexes which are moved out of this current window.
            while (! dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }

            while (! dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.removeLast();
            }
            System.out.println("Adding to DQ: " + i);
            dq.addLast(i);
            System.out.println("DQ after first window: " + dq);
        }
        result[resultArrayIndex] = arr[dq.peekFirst()];
        return result;
    }
}
