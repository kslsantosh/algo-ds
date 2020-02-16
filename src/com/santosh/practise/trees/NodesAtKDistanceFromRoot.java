package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.Scanner;

    public class NodesAtKDistanceFromRoot {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the distance from root");
        int k = s.nextInt();
        printNodesAtGivenDistance(rootNode, 0, k);
    }

    private static void printNodesAtGivenDistance(BinaryTreeNode rootNode, int currentDistance, int k) {
        if(rootNode == null)
            return;
        if(currentDistance == k) {
            System.out.println(rootNode.data);
        } else {
            printNodesAtGivenDistance(rootNode.left, currentDistance+1, k);
            printNodesAtGivenDistance(rootNode.right, currentDistance+1, k);
        }
    }
}
