package solutions.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraverse {
    
	public ArrayList<Integer> dfstraverse(TreeNode root) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		if(root == null) return new ArrayList<Integer>();
		results.add(root.val);
		if(root.left != null) {
			results.addAll(dfstraverse(root.left));
		}
		if (root.right != null){
			results.addAll(dfstraverse(root.right));
		}
		return results;
    }
	
	public ArrayList<Integer> iteratetraverse(TreeNode root) {
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
}
