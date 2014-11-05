package trees;

import solutions.tree.TreeNode;

public class MaxDepthOfTree {

	/**
	 * @param args
	 * 
	 * Another DFS question
	 * 
	 */
    public int maxDepth(TreeNode root) {
    	if (root == null) return 0;
        int [] res = new int[1];
        depthHelper(root, res, 1);
        return res[0];
    }
    
    private void depthHelper(TreeNode root, int[] res, int depth){
    	if (root.left == null && root.right == null) res[0] = Math.max(res[0], depth);
    	if (root.left != null) depthHelper(root.left, res, depth+1);
    	if (root.right != null) depthHelper(root.right, res, depth+1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
