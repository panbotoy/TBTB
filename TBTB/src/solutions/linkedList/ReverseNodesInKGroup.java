package solutions.linkedList;

public class ReverseNodesInKGroup {

	/**
	 * @param args
	 * 
	 * 1. be very careful, linkedlist questions can all be solved with recursion, think of some test cases and run them in mind
	 * 
	 * 2. try to do this in iteration 
	 */
	
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k <= 1) return head;
    	ListNode groupHead = this.reverseHelper(head, null, head, k, k);
    	return groupHead;
    }
	/**if list.length < k, return head, don't reverse, if >= k, return last node in group, and reverse nodes***/
	private ListNode reverseHelper(ListNode groupHead, ListNode prev, ListNode node, int k, int groupSize){
		if (k==1){   // deal with next group head.
			if (node == null) return null;
			ListNode nextGroupHead = node.next;
			node.next = prev;
		 	groupHead.next = this.reverseHelper(nextGroupHead, null, nextGroupHead, groupSize, groupSize);
		 	return node;
		}
		else {    // deal with next node
			if (node.next == null) return groupHead;
			else{
				ListNode newHead = this.reverseHelper(groupHead, node, node.next, k-1, groupSize);
				if (newHead == groupHead) return groupHead;
				else {
					if (prev != null) node.next = prev;
					return newHead;
				}
			}	
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
