package linkedin;

import solutions.tree.TreeNode;

public class RecoverBinaryTree {

	/**
	 * @param args
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) return null;
		if (preorder.length != inorder.length) return null;
		if (preorder.length == 0) return null;
		
		int rootVal = preorder[0];
		
		int rootInorder = 0;
		for (int i = 0; i < inorder.length; i++){
			if (inorder[i] == rootVal) rootInorder = i; 
		}
		
		int [] inorderLeft = new int [rootInorder];
		int [] preorderLeft = new int [rootInorder];
		for (int i = 0; i < rootInorder; i++){
			preorderLeft[i] = preorder[i + 1];
			inorderLeft[i] = inorder[i];
		}
		
		int rightLength = inorder.length - rootInorder - 1;
		int [] inorderRight = new int [rightLength];
		int [] preorderRight = new int [rightLength];
		for (int i = 0; i < rightLength; i++){
			preorderRight[i] = preorder[i + rootInorder + 1];
			inorderRight[i] = inorder[i + rootInorder + 1];
		}
		
		TreeNode root = new TreeNode(rootVal);
		root.left = this.buildTree(preorderLeft, inorderLeft);
		root.right = this.buildTree(preorderRight, inorderRight);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
