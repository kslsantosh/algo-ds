package com.santosh.practiseagain.trees;

import com.santosh.practise.trees.TreeBuilder;
import com.santosh.practise.nodes.BinaryTreeNode;

public class MirrorTree {
    public static void main(String[] args) {
        BinaryTreeNode root = TreeBuilder.buildBinaryTree();
        System.out.println("Before Mirror");
        printPreOrder(root);
        convertTreeToItsMirror(root);
        System.out.println("Before Mirror");
        printPreOrder(root);
    }

    private static void convertTreeToItsMirror(BinaryTreeNode root) {
        if(root != null) {
            BinaryTreeNode left = root.left;
            BinaryTreeNode right = root.right;

            BinaryTreeNode temp = left;
            root.left = right;
            root.right = temp;

            if(left != null) {
                convertTreeToItsMirror(left);
            }
            if(right != null) {
                convertTreeToItsMirror(right);
            }
        }
    }

    private static void printPreOrder(BinaryTreeNode root) {
        if(root != null) {
            System.out.println(root.data);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    private static boolean checkIfTwoTreesAreMirrorOrNor(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        return root1.data == root2.data
                && checkIfTwoTreesAreMirrorOrNor(root1.left, root2.right)
                && checkIfTwoTreesAreMirrorOrNor(root1.right, root2.left);
    }

}
