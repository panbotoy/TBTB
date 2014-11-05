package solutions.linkedList;

import java.util.Stack;

public class ReorderList {

	/**
	 * @param args
	 */
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null || head.next.next == null) return;
        ListNode mid = getMidNode(head);
        ListNode rightHalfHead = mid.next;
        mid.next = null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (rightHalfHead != null){
        	stack.push(rightHalfHead);
        	rightHalfHead = rightHalfHead.next;
        }
        while (head != null && !stack.isEmpty()){
        	ListNode next = head.next;
        	ListNode insertNode = stack.pop();
        	insertNode.next = next;
        	head.next = insertNode;
        	head = next;
        }
    }
    ListNode getMidNode (ListNode head){
    	ListNode fast = head;
    	ListNode slow = head;
    	while (fast.next != null && fast.next.next!= null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
