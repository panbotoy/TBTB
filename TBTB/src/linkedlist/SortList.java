package linkedlist;

import solutions.linkedList.ListNode;

public class SortList {

	/**
	 * @param args
	 * 
	 * 1. needs to think about the process for merge sort
	 * 
	 * envolves split and merge two steps
	 */
    public ListNode sortList(ListNode head) {
    	if (head == null) return null;
    	if (head.next == null) return head;
    	ListNode fast = head.next.next;
    	ListNode slow = head;
    	while (fast != null && fast.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	ListNode head2 = slow.next;
    	slow.next = null;
    	ListNode sorted1 = sortList(head);
    	ListNode sorted2 = sortList(head2);
    	return merge(sorted1, sorted2);
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
    	if (l1 == null && l2 == null) return null;
    	ListNode sudo = new ListNode(1);
    	ListNode prev = sudo;
    	while (l1 != null || l2 != null){
    		int val1 = l1 == null? Integer.MAX_VALUE : l1.val;
    		int val2 = l2 == null? Integer.MAX_VALUE : l2.val;
    		if (val1 <= val2){
    			prev.next = l1;
    			l1 = l1.next;
    		} else {
    			prev.next = l2;
    			l2 = l2.next;
    		}
    		prev = prev.next;
    	}
    	return sudo.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
