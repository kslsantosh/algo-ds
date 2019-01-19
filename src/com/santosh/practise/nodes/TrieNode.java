package com.santosh.practise.nodes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TrieNode {
	public Map<Character, TrieNode> children;
	public Boolean endOfWord = false;
	public Character data;
	
	public TrieNode(Character c) {
		children = new HashMap<Character,TrieNode>();
		data = c;
	}
}
