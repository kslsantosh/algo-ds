package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

public class BoundaryTraversal {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        printBoundaryTraversal(rootNode);
    }

    private static void printBoundaryTraversal(BinaryTreeNode rootNode) {
        System.out.println(rootNode.data);
        printLeftView(rootNode.left);
        printLeafNodes(rootNode.left);
        printLeafNodes(rootNode.right);
        printRightView(rootNode.right);
    }

    private static void printRightView(BinaryTreeNode rootNode) {
        if(rootNode.right != null) {
            System.out.println(rootNode.data);
            printRightView(rootNode.right);
        } else if (rootNode.left != null) {
            System.out.println(rootNode.data);
            printRightView(rootNode.left);
        }
        // if both right and left of this node are null, ignore it. It will be printed by leaf node traversal.
    }

    private static void printLeafNodes(BinaryTreeNode root) {
        if(root.left != null) {
            printLeafNodes(root.left);
        }
        if(root.right != null) {
            printLeafNodes(root.right);
        }
        if(root.left == null && root.right == null) {
            System.out.println(root.data);
        }
    }

    private static void printLeftView(BinaryTreeNode rootNode) {

        if(rootNode.left != null) {
            System.out.println(rootNode.data);
            printLeftView(rootNode.left);
        } else if (rootNode.right != null) {
            System.out.println(rootNode.data);
            printLeftView(rootNode.right);
        }
        // if both right and left of this node are null, ignore it. It will be printed by leaf node traversal.
    }
}
