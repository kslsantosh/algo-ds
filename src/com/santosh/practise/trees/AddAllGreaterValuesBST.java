package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class AddAllGreaterValuesBST {
    public static void main(String[] args) {
        BinaryTreeNode root = TreeBuilder.buildBinaryTree();
        System.out.println("Before Adding");
        printPreOrder(root);
        System.out.println("After Adding");
        addElementsGreaterThanItsElementInBST(root);
        printPreOrder(root);
    }

    private static void addElementsGreaterThanItsElementInBST(BinaryTreeNode root) {
        addSum(root, 0);
    }

    private static int addSum(BinaryTreeNode root, int sum) {
        if(root == null) return 0;

        int rsum = addSum(root.right, sum);

        int newsum = root.data + rsum + sum;
        root.data = newsum;

         int sumfromleft = addSum(root.left, newsum);

        return newsum;
    }


    private static void printPreOrder(BinaryTreeNode root) {
        if(root != null) {
            System.out.println(root.data);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }
}
