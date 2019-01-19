package com.santosh.practise.drivers;

import com.santosh.practise.trees.Trie;

public class TrieDriver {

	public static void main(String[] args) {
		String words[] = {"Car", "Ball", "Santosh" , "Padmaja", "Venkatesh"};
		
		Trie trie = new Trie();
		
		for(int i = 0 ; i < words.length ; i++) {
			trie.insert(words[i]);
			System.out.println("Inserted" + words[i]);
		}
		
		if(trie.search("Venkatesh")) {
			System.out.println("Successful!!!!");
		}
	}
}
