package com.santosh.practise.trees;

import java.util.Map;

import com.santosh.practise.nodes.TrieNode;

public class Trie {
	
	TrieNode root = new TrieNode(' ');
	
	public void insert(String word) {
		
		TrieNode currentNode = root;
		
		for(int i = 0 ; i < word.length() ; i++) {
			
			Character currentChar = word.charAt(i);
			
			if(currentNode.children.containsKey(currentChar)) {
				currentNode = currentNode.children.get(currentChar);
			}
			else {
				// create a new node
				TrieNode newNode = new TrieNode(currentChar);
				currentNode.children.put(currentChar, newNode);
				currentNode = newNode;
			}
		}
		currentNode.endOfWord = true;
	}
	
	public Boolean search(String searchKey) {
		TrieNode currentNode = root;
		Map<Character, TrieNode> children = currentNode.children;
 		
		for(int i = 0; i < searchKey.length(); i++) {
			Character currentChar = searchKey.charAt(i);
			if(! children.containsKey(currentChar)) {
				return false;
			}
			else {
				children = children.get(currentChar).children;
			}
		}
		return true;
	}
}