package linkedlist;

import solutions.linkedList.ListNode;

public class RemoveNthNode {

	/**
	 * @param args
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		if (n == 0) return head;
		ListNode sudo = new ListNode(0);
		sudo.next = head;
		ListNode hi = sudo;
		ListNode lo = sudo;
		while (hi.next != null){
			hi = hi.next;
			if (n == 0) lo = lo.next;
			if (n > 0) n--;
		}
		ListNode next = lo.next.next;
		lo.next.next = null;
		lo.next = next;
		return sudo.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
