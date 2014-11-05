package trees;

import solutions.tree.TreeNode;

public class ConvertSortedArrayToBST {

	/**
	 * @param args
	 * 
	 * 1. remember the properties of BST, a good BST is mid in the root, left and right are the same length
	 * 
	 * 2. remember to check for API, return statement, parenthesis, variable names, types
	 */
	
	public TreeNode sortedArrayToBSTRecursion(int[] num) {
		if (num == null || num.length == 0) return null;
		return this.findMid(num, 0, num.length-1);
	}
	
	private TreeNode findMid(int [] num, int start, int end){
		if ( start > end ) return null;
		else {
			int mid = (start + end)/2;
			TreeNode node = new TreeNode(num[mid]);
			node.left = this.findMid(num, start, mid-1);
			node.right = this.findMid(num, mid+1, end);
			return node;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
