package linkedin;

import solutions.tree.TreeNode;

public class ValidateBST {

	/**
	 * @param args
	 */
	
	public boolean validate(TreeNode root){
		if (root == null) return true;
		long min = (long)Integer.MIN_VALUE - 1;
		long max = (long)Integer.MAX_VALUE + 1;
		return validateHelper(root, min, max);
	}
	private boolean validateHelper(TreeNode root, long min, long max){
		if (root == null) return true;
		if (root.val < max && root.val > min){
			return this.validateHelper(root.left, min, root.val) &&
					this.validateHelper(root.right, root.val, max);
		}
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(Integer.MIN_VALUE);
		TreeNode node3 = new TreeNode(Integer.MAX_VALUE);
		node1.left = node2; 
		node1.right = node3;
		ValidateBST valid = new ValidateBST();
		System.out.println(valid.validate(node1));
	}

}
