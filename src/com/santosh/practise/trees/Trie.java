package com.santosh.practise.trees;

import java.util.ArrayList;
import java.util.List;
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

	public void prefixSearch(String prefix) {
		TrieNode currentNode = root;

		for(int i = 0; i < prefix.length(); i++) {
			Character currentChar = prefix.charAt(i);
			if(currentNode.children.containsKey(currentChar)) {
				currentNode = currentNode.children.get(currentChar);
			} else {
			    System.out.println("No items found with given prefix");
			    break;
            }
		}
		// now we got the current node here. we need to recursively find the branches of it to print all the characters.
        List<String> results = new ArrayList<>();
        System.out.println("Current Node" + currentNode.data);

		findPossibleStrings(currentNode, results, prefix);

		System.out.println("Possible Strings" + results);
	}

    private void findPossibleStrings(TrieNode currentNode, List<String> results, String prefix) {
	    for(TrieNode n : currentNode.children.values()) {
	        prefix = prefix + n.data;
	        if(n.children.isEmpty()) {
	            results.add(prefix);
	            if(n.endOfWord) {
                    results.add(prefix);
	                findPossibleStrings(n, results, prefix);
                }
            } else {
	            findPossibleStrings(n, results, prefix);
            }
        }
	}
}