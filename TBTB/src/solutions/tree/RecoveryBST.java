package solutions.tree;

import java.util.ArrayList;
import java.util.HashSet;

public class RecoveryBST {

	/**
	 * @param args
	 */
	/****
	 * Need to be very careful about setting last pointer.
	 * last pointer should be the second latest value of runner. so we can compare last and current.
	 * if no errors ever found, mistake1 = last and mistake 2 = runner. If another inconsistency happens, but already found one mistake, then mistake 2 = runner.
	 * mistake 1 = old last.
	 * 
	 * *****/
	public void recoverTreeMoris(TreeNode root){
		
		TreeNode runner = root;
		TreeNode prev = null;
		TreeNode last = null;
		TreeNode mistake1 = null;
		TreeNode mistake2 = null;
		while (runner != null){
			if (runner.left == null){
			   if (last != null && last.val > runner.val ) {
					if (mistake1 == null) {
						mistake1 = last;
						mistake2 = runner;
					} else {
						mistake2 = runner;
					}
				}
				last = runner;
				runner = runner.right;
	
			} else {
				prev = runner.left;
				while (prev.right != null && prev.right != runner){
					prev = prev.right;
				}
				if (prev.right == null){
					prev.right = runner;
					prev = runner;
					runner = runner.left;
				} else if (prev.right == runner) {
					prev.right = null;
			     	if (last != null && last.val > runner.val ) {
						if (mistake1 == null) {
							mistake1 = last;
							mistake2 = runner;
						} else {
							mistake2 = runner;
						}
					}
					last = runner;
					runner = runner.right;
				}
			}
		}
		int temp = mistake1.val;
		mistake1.val = mistake2.val;
		mistake2.val = temp;
	}
	
	
    public void recoverTree(TreeNode root) {
    	if (root == null) return;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	this.traverseList(root, list);
    	ArrayList<Integer> mistakes = new ArrayList<Integer>();    	
    	for (int i = 0; i < list.size(); i++){
    		if ( i == 0){
    			if (list.get(i) > list.get(i + 1)) {
    				mistakes.add(list.get(i));
    				break;
    			}
    		}else {
    			if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1) ){
    				mistakes.add(list.get(i));
    				break;
    			}
    		}
    	}
    	
    	for (int i = list.size() - 1; i >= 0; i--){
    		if ( i == list.size() - 1){
    			if (list.get(i) < list.get(i - 1)) {
    				mistakes.add(list.get(i));
    				break;
    			}
    		}else {
    			if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1) ){
    				mistakes.add(list.get(i));
    				break;
    			}
    		}
    	}
    	this.recoverListFromSet(root, mistakes);
    }
    
    private void traverseList(TreeNode root, ArrayList<Integer> list){
    	if (root == null) return;
    	this.traverseList(root.left, list);
    	list.add(root.val);
    	this.traverseList(root.right, list);
    }
    
    private void recoverListFromSet(TreeNode root, ArrayList<Integer> mistakes)
    {
    	if (root == null) return;
    	this.recoverListFromSet(root.left, mistakes);
    	if (root.val == mistakes.get(0)) {
    		root.val = mistakes.get(1);
    	} else if (root.val == mistakes.get(1)){
    		root.val = mistakes.get(0);
    	}
    	this.recoverListFromSet(root.right, mistakes);
    }
    /**
     * flaw 1. If a node equals Integer.Min, it will fail
     * flaw 2. It requires a private variable, which may not be desirable 
     * **/
    private int min = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;       
        boolean leftValid = this.isValidBST(root.left);
        boolean midValid = false;
        if(root.val > min){
        	midValid = true;
        	min = root.val;
        }
        boolean rightValid = this.isValidBST(root.right);
        return leftValid && midValid && rightValid;
    }
    
    public boolean isValidBSTII(TreeNode root) {
        if (root == null) return true;
        return isValidBSTHelper(root.left, Integer.MIN_VALUE, root.val) && isValidBSTHelper(root.right, root.val, Integer.MAX_VALUE);
    }
    
    private boolean isValidBSTHelper(TreeNode root, int small, int large){
    	if (root == null) return true;
    	if (root.val > small && root.val < large) return this.isValidBSTHelper(root.left, small, root.val) &&
    			this.isValidBSTHelper(root.right, root.val, large);
    	else return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = Integer.MAX_VALUE + 1;
		System.out.println(i);
	}

}
