package com.santosh.practise.dp;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.max;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int inputSize1 = s.nextInt();
        int inputSize2 = s.nextInt();
        int[] arr1 = new int[inputSize1];
        int[] arr2 = new int[inputSize2];
//        System.out.println("arr1 length" + arr1.length);
//        System.out.println("arr2 length" + arr2.length);
        for(int i = 0; i < inputSize1; i++) {
            arr1[i] = s.nextInt();
        }
        for(int i = 0; i < inputSize2; i++) {
            arr2[i] = s.nextInt();
        }
        int[] resultArray = longestCommonSubSequence(arr1, arr2);
    }

    private static int[] longestCommonSubSequence(int[] arr1, int[] arr2) {
        // create a 2d array grid with size 1 length more
        int[][] grid = new int[arr1.length+1][arr2.length+1];

        for(int i = 0 ;  i <= arr1.length ; i++) {
            for(int j = 0 ; j <= arr2.length ; j++) {

                if(i == 0 || j == 0) {
                    // if we are comparing with empty string then there is no common sequence
                    grid[i][j] = 0;
                }
                    else if (arr1[i-1] == arr2[j-1]){
                    // check if current pointers of string 1 and string 2 are having same charaqcter, then increment the count by 1
                    // it means by inclusion of the new character of string 1, this has matched, so take the diagonally previous value
                    grid[i][j] = grid[i-1][j-1] + 1;
                }
                else {
                    // it means that the character has not matched, so take the max value that has been obtained till now
                    // not including this character
                    grid[i][j] = max(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
//        for(int i = 0 ;  i <= arr1.length ; i++) {
//            for (int j = 0; j <= arr2.length; j++) {
//                System.out.print(grid[i][j]);
//            }
//            System.out.println();
//        }
        Stack<Integer> sequenceStack = new Stack<>();
        for(int i = arr1.length, j = arr2.length; i >0 && j >0; ) {
            int currentElement = grid[i][j];
            // check if previous row same value is equal
            if(grid[i-1][j] != currentElement) {
                if(grid[i][j-1] != currentElement) {
                    // it has been increased from the alternate previous element, so consider this element
                    sequenceStack.push(arr2[j-1]);
                    i--;
                    j--;
                }
                else {
                    j--;
                }
            } else if (grid[i-1][j] == currentElement) {
                i--;
            }
        }
        int[] resultArray = new int[sequenceStack.size()];
        int counter = 0;
        while(! sequenceStack.isEmpty()) {
            resultArray[counter] = sequenceStack.pop();
            counter++;
        }
        return resultArray;
    }
}
