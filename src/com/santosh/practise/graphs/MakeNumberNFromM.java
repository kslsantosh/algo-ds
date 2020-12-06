package com.santosh.practise.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/minimum-number-operation-required-convert-number-x-y/
 */

public class MakeNumberNFromM {
    public static void main(String[] args) {
        int m = 6;
        int n = 10;
        int numberOfOperations = getMinimumOperations(m, n);
        System.out.println("Number Of Operations" + numberOfOperations);
    }

    private static int getMinimumOperations(int m, int n) {
        Queue<Integer> q = new LinkedList<>();

        if(m == n) return 0;
        if(m < 0 && n > 0) return -1;
        if(m > n) return m-n; // that many -1 operations we require

        q.add(m);
        int numberOfOperations = 0;

        while (! q.isEmpty()) {
            numberOfOperations++;

            Queue<Integer> q1 = new LinkedList<>();
            while (! q.isEmpty()) {
                q1.add(q.poll());
            }

            while (! q1.isEmpty()) {
                int currentNumber = q1.poll();
                if(currentNumber == n) {
                    return numberOfOperations;
                }


                if(currentNumber*2 != n) {
                    q.add(currentNumber*2);
                } else {
                    return numberOfOperations;
                }
                if(currentNumber-1 != n) {
                    q.add(currentNumber-1);
                } else {
                    return numberOfOperations;
                }
                System.out.println("Adding to queue : " + currentNumber*2);
                System.out.println("Adding " +
                        "to queue : " + (currentNumber-1));
            }
        }
        return numberOfOperations;
    }
}
