package solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

	/**
	 * @param args
	 */
	private LinkedList<Integer> result = new LinkedList<Integer>();

	public List<Integer> postorderTraversal(TreeNode root) {
		this.traversalHelper(root);
		return this.result;
	}

	private void traversalHelper(TreeNode root) {
		if (root == null)
			return;
		this.traversalHelper(root.left);
		this.traversalHelper(root.right);
		this.result.add(root.val);
	}

	public List<Integer> postorderTraversalIter(TreeNode root) {
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
}
