package trees;

import java.util.ArrayList;
import java.util.List;

import solutions.tree.TreeNode;

public class PathSum {

	/**
	 * @param args
	 * 
	 * 1. for tree questions, be very careful about the definition of leaf node
	 * this is a classic example of tree DFS.
	 * 
	 * Now I think I have more and more understanding about recursive DFS.
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
    	return sumHelper(root, 0, sum);
    }
    
    private boolean sumHelper(TreeNode root, int sum, int target){
    	if (root.left == null && root.right == null) return (sum+root.val) == target;
    	boolean left = false;
    	boolean right = false;
    	if (root.left != null) left = sumHelper(root.left, sum+root.val, target);
    	if (root.right != null) right = sumHelper(root.right, sum + root.val, target);
    	return left || right;
    }
    
    
    /***
     * Similar idea to path sum I, recursive DFS
     * Very very similar to the swap permutation
     * ****/
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<Integer> res = new ArrayList<Integer>();
    	List<List<Integer>> paths = new ArrayList<List<Integer>>();
    	if (root == null) return paths;
    	pathHelper(root, 0, sum, paths, res);
    	return paths;
    }
    
    private void pathHelper(TreeNode root, int sum, int target, List<List<Integer>> paths, List<Integer> res){
    	sum += root.val;
    	res.add(root.val);
    	if (root.left != null) pathHelper(root.left, sum, target, paths, res);
    	if (root.right != null) pathHelper(root.right, sum, target, paths, res);
    	if (root.left == null && root.right == null) {
    		if (sum == target){
    			List<Integer> path = new ArrayList<Integer>();
    			path.addAll(res);
    			paths.add(path);
    		}
    	}
    	res.remove(res.size()-1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
