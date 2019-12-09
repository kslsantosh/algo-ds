package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    int maxLength = 1;
    List<Integer> sequenceList = new ArrayList<>();
    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        obj.findLongestConsecutivePath(rootNode);
        System.out.println("Max length is::" + obj.maxLength);
    }

    private void findLongestConsecutivePath(BinaryTreeNode rootNode) {
         this.getPathOfConsecutive(rootNode, 0, rootNode.data);
    }

    private void getPathOfConsecutive(BinaryTreeNode rootNode, int currentLength, int nextElementRequired) {
        if(rootNode == null) {
            return;
        }
        if(nextElementRequired == rootNode.data) {
            currentLength++;
            sequenceList.add(rootNode.data);

            if(this.maxLength < currentLength) {
                this.maxLength = currentLength;
            }
            System.out.println(" IF Visited " + rootNode.data + " current length " + currentLength);
        } else {
            System.out.println("ELSE Visited " + rootNode.data + " current length " + currentLength);
            currentLength = 1;
        }
        getPathOfConsecutive(rootNode.left, currentLength, rootNode.data+1);
        getPathOfConsecutive(rootNode.right, currentLength, rootNode.data+1);
    }
}
