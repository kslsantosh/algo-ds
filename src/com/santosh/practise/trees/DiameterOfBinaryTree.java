package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

/**
 * LeetCode 543
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        Integer diameterOfBinaryTree = findDiameterOfBinaryTree(rootNode);
        System.out.println("Diameter of Given Node is is: " + diameterOfBinaryTree);
    }

    private static Integer findDiameterOfBinaryTree(BinaryTreeNode rootNode) {

    }
}
