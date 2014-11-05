package linkedlist;

import solutions.linkedList.ListNode;

public class RemoveDuplicateFromSortedList {

	/**
	 * @param args
	 * 
	 * 1. Be careful with the ending conditions etc.
	 * 2. recursive solution is too beautiful!
	 */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode sudo = new ListNode(0);
        sudo.next = head;
        while (head.next!=null){
            if (head.val == head.next.val){
                ListNode next = head.next.next;
                head.next.next = null;
                head.next = next;
            } else head = head.next;
        }
        return sudo.next;
    }
    
    
    /***
     * The iterative approach.
     * 
     * It needs to take more considerations. This is a good example to use test cases to verify code.
     * **/
    public ListNode deleteDuplicatesIIIter(ListNode head) {
        if (head == null) return null;
        ListNode sudo = new ListNode(0);
        ListNode prev = sudo;
        sudo.next = head;
        while ( head != null && head.next != null){
            if (head.val == head.next.val){
                while (head.next != null && head.val == head.next.val) 
                    head = head.next;
                prev.next = head.next;
                head = head.next;
            } else{
                prev = head;
                head = head.next;
            }
        }
        return sudo.next;
    }
    
    public ListNode deleteDuplicatesII(ListNode head) {
        if (head == null) return null;
        head = this.getNextNotDuplicateNode(false, head);
        return head;
    }
    
    /**
     * getNextNotDuplicateNode(boolean isCurrentNodeDup, ListNode current)
     * */
    private ListNode getNextNotDuplicateNode(boolean isCurrentNodeDup, ListNode current){
    	if (current == null) return null;
    	if (current.next == null) return isCurrentNodeDup?null:current;
    	if (isCurrentNodeDup) return this.getNextNotDuplicateNode(current.val == current.next.val, current.next);
    	else {
    		if (current.val != current.next.val){
    			current.next = this.getNextNotDuplicateNode(false, current.next);
    			return current;
    		}
    		else{
    			return this.getNextNotDuplicateNode(true, current.next);
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
