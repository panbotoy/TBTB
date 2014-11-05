package trie;

import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode<V> {
	String key;
	V value;
	HashMap<String, TrieNode<V>> children;
	
	public TrieNode(){
		this.key = "";
		this.value = null;
		this.children = new HashMap<String, TrieNode<V>>();
	}
	
	public TrieNode(String key, V value){
		this.key = key;
		this.value = value;
		this.children = new HashMap<String, TrieNode<V>>();
	}
	
	public void add(String key, V value){
		// todo add input parameter checks here
		if (key == null) return;
		this.addHelper(key, value, 0);
	}
	
	private void addHelper(String key, V value, int index){
		if (index == key.length()) return;
		TrieNode<V> node = null;
		if (this.children.containsKey(key.substring(index, index+1))){
			node = this.children.get(key.substring(index, index+1));
			if (index == key.length() -1) node.value = value;
		} else{
			node = new TrieNode<V>(key.substring(index, index+1), null);
			if (index == key.length() - 1) node.value = value;
			this.children.put(node.key, node);
		}
		node.addHelper(key, value, index+1);
	}
	
	public V get(String key){
		TrieNode<V> curr = this;
		// add code to check the input is valid
		if (key == null) return null;
		for (int i = 0; i < key.length(); i++){
			String s = key.substring(i, i+1);
			if (curr.children.containsKey(s)){
				curr = curr.children.get(s);
			} else {
				return curr.value;
			}
		}
		return curr.value;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieNode<String> trie = new TrieNode();
		trie.add("+1", "North America");
		trie.add("+1950", "North Cal");
		trie.add("+44", "UK");
		trie.add("+4420", "London");
		trie.add("+447", "UK Mobile");
		trie.add("+44750", "Vodafone");
		
		System.out.println(trie.get("+447508430954795"));
		System.out.println(trie.get("+44989045454"));
		System.out.println(trie.get("+123"));
	}

}
