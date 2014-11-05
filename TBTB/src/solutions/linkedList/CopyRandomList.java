package solutions.linkedList;

import java.util.HashMap;
import java.util.Stack;

public class CopyRandomList {

	/**
	 * @param args
	 */
    public RandomListNode copyRandomList(RandomListNode head) {
        Stack<RandomListNode> stack = new Stack<RandomListNode>();
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        if (head == null) return null;
        while (head != null){
        	stack.push(head);
        	head = head.next;
        }
        RandomListNode headcp = null;
        while (!stack.isEmpty()){
        	head = stack.pop();
        	RandomListNode nodecp = new RandomListNode(head.label);
        	map.put(head, nodecp);
        	nodecp.next = headcp;
        	headcp = nodecp;
        }
        RandomListNode node = head;
        RandomListNode nodecp = headcp;
        
        while (node != null){
        	if (node.random == null) nodecp.random = null;
        	else {
        		nodecp.random = map.get(node.random);
        	}
        	node = node.next;
        	nodecp = nodecp.next;
        }
        
        return headcp;
    }
    
    private HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    public RandomListNode cpyRandomListRecursion(RandomListNode head){
    	if (head == null) return null;
    	if (this.map.containsKey(head)) return this.map.get(head);
    	else {
    		RandomListNode headcp = new RandomListNode(head.label);
    		this.map.put(head, headcp);
    		headcp.next = this.cpyRandomListRecursion(head.next);
    		headcp.random = this.cpyRandomListRecursion(head.random);
    		return headcp;
    	}
    }
    
    public RandomListNode copyRandomListRCC(RandomListNode head) {
    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	return this.copyRandomListHelper(head, map);	
    }
    private RandomListNode copyRandomListHelper(RandomListNode node, HashMap<RandomListNode, RandomListNode> map){
    	if (node == null) return null;
    	if (map.containsKey(node)) return map.get(node);
    	RandomListNode cp = new RandomListNode(node.label);
    	map.put(node, cp);
    	cp.next = this.copyRandomListHelper(node.next, map);
    	cp.random = map.get(node.random);
    	return cp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
