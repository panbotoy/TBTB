package trees;

import solutions.linkedList.ListNode;
import solutions.tree.TreeNode;

public class SortedListToBST {

	/**
	 * @param args
	 * 
	 * The first approach comes to me is to find the mid, and split the original list into two halves.
	 * That will require us to find mid for every half, so it will be O(nlogn) complexity
	 * Generate the root from the mid list node,
	 * and recursively call for root.left and root.right
	 * 
	 * The better approach is again to use self-defined data type.
	 * This is probably the third question that require us to define our own data type in tree related questions.
	 * 
	 * Sometimes when we find that for each node, we need to traverse its subtrees to get something, usually we can define our 
	 * own data types and do it in one shot.
	 * 
	 * For this problem, need to be aware that the data structure we defined is:
	 * 
	 * TreeNode current mid node,
	 * ListNode, the right most node of the current subtree
	 * 
	 * Another detail to pay attention to is that:
	 * if len == 2, we'd better have left node to be not null, mid not null and right to be null.
	 * It will be easier to code
	 * 
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		int len = 0;
		while (head != null){
			head = head.next;
			len = len + 1;
		}
		Node node = this.sortListToBSTHelper(head, len);
		return node.tree;
	}
	
	private Node sortListToBSTHelper(ListNode head, int len){
		if (head == null || len == 0) return null;
		if (len == 1) return new Node(head, new TreeNode(head.val));
		int rightlen = (len - 1) / 2;
		int leftlen = len - rightlen - 1;
		Node left = this.sortListToBSTHelper(head, leftlen);
		TreeNode midtree = new TreeNode(left.list.next.val);
		ListNode midList = left.list.next;
		Node right = this.sortListToBSTHelper(midList.next, rightlen);
		
		if (left != null ) midtree.left = left.tree;
		if (right != null) midtree.right = right.tree;
		return new Node(right == null ? midList : right.list, midtree);
	}
	
	class Node {
		TreeNode tree;
		ListNode list;
		Node (ListNode list, TreeNode tree){
			this.tree = tree;
			this.list = list;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
