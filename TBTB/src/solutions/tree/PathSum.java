package solutions.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int currentSum = 0;
        return this.getNextNode(root, currentSum, sum);
    }
    
    private boolean getNextNode(TreeNode root, int sum, int target){
    	if (root == null) return false;
    	sum += root.val;
    	boolean left = false;
    	boolean right = false;
    	if (root.left != null) left = this.getNextNode(root.left, sum, target);
    	if (root.right != null) right = this.getNextNode(root.right, sum, target);
    	if (root.left == null && root.right == null) return sum == target;
    	else return left || right;
    }
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return result;
        ArrayList<Integer> branchResult = new ArrayList<Integer>();
        this.getNextNode(root, sum, branchResult);
        return this.result;
    }
    /**
     * Finally change branchResult to a private variable. At the end of each getNextNode call, pop the last element of branchResult.
     * When add branchResult to result, need to make a deep copy, otherwise pop will affect result.
     * **/
    private void getNextNode(TreeNode root, int sum, List<Integer> branchResult){
    	if (root == null) return;
    	sum -= root.val;
    	branchResult.add(root.val);
    	if (root.left != null) getNextNode(root.left, sum, branchResult);
    	if (root.right != null) getNextNode(root.right, sum, branchResult);
    	if (root.left == null && root.right == null) 
    		if (sum == 0) {
    			this.result.add(branchResult);
    			branchResult.remove(branchResult.size() - 1);
    		}
    		
    	
    }
}
