package solutions.linkedList;

import java.util.Stack;

public class RemoveDuplicateNode {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        while (head.next != null && head.val == head.next.val) head = head.next;
        ListNode headNode = head;
        ListNode lastNode = head;
        head = head.next;
        while (head!=null){
        	if (lastNode.val == head.val){
        		lastNode.next = head.next;
        		head.next = null;
        		head = lastNode.next;
        	}
        	else {
        		lastNode = head;
        		head = head.next;
        	}
        }
        return headNode;
    }
    
    public ListNode deleteDuplicatesWithStack(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head!=null) {
        	stack.push(head);
        	head = head.next;
        }
        ListNode lastNode = stack.pop();
        ListNode currentNode = lastNode;
        while(stack.size()!=0){
        	currentNode = stack.pop();
        	if (currentNode.val != lastNode.val){
        		currentNode.next = lastNode;
        		lastNode = currentNode;
        	}else {
        		currentNode = lastNode;
        	}
        }
        return currentNode;
    }
    
    public ListNode deleteDuplicatesRecursion(ListNode head) {
        if (head == null) return null;
        head.next = this.deleteDuplicateHelper(head.next, head.val);
        return head;
    }
    private ListNode deleteDuplicateHelper(ListNode head, int val){
    	if (head == null) return null;
    	if (head.val == val) {
    		return this.deleteDuplicateHelper(head.next, val);
    	} else{
    		head.next = deleteDuplicateHelper(head.next, head.val);
    		return head;
    	}
    }
    
    public ListNode deleteDuplicates2(ListNode head) {
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
//    private ListNode deleteDuplicateHelper2(boolean dup, ListNode last, ListNode current){
//    	if (current == null) return last;
//    	if (current.val == last.val){
//    		return this.deleteDuplicateHelper2(true, current, current.next);
//    	}
//    	else {
//    		if (!dup){
//	    		last.next = this.deleteDuplicateHelper2(current, current.next);
//	    		return last;
//    		} else{
//    			
//    		}
//    	}
//    }
}
