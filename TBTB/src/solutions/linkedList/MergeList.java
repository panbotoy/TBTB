package solutions.linkedList;

public class MergeList {
    public ListNode sortList(ListNode head) {
        if (head == null ) return null;
        if (head.next == null) return head;
        ListNode mid = this.findMid(head);
        return this.merge(this.sortList(head), this.sortList(mid));
    }
    
    private ListNode findMid(ListNode head){
    	if (head == null) return null;
    	ListNode fast = head;
    	ListNode slow = head;
    	while (fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	ListNode node = slow.next;
    	slow.next = null;
    	return node;
    }
    
    private ListNode merge(ListNode head, ListNode mid){
    	if (head == null) return mid;
    	if (mid == null) return head;
    	ListNode headNew = null;
    	ListNode headRet = null;
        headRet = (head.val <= mid.val)? head: mid;
        if (head.val <= mid.val ) {
        	headRet = head;
        	headNew = head;
        	head = head.next;
        } else {
        	headRet = mid;
        	headNew = mid;
        	mid = mid.next;
        }
    	while (head != null && mid != null){
    	    if (head.val <= mid.val){
    	        headNew.next = head;
    	        headNew = headNew.next;
    	        head = head.next;
    	    } else {
    	        headNew.next = mid;
    	        headNew = headNew.next;
    	        mid = mid.next;
    	    }
    	}
    	headNew.next = mid == null ? head : mid;
    	return headRet;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
