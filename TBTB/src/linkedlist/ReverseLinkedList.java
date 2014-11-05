package linkedlist;

import solutions.linkedList.ListNode;

public class ReverseLinkedList {

	/**
	 * @param args
	 * 
	 * This is a very nice code write up
	 * 
	 * The key is that :
	 * 1. a normal reverse linked list
	 * 2. reverse from Mth node to Nth node.
	 * 3. Mth.next.next = Nth
	 *    Mth.next = Nth.oldnext
	 *    
	 *    Use the example in the question, 2.next.next = 4. 2.next = 5
	 *    
	 * 4. then the only problem is to look for Mth node.
	 */
	public ListNode reverseBetween(ListNode head, int m, int n){
		if (head == null) return null;
		ListNode sudo = new ListNode(1);
		sudo.next = head;
		ListNode curr = head;
		ListNode prev = sudo;
		/**Move curr to Mth node and prev to M-1 th*/
		for (int i = 1; i < m; i++){
			curr = curr.next;
			prev = prev.next;
		}
		ListNode revHead = curr;
		ListNode next = curr.next;
		
		for (int i = m; i <= n; i++){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		revHead.next.next = prev;
		revHead.next = curr;
		return sudo.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
