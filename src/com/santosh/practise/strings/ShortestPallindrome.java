package com.santosh.practise.strings;

import java.util.*;

/**
 * LeetCode - 214
 */
public class ShortestPallindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfInputs = sc.nextInt();
        List<String> inputs = new ArrayList<>();

        for(int i = 0 ; i< numberOfInputs ; i++) {
            inputs.add(sc.next());
        }
        System.out.println(inputs);
        for(String input : inputs) {
            findShortestPalindromeThatCanBeFormed(input);
        }

        //System.out.println("Converted Pallindrome String is : " + findShortestPalindromeThatCanBeFormed(s));
    }

    private static String findShortestPalindromeThatCanBeFormed(String s) {
        if(s == null || s.length() == 1 || s.length() == 0) {
            return s;
        }

        int leftIndex = 0;
        int rightIndex = s.length()-1;

        Map<Integer, Character> map = new HashMap<>();
        int insertionCount = 0;

        while (leftIndex < rightIndex) {

            if(s.charAt(leftIndex) == s.charAt(rightIndex)) {
                leftIndex++;
                rightIndex--;
            }
            else {
                String leftPart = s.substring(0, leftIndex);
                String rightPart = s.substring(leftIndex);
                s = leftPart + s.charAt(rightIndex) + rightPart;
                leftIndex++;
                insertionCount++;
            }
        }

        System.out.println("Number of insertions:: " + insertionCount);
        return s;
    }
}
