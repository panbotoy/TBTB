package solutions.linkedList;

public class DoublyLinkedList {
	DoublyLinkedListNode head;
	DoublyLinkedListNode tail;
	
	public DoublyLinkedList(){
		head = null;
		tail = null;
	}
	
	public void addFirst(int val){
		DoublyLinkedListNode node = new DoublyLinkedListNode(val);
		this.addFirst(node);
	}
	
	public void addLast(int val){
		DoublyLinkedListNode node = new DoublyLinkedListNode(val);
		this.addLast(node);
	}
	
	public void addFirst(DoublyLinkedListNode node){
		if (this.head == null){
			this.head = node;
			this.tail = node;
		} else {
			node.next = this.head;
			this.head.previous = node;
			this.head = node;
		}
	}
	
	public void addLast(DoublyLinkedListNode node){
		if (this.tail == null){
			this.tail = node;
			this.head = node;
		}
		else {
			node.previous = this.tail;
			this.tail.next = node;
			this.tail = node;
		}
	}
	
	public void remove(DoublyLinkedListNode node ){
		if (node == head){
			this.head = node.next;
			if (node.next != null) node.next.previous = null;
		} else if (node == tail){
			this.tail = node.previous;
			if (node.previous != null ) node.previous.next = null;
		} else{
			node.previous.next = node.next;
			node.next.previous = node.previous;
		}
	}
	
	public int getFirst(){
		if (head != null) return head.val;
		return -1;
	}
	
	public int popFirst(){
		if (head != null) 
		{
			int result = this.head.val;
			this.remove(this.head);
			return result;
		}
		return -1;
	}
}
