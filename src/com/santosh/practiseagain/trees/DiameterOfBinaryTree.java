package com.santosh.practiseagain.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

public class DiameterOfBinaryTree {
    int maxDiameter = 0;

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode();

        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        obj.findDiameter(root, 0);

        System.out.println("Max Diameter::" + obj.maxDiameter);
    }

    private int findDiameter(BinaryTreeNode root, int level) {

        if(root == null)
            return level-1;

        int leftDepth = findDiameter(root.left, level+1);
        int rightDepth = findDiameter(root.right, level+1);

        int diameterWithThisNodeAsCenter = leftDepth + rightDepth - 2 * level;

        this.maxDiameter = Math.max(diameterWithThisNodeAsCenter, this.maxDiameter);

        return Math.max(leftDepth, rightDepth);
    }
}
