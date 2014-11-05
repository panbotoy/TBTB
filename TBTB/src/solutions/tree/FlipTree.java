package solutions.tree;

public class FlipTree {
	
	/**
	 * Wrong implementation, leave here for future reference!
	 * **/
	public TreeNode flip (TreeNode root){
		if (root == null) return null;
		TreeNode newRoot = root;
		if (root.left != null) {
			this.flipHelper(root.left, newRoot);
		}
		return newRoot;
	}

	/**
	 * Be very careful with this. newRoot is not going to sustain its value in the stack.
	 * When it goes out of stack, it will become the original value again.
	 * */
	private void flipHelper(TreeNode left, TreeNode newRoot){
		if (left != null) {
			TreeNode newLeft = newRoot.right;
			TreeNode newRight = newRoot;
			newRoot.left = null;
			newRoot.right = null;
			newRoot = left;
			this.flipHelper(left.left, newRoot);
			left.left = newLeft;
			left.right = newRight;
		}
	}
	
	public void setZero(TreeNode node){
		node.val = 2;
		node = null;
	}
	
	public TreeNode fliptree (TreeNode root){
		if (root == null) return null;
		if (root.left == null) return root;
		TreeNode newRoot = this.fliptree(root.left);
		TreeNode newLeft = root.right;
		TreeNode newRight = root;
		root.left.left = newLeft;
		root.left.right = newRight;
		root.left = null;
		root.right = null;
		return newRoot;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		FlipTree flip = new FlipTree();
		TreeNode result = flip.fliptree(node1);
		System.out.println(result);
//		TreeNode next = new TreeNode(1);
//		flip.setZero(next);
//		System.out.println(next);
	}

}
