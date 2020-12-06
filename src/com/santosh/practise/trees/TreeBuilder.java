package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.Scanner;

public class TreeBuilder {

    public static BinaryTreeNode buildBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode(null, null, 50);
        System.out.println("Input number of nodes");
        Scanner s = new Scanner(System.in);
        int totalNodes = s.nextInt();
        System.out.println("Total number of nodes: " + totalNodes);

        for(int i = 1; i < totalNodes; i++) {
            int parentNode = s.nextInt();
            int childNode = s.nextInt();
            String direction = s.next();
            insertHelper(root, parentNode, childNode, direction);
        }
        //s.close();
        return root;
    }

    private static void insertHelper(BinaryTreeNode root, int parent, int data, String direction) {

        if(root != null) {
            if(root.data == parent) {
                // Found the parent node, create a node and add it to the direction given
                BinaryTreeNode newNode = new BinaryTreeNode(null, null, data);

                if(direction.equals("L")) {
                    root.left = newNode;
                }
                if(direction.equals("R")) {
                    root.right = newNode;
                }
            }
            else {
                insertHelper(root.left, parent, data, direction);
                insertHelper(root.right, parent, data, direction);
            }
        }
    }

    public static void printPreorder(BinaryTreeNode root) {
        System.out.println("Pre order of the given tree:");
        if(root != null) {
            System.out.println(root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }
}
