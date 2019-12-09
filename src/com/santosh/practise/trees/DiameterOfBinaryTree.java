package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import javax.swing.tree.TreeNode;
import java.util.Scanner;
import java.util.stream.StreamSupport;

/**
 * LeetCode 543
 */
public class DiameterOfBinaryTree {

    public static Integer maxDiameter = 0;
    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();

        diameterOfBinaryTree(rootNode);
        System.out.println("Diameter of Given Node is is: " + maxDiameter);
    }

    public static int diameterOfBinaryTree(BinaryTreeNode rootNode) {
        int maxDiameter = 0;
        findDiameterOfBinaryTree(rootNode, 0);
        return ++maxDiameter;
    }

    private static Integer findDiameterOfBinaryTree(BinaryTreeNode rootNode, int currentLevel) {
        if(rootNode == null) {
            return currentLevel-1;
        }

        int depthLeft = findDiameterOfBinaryTree(rootNode.left, currentLevel+1);
        int depthRight = findDiameterOfBinaryTree(rootNode.right, currentLevel+1);

        int diameterWithThisNodeAsCenter = depthLeft + depthRight - 2 * currentLevel;
        System.out.println("Diameter @ Node" + rootNode.data + " = " + diameterWithThisNodeAsCenter);
        if(maxDiameter < diameterWithThisNodeAsCenter) {
            maxDiameter = diameterWithThisNodeAsCenter;
        }

        return Math.max(depthLeft, depthRight);
    }
}
