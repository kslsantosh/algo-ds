package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class VerticalTraversal {
    static Map<Integer, LinkedList<Integer>> hdMap = new LinkedHashMap<>();
    static int minHd = Integer.MAX_VALUE;
    static int maxHd = Integer.MIN_VALUE;

    public static void main(String[] args) {

        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        createHdMap(rootNode, 0);
        printVerticalOrder(minHd, maxHd, hdMap);
    }

    private static void printVerticalOrder(int minHd, int maxHd, Map<Integer, LinkedList<Integer>> hdMap) {
        for(int i = minHd; i <= maxHd; i++) {
            System.out.println("Level: " + i);
            System.out.println(hdMap.get(i));
        }
    }

    private static void createHdMap(BinaryTreeNode rootNode, Integer hd) {
        if(rootNode == null) return;

        if(minHd > hd) minHd = hd;
        if(maxHd < hd) maxHd = hd;
        
        LinkedList<Integer> nodesAtSameLevel = hdMap.getOrDefault(hd, new LinkedList<>());
        nodesAtSameLevel.add(rootNode.data);
        hdMap.put(hd, nodesAtSameLevel);
        createHdMap(rootNode.left, hd-1);
        createHdMap(rootNode.right, hd+1);
    }
}