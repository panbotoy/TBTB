package solutions.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class MirrorIteration {
    public boolean isSymmetric(TreeNode root) {
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
}
