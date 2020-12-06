package com.santosh.practise.arrays;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximumSum2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3; // window size

        int[] result = getSlidingWindowMaximum(arr, k);
    }

    private static int[] getSlidingWindowMaximum(int[] arr, int k) {


        int[] result = new int[arr.length -k +1];

        Deque<Integer> dq = new LinkedList<Integer>();
        int resultArrayIndex = 0;

        int i;

        for(i = 0; i < k; i++) {
            while (! dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        System.out.println("Result Array INdex " + 0 + " max= " + arr[dq.peekFirst()]);
        result[resultArrayIndex] = arr[dq.peekFirst()];

        System.out.println("DQ after first window: " + dq);



        for(int j = i; j < arr.length; j++) {

            int indexToRemove = j - k; // remove all the elemnts ewhich are having index <= this element
            System.out.println("Index Range "  + (indexToRemove+1) + "to " + j);


            // check if the nely added element can be the maximum of the complate sub array/
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[j] ) {
                dq.pollLast();
            }
            dq.addLast(j);
            System.out.println("DQ =" + dq);

            // check if i need to remove any elements from the dq.

            while (!dq.isEmpty() && dq.peekFirst() <= indexToRemove) {
                dq.pollFirst();
            }
            resultArrayIndex++;

            result[resultArrayIndex] = arr[dq.peekFirst()];

        }

        for(int x : result) {
            System.out.println(x);
        }
        return result;
    }

}
