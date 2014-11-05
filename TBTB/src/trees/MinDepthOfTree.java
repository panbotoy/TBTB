package trees;

import solutions.tree.TreeNode;

public class MinDepthOfTree {

	/**
	 * @param args
	 * 
	 * The thing needs to be careful is the definition of "leaf node"
	 * 
	 * Leaf nodes are defined as the nodes without any children
	 * 
	 * This can definitely be solved with BFS.
	 * 
	 * However, it seems that we can only solve this with recursive DFS.
	 * In order to keep track of the min value, I passed an array with only one element.
	 * This records the current min value.
	 * 	 */
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int [] res = new int[1];
		res[0] = Integer.MAX_VALUE;
		minDepthHelper(root, 1, res);
		return res[0];
	}
	
	private void minDepthHelper(TreeNode root, int depth, int[] res){
		if (depth > res[0]) return;
		if (root.left == null && root.right == null) res[0] = Math.min(res[0], depth);
		else {
			if (root.left!= null ) minDepthHelper(root.left, depth + 1, res);
			if (root.right!= null) minDepthHelper(root.right, depth + 1, res);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
