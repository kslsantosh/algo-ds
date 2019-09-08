package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.*;

public class TopViewTree {
    static Map<Integer, Integer> hdMap = new HashMap<>();
    static Map<BinaryTreeNode, Integer> nodeHdMap = new HashMap<>();
    static int minHd = 0;
    static int maxHd = Integer.MIN_VALUE;

    public static void main(String[] args) {

        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        createHdMap(rootNode);
        printTopView(minHd, maxHd, hdMap);
    }

    private static void printTopView(int minHd, int maxHd, Map<Integer, Integer> hdMap) {
        for(int i = minHd; i <= maxHd; i++) {
            System.out.println(hdMap.get(i));
        }
    }

    private static void createHdMap(BinaryTreeNode rootNode) {
        if(rootNode == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        hdMap.put(0, rootNode.data);
        nodeHdMap.put(rootNode, 0);

        while (! queue.isEmpty()) {
            BinaryTreeNode currentNode = queue.poll();
            int currentNodeHd = nodeHdMap.get(currentNode);
            if(currentNodeHd < minHd) minHd = currentNodeHd;
            if(currentNodeHd > maxHd) maxHd = currentNodeHd;

            if(! hdMap.containsKey(currentNodeHd)) {
                hdMap.put(currentNodeHd, currentNode.data);
            }

            if(currentNode.left != null) {
                queue.add(currentNode.left);
                nodeHdMap.put(currentNode.left, currentNodeHd-1);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
                nodeHdMap.put(currentNode.right, currentNodeHd+1);
            }
        }
    }
}