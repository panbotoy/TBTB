package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import solutions.tree.TreeNode;

public class TreeTraversals {

	/**
	 * @param args
	 * 
	 * 1. Inorder traversal :
	 * 
	 * 1.1 what is inorder
	 * 
	 * 1.2 iterative approach:
	 * 	   use a stack to store upper level nodes.
	 * 	   if has left node, push current into stack, go to next,
	 * 	   if no left, get node from stack, print the result
	 * 	   if there is right node, go to right node
	 * 
	 * 	   pay attention to the termination conditions
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode curr) {
		if (curr == null) return new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(curr != null || !stack.isEmpty()){
			while (curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			if (!stack.isEmpty()){
				curr = stack.pop();
				result.add(curr.val);
				curr = curr.right;
			}
		}
		return result;
	}
	
	public ArrayList<Integer> inorderTraversalOld(TreeNode curr) {
		if (curr == null) return new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		stack.push(curr);
		while(!stack.isEmpty()){
			curr = stack.pop();
			if (curr.right!= null) stack.push(curr.right);
			if (curr.left != null) stack.push(curr.left);
			
			if (!stack.isEmpty()){
				curr = stack.pop();
				result.add(curr.val);
				curr = curr.right;
			}
		}
		return result;
	}
	
	/**
	 * This pre-order traversal is similar to in order. Except for the position to print the value
	 * **/
	public ArrayList<Integer> preorderTraversal(TreeNode curr) {
		if (curr == null) return new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(curr != null || !stack.isEmpty()){
			while (curr != null){
				result.add(curr.val);
				stack.push(curr);
				curr = curr.left;
			}
			if (!stack.isEmpty()){
				curr = stack.pop();
				curr = curr.right;
			}
		}
		return result;
	}
	
	/**
	 * How could I come up with such a solution
	 * **/
    public ArrayList<Integer> preorderTraversalOld(TreeNode root) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) return results;
		stack.push(root);
		while(stack.size() != 0){
			TreeNode current = stack.pop();
			results.add(current.val);
			if(current.right != null) stack.push(current.right);
			if(current.left != null) stack.push(current.left);
		}
		return results;
    }
	
    /*****
     * Post Order traversal
     * 
     * It is the trickiest among the 3 
     * The difficult point is how to make use of prev pointer to avoid getting the same node into the stack again
     * 
     * 
     * ****/
	public List<Integer> postorderTraversalOld(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		TreeNode prev = null;
		TreeNode curr = root;
		stack.push(curr);
		while (!stack.isEmpty()) {
			curr = stack.pop();
			if (prev != null
					&& ((prev == curr.left && curr.right == null) || prev == curr.right)) {
				res.add(curr.val);
				prev = curr;
				continue;
			}
			if (curr.left == null && curr.right == null) {
				res.add(curr.val);
				prev = curr;
				continue;
			} else {
				if (curr != null)
					stack.push(curr);
				if (curr.right != null)
					stack.push(curr.right);
				if (curr.left != null)
					stack.push(curr.left);
			}
		}
		return res;
	}
	
	public List<Integer> postorderTraversal(TreeNode root){
		if (root == null)
			return new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		TreeNode prev = null;
		TreeNode curr = null;
		stack.push(root);
		while (!stack.isEmpty()){
			curr = stack.peek();
			/****
			 * traverse from current node down.
			 * *****/
			if (prev == null || prev.left == curr || prev.right == curr){
				if (curr.left != null) stack.push(curr.left);
				else if (curr.right != null) stack.push(curr.right);
				else {
					res.add(curr.val);
					stack.pop();
				}
				
				/**
				 * traverse from left node to its parent
				 * if there is a right child, we need first traverse right
				 * ***/
			} else if (prev == curr.left ){
				if (curr.right != null){
					stack.push(curr.right);
				} else {
					res.add(curr.val);
					stack.pop();
				}
				
				/**
				 * traverse from right node to parent
				 * just visit parent
				 * */
			} else if (prev == curr.right){
				res.add(curr.val);
				stack.pop();
			}
			prev = curr;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
