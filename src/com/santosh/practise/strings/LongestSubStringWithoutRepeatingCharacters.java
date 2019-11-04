package com.santosh.practise.strings;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 *  LeetCode Problem 3
 */
public class LongestSubStringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        //String s = "ABDEFGABEF";
        //String s = "pwwkew";
        //String s = "tmmzuxt";
        String s = "bbtablud";
        int maxLength = longestSubStringWithoutRepeatingCharacters(s);
        System.out.println(maxLength);
    }

    private static int longestSubStringWithoutRepeatingCharacters(String s) {
        Map<Character, Integer> positionMap = new HashMap<>();
        int left =  0;
        int right = 0;
        int maxLength = 0;

        while(left < s.length() && right < s.length() && left <= right) {
            System.out.println("Here i, j: " + left + "_" + right);

            Character currentChar = s.charAt(right);

            if(positionMap.containsKey(currentChar)) {
                int previousFoundLocation = positionMap.get(currentChar);
                // from left to previous found locatiom , remove elements from map
                for(int i = left; i < previousFoundLocation; i++) {
                    positionMap.remove(s.charAt(i));
                }
                left = previousFoundLocation+1;
                positionMap.put(currentChar, right);
                right++;
            }
            else {
                int currentLength = right - left + 1;
                if(currentLength > maxLength) {
                    maxLength = currentLength;
                }
                positionMap.put(currentChar, right);
                right++;
            }
        }

        return maxLength;
    }
}

