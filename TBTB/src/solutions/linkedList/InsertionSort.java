package solutions.linkedList;

public class InsertionSort {

	/**
	 * @param args
	 */
    public ListNode insertionSortList(ListNode head) {
    	ListNode ret = null;
    	while (head != null){
    		ListNode next = head.next;
    		head.next = null;
    		ret = this.insertNodeRec(ret, head);
    		head = next;
    	}
    	return ret;
    }
    
    private ListNode insertNodeRec(ListNode ret, ListNode head){
    	if (ret == null) return head;
    	if (ret.val <= head.val){
    		ret.next = insertNodeRec(ret.next, head);
    		return ret;
    	} else {
    		head.next = ret;
    		return head;
    	}
    }
    
    
    private ListNode insertNode ( ListNode head, ListNode node ){
    	if (node.val <= head.val) {
    		node.next = head;
    		head = node;
    		return head;
    	} else {
    		ListNode ret = head;
    		while (head != null){
    			if (head.next == null) {
    				head.next = node;
    				return ret;
    			} 
    			else if (node.val <= head.next.val){
    				node.next = head.next;
    				head.next = node;
    				return ret;
    			} else {
    				head = head.next;
    			}
    		}
    		return ret;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
