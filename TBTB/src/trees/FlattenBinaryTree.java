package trees;

import java.util.Stack;

import solutions.tree.TreeNode;

public class FlattenBinaryTree {

	/**
	 * @param args
	 * 
	 * It looks like it's a normal pre-order traversal, but indeed it is a bit more complex
	 * 
	 * A recursive approach is easier to come up with. I am thinking on an iterative approach
	 * 
	 * Another iterative approach uses a stack. And use pre-order traversal
	 */
	
	public void flattenRC(TreeNode root) {
		this.flattenHelper(root);
	}
	private TreeNode flattenHelper(TreeNode root){
		if (root == null) return null;
		TreeNode left = this.flattenHelper(root.left);
		TreeNode right = this.flattenHelper(root.right);
		TreeNode last = root;
		if (left != null) {
			left.right = root.right;
			root.right = root.left;
			root.left = null;
			last = left;
		} 
		if (right != null){
			last = right;
		}
		return last;
	}
	
	public void flatten(TreeNode root) {
		TreeNode sudo = new TreeNode(1);
		sudo.right = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()){
		    while (root != null){
		        if (root.right != null) stack.push(root.right);
		        root.right = root.left;
		        root.left = null;
		        prev = root;
		        root = root.right;
		    }    
		    if (!stack.isEmpty()){
		        root = stack.pop();
		        prev.right = root;
		    }
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
