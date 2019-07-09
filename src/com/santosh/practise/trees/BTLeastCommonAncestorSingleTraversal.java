package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.Scanner;

public class BTLeastCommonAncestorSingleTraversal {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter node 1:");
        int node1 = s.nextInt();
        System.out.println("Enter node 2:");
        int node2 = s.nextInt();
        BinaryTreeNode commonAncestor = getLeastCommonAncestor(rootNode, node1, node2);
        System.out.println("Common Ancestor for given nodes is: " + commonAncestor.data);
    }
    private static BinaryTreeNode getLeastCommonAncestor(BinaryTreeNode node, int n1, int n2) {
        if(node == null) {
            return null;
        }
        if(node.data == n1 || node.data == n2) {
            return node;
        }
        BinaryTreeNode leftCommonAncestor = getLeastCommonAncestor(node.left, n1, n2);
        BinaryTreeNode rightCommonAncestor = getLeastCommonAncestor(node.right, n1, n2);

        if(leftCommonAncestor != null && rightCommonAncestor != null) {
            // it means that both are present in left and right of the current node, so the current node is the common ancestor
            return node;
        }
        return leftCommonAncestor != null ? leftCommonAncestor : rightCommonAncestor;
    }
}
