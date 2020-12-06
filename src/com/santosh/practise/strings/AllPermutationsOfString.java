package com.santosh.practise.strings;

public class AllPermutationsOfString {
    public static void main(String[] args) {
        String s = "ABC";
        printAllPermutations(s, 0);
    }

    private static void printAllPermutations(String s, int startIndex) {
        if(startIndex == s.length()) {
            System.out.println(s);
        }
        for(int i = startIndex; i < s.length(); i++) {
            String swappedCharacters = swapCharactersInString(s, startIndex, i);
            printAllPermutations(swappedCharacters, startIndex+1);
        }
    }

    private static String swapCharactersInString(String s, int startIndex, int i) {
        char[] charsInString = s.toCharArray();
        char temp = charsInString[startIndex];
        charsInString[startIndex] = charsInString[i];
        charsInString[i] = temp;
        return String.valueOf(charsInString);
    }
}
