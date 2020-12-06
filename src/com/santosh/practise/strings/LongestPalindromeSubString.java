package com.santosh.practise.strings;

import static java.lang.Math.max;

/**
 * LeetCode problem 5
 */
public class LongestPalindromeSubString {
    public static void main(String[] args) {
        //String s = "forgeeksskeegfor";
        String s = "ac";
        //String s = "";
        if(s==null || s.equals("")) {
            System.out.println(0);
        } else {
            System.out.println(findLongestPalindromeSubString(s));
        }

    }

    private static String findLongestPalindromeSubString(String str) {
        if(str==null || str.equals("")) {
            return "";
        }
        else if(str.length() == 1) {
            return str;
        }

        int maxLength = 1;
        String longestPalindrome = String.valueOf(str.charAt(0));

        for(int i = 0; i < str.length() ; i++) {
            int left = i;
            int right = i+1;

            // taking i,i+1 as center for
            while (left  >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                int evenLength = right-left + 1;
                if(evenLength > maxLength) {
                    maxLength = max(maxLength , evenLength);
                    //System.out.println("Longest Pallindrome Now:: " + str.subSequence(left, right+1));
                    longestPalindrome = str.subSequence(left, right+1).toString();
                }

                left--;
                right++;
            }


            left = i-1;
            right = i+1;

            // taking i as center
            while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                int evenLength = right-left + 1;
                if(evenLength > maxLength) {
                    maxLength = max(maxLength , evenLength);
                    //System.out.println("Longest Pallindrome Now:: " + str.subSequence(left, right+1));
                    longestPalindrome = str.subSequence(left, right+1).toString();
                }
                left--;
                right++;
            }
        }
        return longestPalindrome;
    }
}
