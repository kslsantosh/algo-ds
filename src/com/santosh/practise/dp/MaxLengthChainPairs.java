package com.santosh.practise.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Leetcode 646
 */
public class MaxLengthChainPairs {

    public static void main(String[] args) {
//        int[] pairsArray = new int[]{5, 24, 39, 60, 15, 28, 27, 40, 50, 90};
//        int[] pairsArray = new int[]{1, 2, 2, 3, 3, 4};
        int[] pairsArray = new int[]{-10,-8,8,9,-5,0,6,10,-6,-4,1,7,9,10,-4,7};

        List<Pair> pairs = new ArrayList<>();


        for(int i = 0; i < pairsArray.length-1 ; i = i+2) {
            Pair pair = new Pair(pairsArray[i], pairsArray[i+1]);
            pairs.add(pair);
        }

        List<Pair> chainPairs = getMaxLengthChainPairs(pairs);
        System.out.println("Result"  + chainPairs);
    }

    private static List<Pair> getMaxLengthChainPairs(List<Pair> pairs) {
        List<Pair> result = new ArrayList<>();

        // first sort the pairs in ascending order with respect to second attribute.
        Comparator<Pair> secondElementComparator = (Pair o1, Pair o2) -> o1.second - o2.second;
        Collections.sort(pairs, secondElementComparator);

        System.out.println("After sorting pairs are" + pairs);

        // Always the first element will be considered because logically that should be in the chain.
        Pair previousPair = pairs.get(0);
        result.add(previousPair);

        for(int i = 1; i < pairs.size(); i++) {
            Pair currentPair = pairs.get(i);
            if(currentPair.first > previousPair.second) {
                result.add(currentPair);
                previousPair = currentPair;
            } else {
                // no need to consider this pair.
                continue;
            }
        }
        return result;
    }
}

class Pair {

    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + "  " + second;
    }
}
