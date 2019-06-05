package com.santosh.practise.nodes;

public class BinaryTreeNode {
    public BinaryTreeNode left, right;
    public int data;

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}