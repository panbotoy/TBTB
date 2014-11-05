package linkedin;

import java.util.Stack;

import solutions.tree.TreeNode;

public class MirrorBinaryTree {

	/**
	 * @param args
	 */
	TreeNode mirror (TreeNode root){
		if (root == null) return null;
		TreeNode mirrorNode = new TreeNode(root.val);
		mirrorNode.left = this.mirror(root.right);
		mirrorNode.right = this.mirror(root.left);
		return mirrorNode;
	}
	
	TreeNode mirrorIter (TreeNode root){
		if (root == null) return null;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
 		TreeNode mirrorRoot = new TreeNode(root.val);
 		stack1.push(root);
		stack2.push(mirrorRoot);
		while(!stack1.isEmpty()){
			TreeNode origNode = stack1.pop();
			TreeNode mirrNode = stack2.pop();
			if (origNode.right != null) {
				mirrNode.left = new TreeNode(root.right.val);
				stack1.push(root.right);
				stack2.push(mirrNode.left);
			}
			if (origNode.left != null) {
				mirrNode.right = new TreeNode(root.left.val);
				stack1.push(root.left);
				stack2.push(mirrNode.right);
			}
		}
		return mirrorRoot;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
