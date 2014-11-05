package solutions.linkedList;

public class SwapNodesInPairs {

	/**
	 * @param args
	 */
	
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode nextHead = head.next.next;
        next.next = head;
        head.next = this.swapPairs(nextHead);
        return next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
