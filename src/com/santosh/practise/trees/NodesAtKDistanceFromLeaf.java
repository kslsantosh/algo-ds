package com.santosh.practise.trees;

import com.santosh.practise.nodes.BinaryTreeNode;

import java.util.*;

public class NodesAtKDistanceFromLeaf {

    public static void main(String[] args) {
        BinaryTreeNode rootNode = TreeBuilder.buildBinaryTree();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the distance from root");
        int k = s.nextInt();
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        printNodesAtKLevelsFromLeaf(rootNode, path, visited, 0, k);
    }

    private static void printNodesAtKLevelsFromLeaf(BinaryTreeNode rootNode, List<Integer> path, Set<Integer> visited, int level, int k) {
        path.add(rootNode.data);

        if(rootNode.left == null && rootNode.right == null) {
            // this is the leaf node.
            System.out.println("Leaf node @ level" + level + " Value: " + rootNode.data);
            int indexToFind = level-k;
            System.out.println("IndexToFind: " + indexToFind);
            System.out.println("Path" + path);

            if(indexToFind >=0 && ! visited.contains(path.get(indexToFind))) {
                System.out.println(path.get(indexToFind));
                visited.add(path.get(indexToFind));
            }
        } else {
            if(rootNode.left != null)
                printNodesAtKLevelsFromLeaf(rootNode.left, path, visited, level+1, k);
            if(rootNode.right != null)
                printNodesAtKLevelsFromLeaf(rootNode.right, path, visited, level+1, k);
        }

        path.remove(path.size()-1);
    }
}
