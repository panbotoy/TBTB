package solutions;

import java.util.HashMap;

public class LRU0922 implements LRUInterface {

	/**
	 * @param args
	 */
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	DoublyLinkedList list = new DoublyLinkedList();
	int capacity;
	int size;
	
	class Node {
		int key;
		int value;
		Node prev;
		Node next;
		public Node(int key, int value){
			this.key = key;
			this.value = value;
			prev = null;
			next = null;
		}
	}
	
	class DoublyLinkedList{
		Node head;
		Node tail;
		public void removeNode(Node node){
			if (head == null){
				return;
			}else{
			    if (node == head && node == tail){
                    head = null;
                    tail = null;
			    }
				else if (node == head){
					Node newHead = node.next;
					this.head = newHead;
					this.head.prev = null;
				} else if (node == tail){
					this.tail = node.prev;
					this.tail.next = null;
				} else {
					node.prev.next = node.next;
					node.next.prev = node.prev;
				}
			    node.next = null;
			    node.prev = null;
			}
		}
		public void addNode(Node node){
			if (tail == null){
				head = node;
				tail = node;
			}else{
				tail.next = node;
				node.prev = tail;
				tail = tail.next;
			}
		}
	}

	public void set(int key, int value) {
		// TODO Auto-generated method stub
		Node xin = new Node (key, value);
		if (map.containsKey(key)){
			Node old = map.get(key);
			list.removeNode(old);
			list.addNode(xin);
			map.put(key, xin);
		}else{
			if (this.size < this.capacity){
				this.size++;
				map.put(key, xin);
				list.addNode(xin);
			} else {
				Node old = list.head;
				list.removeNode(old);
				map.remove(old.key);
				list.addNode(xin);
				map.put(key, xin);
			}
		}
	}

	public int get(int key) {
		// TODO Auto-generated method stub
		if (map.containsKey(key)){
			Node res = map.get(key);
			list.removeNode(res);
			list.addNode(res);
			return res.value;
		}
		return -1;
	}
	
	public LRU0922(int capacity) {
		this.capacity = capacity;
		this.size = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
