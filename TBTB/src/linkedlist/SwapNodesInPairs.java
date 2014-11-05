package linkedlist;

import solutions.linkedList.ListNode;

public class SwapNodesInPairs {

	/**
	 * @param args
	 * 
	 * The first question is quite easy. We just need to be careful with moving
	 * the pointers
	 */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sudo = new ListNode(1);
        sudo.next = head;
        ListNode curr = sudo;
        while(curr.next != null && curr.next.next != null){
        	ListNode next = curr.next.next.next;
        	ListNode node2 = curr.next.next;
        	ListNode node1 = curr.next;
        	curr.next = node2;
        	node2.next = node1;
        	node1.next = next;
        	curr = node1;
        }
        return sudo.next;
    }
    
    /**
     * 
     * Algorithm:
     * move hi to the kth node,
     * reverse lo to hi,
     * points lo.next.next -> hi.next;
     * points lo.next -> hi
     * needs to be careful:
     * 1. For the reverse method, pass by value or pass by reference.
     * Need to return the new tail, otherwise the reference for lo and hi will not change
     * 
     * 2. also need to be careful after do the reverse, the new tail has changed, is not hi anymore
     * ****/
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k==1) return head;
        ListNode sudo = new ListNode(1);
        sudo.next = head;
        ListNode lo = sudo;
        ListNode hi = sudo;
        int counter = 0;
        while (hi!= null){
        	if (counter < k){
        		hi = hi.next;
        		counter++;
        	} else {
        		counter = 0;
        		lo = reverse(lo, hi);
        		hi = lo;
        	}
        }
        return sudo.next;
    }
    
    private ListNode reverse(ListNode lo, ListNode hi){
    	ListNode nextHead = hi.next;
    	ListNode curr = lo.next;
    	ListNode prev = lo;
    	while (curr != nextHead){
    		ListNode next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	ListNode tail = lo.next;
    	lo.next.next = curr;
    	lo.next = prev;
    	return tail;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
