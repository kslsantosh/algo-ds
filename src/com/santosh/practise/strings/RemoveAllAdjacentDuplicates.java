package com.santosh.practise.strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {

        String str = "abbaca";
        String result = removeAdjacentDuplicatesInAString(str);
        System.out.println(result);
    }

    private static String removeAdjacentDuplicatesInAString(String str) {
        String result = "";

        if(str == null || str.length() == 0)
            return result;

        Stack<Character> st = new Stack<>();
        Character lastRemoved = '\n';

        for(int i = 0 ; i < str.length(); i++) {
            Character currentChar = str.charAt(i);
            if(currentChar == lastRemoved) {
                // do not push it to the stack, just ignore it;
                continue;
            } else {
                lastRemoved = '\n'; // for example "aaca" output should be ca. once we get c last removed character cannot remain as a.
            }
            if(st.isEmpty()) {
                st.push(currentChar);
            } else {
                if(currentChar == st.peek()) {
                    st.pop();
                    lastRemoved = currentChar;
                } else {
                    st.push(currentChar);
                }
            }
        }

        for(Character c : st) {
            result = result+c;
        }
        return result;
    }
}
