package solutions.tree;

import java.util.HashMap;

public class BinaryTreeMaxPathSum {
    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        this.cacheMaxPathSumToRoot(root, map);
        return this.maxSumHelper(root, map);
    }
    
    private int cacheMaxPathSumToRoot(TreeNode root, HashMap<TreeNode, Integer> map){
    	if (root == null) return 0;
    	if (map.containsKey(root)) return map.get(root);
    	int leftPathSum = this.cacheMaxPathSumToRoot(root.left, map);
    	int rightPathSum = this.cacheMaxPathSumToRoot(root.right, map);
    	leftPathSum = leftPathSum > 0 ? leftPathSum : 0;
    	rightPathSum = rightPathSum > 0 ? rightPathSum : 0;
    	int maxPathSumToRoot = Math.max(leftPathSum, rightPathSum) + root.val;
    	map.put(root, maxPathSumToRoot > 0 ? maxPathSumToRoot: 0);
    	return maxPathSumToRoot;
    }
    
    private int maxSumHelper(TreeNode root, HashMap<TreeNode, Integer> map){
    	if (root == null) return Integer.MIN_VALUE;
    	int maxLeftSum = this.maxSumHelper(root.left, map);
    	int maxRightSum = this.maxSumHelper(root.right, map);
    	int maxMidSum = this.cacheMaxPathSumToRoot(root.left, map) + this.cacheMaxPathSumToRoot(root.right, map) + root.val;
    	return Math.max(Math.max(maxLeftSum, maxRightSum), maxMidSum);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
