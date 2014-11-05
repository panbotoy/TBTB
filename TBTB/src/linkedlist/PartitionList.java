package linkedlist;

import solutions.linkedList.ListNode;

public class PartitionList {

	/**
	 * @param args
	 * 
	 * 1. use sudo head 
	 * 2. need to deal with some special cases when lo is the same with hi at first
	 */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode pseudoHead = new ListNode(1);
        pseudoHead.next = head;
        ListNode hi = pseudoHead;
        ListNode lo = pseudoHead;
        while(hi.next != null){
        	if (hi.next.val >= x ){
        		hi = hi.next;
        	}
        	else if (hi == lo){
        		lo = lo.next;
        		hi = hi.next;
        	}
        	else {
        		ListNode next = lo.next;
        		ListNode move = hi.next;
        		hi.next = move.next;
        		move.next = next;
        		lo.next = move;
        		lo = lo.next;
        	}
        }
        return pseudoHead.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
