package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.Scanner;

public class BTDistanceBetweenNodes {
    public static int commonAncestorLevel = 0;
    public static int node1Level = 0;
    public static int node2Level = 0;
    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter node 1:");
        int node1 = s.nextInt();
        System.out.println("Enter node 2:");
        int node2 = s.nextInt();
        BinaryTreeNode commonAncestor = getLeastCommonAncestorWithItsLevel(rootNode, node1, node2, commonAncestorLevel);
        System.out.println("Common Ancestor for given nodes is: " + commonAncestor.data);
        if(node1 == rootNode.data || node2 == rootNode.data) {
            commonAncestorLevel = 0;
        }
        if(node1Level > 0 && node2Level ==0) {
            commonAncestorLevel = node1Level;
        }
        if(node2Level > 0 && node1Level ==0) {
            commonAncestorLevel = node2Level;
        }
        System.out.println("commonAncestorLevel is: " + commonAncestorLevel);
        System.out.println("node1Level is: " + node1Level);
        System.out.println("node2Level is: " + node2Level);
    }

    private static BinaryTreeNode getLeastCommonAncestorWithItsLevel(BinaryTreeNode node, int n1, int n2, int level) {
        if(node == null) {
            return null;
        }
        if(node.data == n1) {
            node1Level = level;
            return node;
        }
        if(node.data == n2) {
            node2Level = level;
            return node;
        }
        BinaryTreeNode leftCommonAncestor = getLeastCommonAncestorWithItsLevel(node.left, n1, n2, level+1);
        BinaryTreeNode rightCommonAncestor = getLeastCommonAncestorWithItsLevel(node.right, n1, n2, level+1);

        if(leftCommonAncestor != null && rightCommonAncestor != null) {
            // it means that both are present in left and right of the current node, so the current node is the common ancestor
            commonAncestorLevel = level;
            return node;
        }
        return leftCommonAncestor != null ? leftCommonAncestor : rightCommonAncestor;
    }
}
