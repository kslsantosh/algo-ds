package com.santosh.practise.arrays;

/* Given an array, print the Next Greater Element (NGE) for every element.
        The Next greater Element for an element x is the first greater element on the right side of x in array.
        Elements for which no greater element exist, consider next greater element as -1.*/

import java.util.Stack;

public class NextMaximumElement {
    public static void main(String args[]) {
        int[] arr = {9, 7, 2, 4, 6, 8, 2, 1, 5};
        printNextMinimumElements(arr);
    }

    private static void printNextMinimumElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            if(stack.isEmpty() || stack.peek() > currentElement) {
                stack.push(currentElement);
            } else {
                while (stack.peek() < currentElement) {
                    System.out.println(stack.peek() + " - " + currentElement);
                    stack.pop();
                }
                stack.push(currentElement);
            }
        }
        while(! stack.isEmpty()) {
            System.out.println(stack.peek() + " - " + "-1");
            stack.pop();
        }
    }
}
