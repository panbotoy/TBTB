package solutions.linkedList;

import java.util.Stack;

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	/**
	 * Try to use recursion and pointers also to do this
	 * */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int counter = 0;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = head;
        ListNode pseudoHead = null;
        ListNode pseudoTail = null;
        while (current != null){
        	counter ++;
        	if (counter == m - 1){
        		pseudoHead = current;
        		current = current.next;
        	}
        	if (counter < m - 1) {
        		current = current.next;
        	} if (counter >= m && counter <= n){
        		stack.push(current);
        		current = current.next;
        	} if (counter > n ){
        		pseudoTail = current.next;
        		if (pseudoHead != null) pseudoHead.next = current;
        		else pseudoHead = stack.peek();
        		while (!stack.isEmpty()){
        			ListNode node = stack.pop();
        			current.next = node;
        			node.next = pseudoTail;
        			current = current.next;
        		}
        		if (m == 1) return pseudoHead; 
        		break;
        	}
        }
        return head;
    }
    
    public ListNode reverseBetweenRC(ListNode head, int m, int n){
    	if (head == null) return null;
    	if (m == 1){
    		return this.reverseHelper(head, 1, n);
    	}
    	else {
    		int counter = 0;
    		ListNode current = head;
    		ListNode pseudoHead = head;
    		while (current!=null){
    			counter++;
    			if (counter == m - 1){
    				pseudoHead = current;
    			}else if (counter == m){
    				pseudoHead.next = this.reverseHelper(current, counter, n);
    				break;
    			}
    			current = current.next;
    		}
    		return head;
    	}
    }
    
    private ListNode reverseHelper(ListNode head, int counter, int end){
    	if (head == null) return null;
    	if (counter == end || head.next == null	){
    		return head;
    	}
    	ListNode next = head.next;
    	ListNode rest = this.reverseHelper(head.next, counter + 1, end);
    	ListNode last = next.next;
    	next.next = head;
    	head.next = last;
    	return rest;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		ReverseLinkedList reverse = new ReverseLinkedList();
		reverse.reverseBetweenRC(n1, 1, 3);
		
	}

}
