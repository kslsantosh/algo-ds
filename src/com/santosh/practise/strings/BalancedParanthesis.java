package com.santosh.practise.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        System.out.println(checkBalancedParanthesis("]"));
    }

    private static boolean checkBalancedParanthesis(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        Map<Character, Character> dict = new HashMap<>();
        dict.put('(', ')');
        dict.put('{', '}');
        dict.put('[', ']');

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length() ; i++) {
            char currentChar = s.charAt(i);

            if(dict.containsKey(currentChar)) {
                st.push(currentChar);
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                Character top = st.peek();
                if(dict.get(top).equals(currentChar)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        if(! st.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
