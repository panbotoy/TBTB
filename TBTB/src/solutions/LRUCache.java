package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import solutions.linkedList.DoublyLinkedListNode;

/**
 * This solution has problems: 1. needs to update keyPositionMap whenever there
 * is a delete 2. keyList.remove is O(n)
 * 
 * We probably can implement our own doublylinkedList
 * **/
public class LRUCache {
	private int capacity = 0;
	private HashMap<Integer, Integer> keyValueMap = new HashMap<Integer, Integer>();
	private HashMap<Integer, DoublyLinkedListNode> keyPositionMap = new HashMap<Integer, DoublyLinkedListNode>();
	private DoublyLinkedList keyList = new DoublyLinkedList();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (keyValueMap.containsKey(key)) {
			DoublyLinkedListNode pos = keyPositionMap.get(key);
			keyList.remove(pos);
			DoublyLinkedListNode node = new DoublyLinkedListNode(key);
			keyList.addLast(node);
			keyPositionMap.put(key, node);
			
			this.keyList.printList();
			System.out.println("Got: " + key + "::" + keyValueMap.get(key));
			return keyValueMap.get(key);
		} else {
			this.keyList.printList();
			System.out.println("No key: " + key + "::" + -1);
			return -1;
		}
		
	}

	public void set(int key, int value) {
		if (keyValueMap.containsKey(key)) {
			DoublyLinkedListNode pos = keyPositionMap.get(key);
			keyList.remove(pos);
			DoublyLinkedListNode node = new DoublyLinkedListNode(key);
			keyList.addLast(node);
			keyPositionMap.put(key, node);
			keyValueMap.put(key, value);
		} else if (keyValueMap.size() < this.capacity) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(key);
			keyList.addLast(node);
			keyPositionMap.put(key, node);
			keyValueMap.put(key, value);
		} else {
			int LRUKey = keyList.popFirst();
			/**
			 * Instead of getFirst, we need pop first here!
			 * **/
			keyPositionMap.remove(LRUKey);
			keyValueMap.remove(LRUKey);
			DoublyLinkedListNode node = new DoublyLinkedListNode(key);
			keyList.addLast(node);
			keyPositionMap.put(key, node);
			keyValueMap.put(key, value);
		}
		this.keyList.printList();
	}

	private class DoublyLinkedListNode {
		int val;
		DoublyLinkedListNode previous;
		DoublyLinkedListNode next;

		public DoublyLinkedListNode(int val) {
			this.val = val;
			previous = null;
			next = null;

		}
	}

	private class DoublyLinkedList {
		DoublyLinkedListNode head;
		DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			head = null;
			tail = null;
		}

		public void addFirst(int val) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(val);
			this.addFirst(node);
		}

		public void addLast(int val) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(val);
			this.addLast(node);
		}

		public void addFirst(DoublyLinkedListNode node) {
			if (this.head == null) {
				this.head = node;
				this.tail = node;
			} else {
				node.next = this.head;
				this.head.previous = node;
				this.head = node;
			}
		}

		public void addLast(DoublyLinkedListNode node) {
			if (this.tail == null) {
				this.tail = node;
				this.head = node;
			} else {
				node.previous = this.tail;
				this.tail.next = node;
				this.tail = node;
			}
		}

		public void remove(DoublyLinkedListNode node) {
			if (node != head && node != tail) {
				node.previous.next = node.next;
				node.next.previous = node.previous;
			} else {
				if (node == head) {
					this.head = node.next;
					if (node.next != null)
						node.next.previous = null;
				}
				if (node == tail) {
					this.tail = node.previous;
					if (node.previous != null)
						node.previous.next = null;
				}
			}

		}

		public int getFirst() {
			if (head != null)
				return head.val;
			return -1;
		}

		public int popFirst() {
			if (head != null) {
				int result = this.head.val;
				this.remove(this.head);
				return result;
			}
			return -1;
		}
		
		public void printList(){
			if ( this.head == null) System.out.println("null");
			StringBuilder sb = new StringBuilder();
			DoublyLinkedListNode node = this.head;
			while (node!=null){
				sb.append(node.val).append("--");
				node = node.next;
			}
			System.out.println(sb.toString());
		}
	}
}
