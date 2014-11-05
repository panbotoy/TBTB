package trees;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

import solutions.tree.TreeNode;

public class TreeTraversalRelatedQuestoins {

	/**
	 * @param args
	 * 
	 * 1. The first question done without using recursion.
	 * 
	 * A simple DFS. But when it comes to two trees, it is more subtle.
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) return true;
        if ( p == null || q == null) return false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || (p != null && q!= null)){
            while (p!= null && q!= null){
                if (p.val != q.val) return false;
                stack.push(p);
                stack.push(q);
                p = p.left;
                q = q.left;
            }
            if (p == null && q!= null || q== null && p!= null) return false;
            if (!stack.isEmpty()){
                q = stack.pop();
                p = stack.pop();
                if (p == null && q!= null || q== null && p!= null) return false;
                p = p.right;
                q = q.right;
            }
        }
        return p == null && q == null;
    }
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) return true;
    	return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right){
    	if (left == null && right == null) return true;
    	else if (left == null && right!=null || left != null && right == null) return false;
    	else {
    		if (left.val != right.val ) return false;
    		return isMirror(left.right, right.left) && isMirror(left.left, right.right);
    	}
    }
    
    public boolean isSymmetricIter(TreeNode root) {
    	if (root == null || (root.left == null && root.right == null)) return true;
    	if (root.left == null || root.right == null || root.left.val != root.right.val) return false;
    	LinkedList<TreeNode> leftList = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> rightList = new LinkedList<TreeNode>();
    	leftList.addLast(root.left);
    	rightList.addLast(root.right);
		while (!leftList.isEmpty() && !rightList.isEmpty()){
			TreeNode left = leftList.pop();
			TreeNode right = rightList.pop();
			if(left == null && right!= null || right==null && left != null) return false;
			if (left != null && right!=null && left.val != right.val) return false;
			if (left == null && right == null) continue;
			leftList.addLast(left.left);
			rightList.addLast(right.right);
			leftList.addLast(left.right);
			rightList.addLast(right.left);
		}
		return leftList.isEmpty() && rightList.isEmpty();
    }
    
    
    /****
     * Valid BST is in-order traversal.
     * This will give us the original sequence of the array
     * ***/
	public boolean isValidBST(TreeNode root){
	    if (root == null) return true;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    int min = Integer.MIN_VALUE;
	    while (!stack.isEmpty() || root != null){
	        while (root != null){
	            stack.push(root);
	            root = root.left;
	        }
	        if (!stack.isEmpty()){
	            root = stack.pop();
	            if (root.val <= min) return false;
	            min = root.val;
	            root = root.right;
	        }
	    }
	    return true;
	}
	
	
	/******
	 * 
	 * 1. The difficult part in this question is to move the prev pointer the last node of the root
	 * 2. The other difficult part in this question is how to record the two wrong nodes.
	 * 
	 * Equivalent to Given a sorted array except for two nodes are changed. How to find these two nodes?
	 * *****/
	public void recoverTree(TreeNode root){
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode wrong1 = null;
		TreeNode wrong2 = null;
		TreeNode prev = null;
		while (!stack.isEmpty() || root != null){
			while (root != null){
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()){
				root = stack.pop();
				if (wrong1 == null && prev != null && root.val <= prev.val) {
					wrong1 = prev;
					wrong2 = root;
				}
				if (prev != null && wrong1 != null && root.val <= prev.val){
					wrong2 = root;
				}
				prev = root;
				root =root.right;
			}
		}
		int tmp = wrong1.val;
		wrong1.val = wrong2.val;
		wrong2.val = tmp;
	}
	
	/*****
	 * This solution will get TLE.
	 * 
	 * ********/
	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);
		int mid = root.val + this.maxHelper(root.left) + this.maxHelper(root.right);
		return Math.max(Math.max(left, right), mid);
	}
	
	/**
	 * max helper calculates the maximum value including the root. may not end with a leaf node.
	 * **/
	private int maxHelper(TreeNode root){
		if (root == null) return 0;
		int left = this.maxHelper(root.left);
		int right = this.maxHelper(root.right);
		int max = Math.max(left, right);
		max = Math.max(max, 0);
		max += root.val;
		return max > 0? max : 0;
	}


}

