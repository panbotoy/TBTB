package solutions.linkedList;

public class LinkedListCycle {
    public boolean hasCycleReverse(ListNode head) {
        if (head == null || head.next == null)
        {
            return false;
        }
    	ListNode originalHead = head;
    	ListNode reversedHead = this.reverseLinkedList(head);
    	return originalHead == reversedHead;       
    }
    
    public ListNode reverseLinkedList(ListNode head){
    	ListNode last = null;
    	ListNode current = head;
    	ListNode next;
    	while (current != null)
    	{
    		next = current.next;
    		current.next = last;
    		last = current;
    		current = next;
    	}
    	return last;
    }
    
    public boolean hasCycle(ListNode head){
    	if(head == null) return false;
    	ListNode fast = head;
    	ListNode slow = head;
    	while (fast != null && fast.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;
    		if (fast == slow) {
    			return true;
    		} 
    	}
    	return false;
    }
    
    public ListNode detectCycle(ListNode head){
    	if (head == null) return null;
    	ListNode fast = head;
    	ListNode slow = head;
    	ListNode detect = head;
    	boolean hasCycle = false;
    	while (fast != null && fast.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    		if (fast == slow){
    			hasCycle = true;
    			break;
    		}
    	}
    	if (hasCycle){
    		while (detect != slow) {
    			detect = detect.next;
    			slow = slow.next;
    		}
    		return detect;
    	} else{
    		return null;
    	}
    }
}
