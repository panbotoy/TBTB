package solutions.tree;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraverse {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		if (root == null) return results;
		results = inorderTraversal(root.left);
		results.add(root.val);
		results.addAll(inorderTraversal(root.right));
		return results;
	}
	
    public ArrayList<Integer> inorderTraversalNoRecursion(TreeNode root) {
	    ArrayList<Integer> results = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) return results;
		stack.push(root);
		while (stack.size() != 0){
			root = stack.pop();
			if (root.left == null) results.add(root.val);
			else {
			    if (root.right != null) stack.push(root.right);
			    TreeNode pseudoRoot = new TreeNode(root.val);
			    stack.push(pseudoRoot);
			    if (root.left != null) stack.push(root.left);
			}
		}
		return results;
    }
    
    public ArrayList<Integer> betterinorderTraversal(TreeNode curr) {
        Stack<TreeNode> todo = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!todo.isEmpty() || curr != null){
            if(curr != null){
                todo.add(curr);
                curr = curr.left;
            }
            else{
                curr = (TreeNode)todo.pop();
                res.add(new Integer(curr.val));
                curr = curr.right;
            }
        }
        return res;
    }
    
    
}
