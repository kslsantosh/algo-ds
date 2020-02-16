package com.santosh.practise.trees;

import apple.laf.JRSUIUtils;
import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BTLeastCommonAncestor {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter node 1:");
        int node1 = s.nextInt();
        System.out.println("Enter node 2:");
        int node2 = s.nextInt();
        findLeastCommonAncestor(rootNode, node1, node2);
    }

    private static void findLeastCommonAncestor(BinaryTreeNode rootNode, int node1, int node2) {
        List<Integer> pathToNode1 = new ArrayList<>();
        List<Integer> pathToNode2 = new ArrayList<>();
        findPathToNode(rootNode, node1, pathToNode1);
        findPathToNode(rootNode, node2, pathToNode2);
        System.out.println("Path to Node 1" + pathToNode1);
        System.out.println("Path to Node 2" + pathToNode2);
        if(pathToNode1.isEmpty()) {
            System.out.println("Node 1 " + node1 + " Not found in tree");
            return;
        }
        if(pathToNode2.isEmpty()) {
            System.out.println("Node 2 " + node2 + " Not found in tree");
            return;
        }
        for(int i = 0; i < pathToNode1.size(); i++) {
            if(! pathToNode1.get(i).equals(pathToNode2.get(i))) {
                System.out.println("Common Ancestor for given nodes is: " + pathToNode1.get(i-1));
                break;
            }
        }
    }

//    private static boolean findPathToNode(BinaryTreeNode rootNode, int nodeToFind, List<Integer> pathToNode) {
//
//        if(rootNode == null) {
//            return false;
//        }
//        if(rootNode != null && rootNode.data == nodeToFind) {
//            pathToNode.add(rootNode.data);
//            return true;
//        }
//        if(rootNode != null && rootNode.data != nodeToFind) {
//            pathToNode.add(rootNode.data);
//        }
//        if(rootNode != null) {
//            if(findPathToNode(rootNode.left, nodeToFind, pathToNode)) {
//                return true;
//            }
//            if(findPathToNode(rootNode.right, nodeToFind, pathToNode)) {
//                return true;
//            }
//        }
//        pathToNode.remove(pathToNode.size()-1);
//        return false;
//    }

    private static boolean findPathToNode(BinaryTreeNode rootNode, int nodeToFind, List<Integer> pathToNode) {

        if(rootNode == null) {
            return false;
        }
        pathToNode.add(rootNode.data);

        if(rootNode.data == nodeToFind) {
            return true;
        }

        boolean found = false;
        found = findPathToNode(rootNode.left, nodeToFind, pathToNode);

        if(! found) {
            found = findPathToNode(rootNode.right, nodeToFind, pathToNode);
        }

        if(found) return true;

        pathToNode.remove(pathToNode.size()-1);
        return false;
    }
}
