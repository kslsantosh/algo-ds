package com.santosh.practise.strings;

import java.util.*;

public class AnagramSubStringSearch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the main string");
        String string = s.next();
        System.out.println("Enter the sub string");
        String subString = s.next();

        anagramSearch(string, subString);
    }
    // TODO: NOT WORKING, NEED TO MODIFY
    private static void anagramSearch(String string, String subString) {
        Map<Character, Integer> subStringFreqMap = new HashMap<>();
        Map<Character, Integer> stringFreqMap = new HashMap<>();

        int foundCount = 0;
        // load first k characters into map
        for(Character c : subString.toCharArray()) {
            int currentFreq = subStringFreqMap.getOrDefault(c, 0);
            subStringFreqMap.put(c, ++currentFreq);
        }
        for(int i = 0; i < subString.length(); i++) {
            int currentFreq = stringFreqMap.getOrDefault(string.charAt(i), 0);
            stringFreqMap.put(string.charAt(i), ++currentFreq);
        }
        if(subStringFreqMap.equals(stringFreqMap)) {
            System.out.println("Found At" + 0);
        }

        for(int i=subString.length() ; i < string.length(); i++) {
            Character previousCharacter = string.charAt(i-1);
            if(stringFreqMap.containsKey(previousCharacter)) {
                Integer prevCharacterFreq = stringFreqMap.get(previousCharacter);
                stringFreqMap.put(previousCharacter, --prevCharacterFreq);
            }

            Character newCharacter = string.charAt(i);
            Integer newCharacterFreq = stringFreqMap.getOrDefault(newCharacter, 0);
            if(subStringFreqMap.containsKey(newCharacter)) {
                stringFreqMap.put(newCharacter, ++newCharacterFreq);
            }
            // comapre 2 hashmaps

            if(stringFreqMap.equals(subStringFreqMap)) {
                System.out.println("Found At:" + i);
            }
        }
    }
}
