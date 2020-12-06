package com.santosh.practise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Problem 39
 */
public class CombinationalSum {
    public static void main(String[] args) {
        //int[] arr = new int[]{2,4,6,8};
//        int[] arr = new int[]{10,1,2,7,6,1,5};
        int[] arr = new int[]{2,3,5};

        Arrays.sort(arr);
        arr = removeDuplicates(arr);

        int requiredSum = 8;
        List<List<Integer>> resultSet = findCombinationsForSum(arr, requiredSum);
    }

    private static List<List<Integer>> findCombinationsForSum(int[] arr, int requiredSum) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> resultSet = new ArrayList<>();

        getCombinations(arr, requiredSum, 0, combination, resultSet, 0);
        System.out.println(resultSet);
        return resultSet;
    }

    private static void getCombinations(int[] arr, int requiredSum, int currentSum, List<Integer> combination, List<List<Integer>> resultSet, int recurFromIndex) {

        for(int i = recurFromIndex; i < arr.length; i++) {

            currentSum = currentSum + arr[i];
            combination.add(arr[i]);

            if(currentSum < requiredSum) {
                getCombinations(arr, requiredSum, currentSum, combination, resultSet, i);
            }
            else if(currentSum == requiredSum) {
                resultSet.add(new ArrayList<>(combination));
            }
            combination.remove(combination.size() - 1);
            currentSum = currentSum - arr[i];
        }
    }

    private static int[] removeDuplicates(int[] arr) {
        List<Integer> temp = new ArrayList<>();

        int previous = arr[0];
        temp.add(previous);
        for(int i = 1; i < arr.length; i++) {
            if(previous != arr[i]) {
                temp.add(arr[i]);
                previous = arr[i];
            }
        }
        int[] temp1 = new int[temp.size()];
        int cp = 0;
        for (Integer integer : temp) {
            temp1[cp] = integer;
            cp++;
        }
        return temp1;
    }
}
