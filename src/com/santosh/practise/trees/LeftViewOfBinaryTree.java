package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

public class LeftViewOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = new BinaryTreeNode();
        int maxLevel = Integer.MIN_VALUE;
        printRightViewOfBinaryTree(rootNode, 0, maxLevel);
    }

    private static void printRightViewOfBinaryTree(BinaryTreeNode rootNode, int currentLevel, int maxLevel) {
        if(rootNode == null) {
            return;
        }

        if(currentLevel > maxLevel) {
            System.out.println(rootNode.data);
            maxLevel = currentLevel;
        }
        printRightViewOfBinaryTree(rootNode.right, currentLevel+1, maxLevel);
        printRightViewOfBinaryTree(rootNode.left, currentLevel+1, maxLevel);
    }
}
