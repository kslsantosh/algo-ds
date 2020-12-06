package com.santosh.practise.graphs;

import java.util.*;

public class MaxCircleSum {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,1,4,13,8,8,8,0,8,14,9,15,11,-1,10,15,22,22,22,22,22,21};

        int maxCycleSum = findMaxCycleSum(arr);
        System.out.println("MaxCycleSum->" + maxCycleSum);
    }

    private static int findMaxCycleSum(int[] arr) {
        int maxCycleSum = -1;

        Map<Integer, Boolean> visitedMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            visitedMap.put(arr[i], false);
            set.add(arr[i]);
        }

        while (! set.isEmpty()) {

            for (Map.Entry<Integer, Boolean> entry : visitedMap.entrySet()) {
                Integer key = entry.getKey();
                if (visitedMap.get(key)) { // it is already visited. Break at this point
                    // empty the stack untill you find the same number again
                    int currentSum = key;

                    while (! stack.isEmpty() && ! stack.peek().equals(key)) {
                        int currentElement = stack.pop();
                        currentSum  = currentSum + currentElement;
                    }

                    if(currentSum > maxCycleSum) {
                        maxCycleSum = currentSum;
                    }
                    stack.clear();

                } else {
                    System.out.println("Adding to stack: " + key);
                    visitedMap.put(key, true);
                    stack.push(key);
                }
            }
        }

        return maxCycleSum;
    }
}
