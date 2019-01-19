package com.santosh.practise.trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MirrorTree {
	
	static Node root = new Node(null, null, 1);
	static List<Integer> beforeMirror = new ArrayList<Integer>();
	static List<Integer> afterMirror = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		// Scan the input and form a tree
		Scanner s = new Scanner(System.in);
		int inputCount = s.nextInt();
		int testCount = s.nextInt();
		
		System.out.println("input count" + inputCount);
		System.out.println("test cases count" + testCount);
		
		for(int i = 1; i < inputCount; i++) {
			int parentNode = s.nextInt();
			int childNode = s.nextInt();
			String direction = s.next();
			insertHelper(root, parentNode, childNode, direction);			
		}
		
		System.out.println("Done inputting nodes");
		
		System.out.println("Preorder before mirroring");
		printPreorder(root);
		
		// Now mirror the tree
		mirrorTree(root);
		
		printPreorder(root);
				
		// Scan the required mirror nodes
		List<Integer> testCases = new ArrayList<>();
		for (int i = 0; i < testCount; i ++) {
			testCases.add(s.nextInt());
		}
		
		System.out.println("Testcases are");
		for(int i : testCases) {
			System.out.println(beforeMirror.get(afterMirror.indexOf(i))); 
		}
	}
	
	
	private static void mirrorTree(Node root) {
		if(root != null) {
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			
			mirrorTree(root.left);
			mirrorTree(root.right);
		}
	}

	private static void insertHelper(Node root, int parent, int data, String direction) {
		
		if(root != null) {
			if(root.data == parent) {
				// Found the parent node, create a node and add it to the direction given
				Node newNode = new Node(null, null, data);
				
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
	
	private static void printPreorder(Node root) {
		if(root != null) {
			System.out.println(root.data);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
}

class Node {
	Node left, right;
	int data;
	
	Node(Node left, Node right, int data) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
}
