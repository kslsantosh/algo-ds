package com.santosh.practise.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ReverseWordsInStrings {
    public static void main(String[] args) {
        //String str = "the sky is blue";
        String str = "       ";
        String output = getReversedString(str);
        System.out.println("Output is ::" + output);
    }

    private static String getReversedString(String str) {
        List<String> stringList = new ArrayList<>();

        StringBuffer sb = new StringBuffer();

        for(int i = 0 ; i < str.length(); i++) {
            if(str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            }
            else {
                if(sb.length() > 0) {
                    stringList.add(sb.toString());
                    sb= new StringBuffer();
                }
            }
        }
        if(sb.length()>0) stringList.add(sb.toString());

        System.out.println(stringList);
        ListIterator<String> li = stringList.listIterator(stringList.size());
        StringBuilder sb1 = new StringBuilder();
        while (li.hasPrevious()) {
            sb1.append(li.previous()).append(' ');
            li.remove();
        }
        if (sb1.length() > 0) sb1.deleteCharAt(sb1.length()-1);
        return sb1.toString();
    }
}
