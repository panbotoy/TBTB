package solutions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
    	if (root == null) return results;
    	Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        boolean goFromLeft = true;
        current.push(root);
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!current.isEmpty()){
        	TreeNode node = current.pop();
        	result.add(node.val);
        	if (goFromLeft){
        		if (node.left != null) next.push(node.left);
        		if (node.right != null) next.push(node.right);
        	}else{
        		if (node.right != null) next.push(node.right);
        		if (node.left != null) next.push(node.left);
        	}
        	if (current.isEmpty()){
        		current = next;
        		next = new Stack<TreeNode>();
        		results.add(result);
        		result = new ArrayList<Integer>();
        		goFromLeft = !goFromLeft;
        	}
        }
        return results;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
