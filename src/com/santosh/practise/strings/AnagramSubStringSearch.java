package com.santosh.practise.strings;

import java.util.*;

/**
 * Leet code 438
 */
public class AnagramSubStringSearch {
    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
//        System.out.println("Enter the main string");
        String string = "";
//        System.out.println("Enter the sub string");
        String subString = "a";

        List<Integer> indexes = anagramSearch(string, subString);
        System.out.println(indexes);
    }

    private static List<Integer> anagramSearch(String string, String subString) {
        if(subString.length() > string.length()) return new ArrayList<>();
        Map<Character, Integer> subStringFreqMap = new HashMap<>();
        Map<Character, Integer> stringFreqMap = new HashMap<>();
        List<Integer> indexes = new ArrayList<>();
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
            indexes.add(0);
        }

        for(int i=subString.length() ; i < string.length(); i++) {
            Character previousCharacter = string.charAt(i-subString.length());
            if(stringFreqMap.containsKey(previousCharacter)) {
                Integer prevCharacterFreq = stringFreqMap.get(previousCharacter);
                if(prevCharacterFreq == 1) {
                    stringFreqMap.remove(previousCharacter); // should not insert with freq 0.
                } else {
                    stringFreqMap.put(previousCharacter, --prevCharacterFreq);
                }
            }

            Character newCharacter = string.charAt(i);
            Integer newCharacterFreq = stringFreqMap.getOrDefault(newCharacter, 0);
            stringFreqMap.put(newCharacter, ++newCharacterFreq);

            if(stringFreqMap.equals(subStringFreqMap)) {
                System.out.println("Found At:" + (i-subString.length() + 1));
                indexes.add(i-subString.length() + 1);
            }

        }
        return indexes;
    }
}
