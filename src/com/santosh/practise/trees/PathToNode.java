package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PathToNode {
    public static void main(String[] args) {
        List<Integer> pathToNode = new ArrayList<>();
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the node: ");
        Integer nodeToFind = s.nextInt();
        getPathToNode(rootNode, nodeToFind, pathToNode);
        pathToNode.forEach(a -> System.out.println(a));
    }

    private static boolean getPathToNode(BinaryTreeNode rootNode, Integer nodeToFind, List<Integer> pathToNode) {
        if(rootNode == null) {
            return false;
        }
        if(rootNode.data == nodeToFind) {
            pathToNode.add(rootNode.data);
            return true;
        }
        pathToNode.add(rootNode.data);

        boolean foundInLeft = getPathToNode(rootNode.left, nodeToFind, pathToNode);
        if(foundInLeft) {
            return true;
        }
        boolean foundInRight = getPathToNode(rootNode.right, nodeToFind, pathToNode);
        if(foundInRight) {
            return true;
        }
        pathToNode.remove(pathToNode.size()-1);
        return false;
    }
}
