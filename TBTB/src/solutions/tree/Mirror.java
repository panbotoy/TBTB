package solutions.tree;

public class Mirror {
    public boolean isSymmetric(TreeNode root) {
    	if (root == null || (root.left == null && root.right == null)) return true;
    	if (root.left == null || root.right == null || root.left.val != root.right.val) return false;
		return this.isSymmetric(root.left, root.right);
        
    }
    private boolean isSymmetric (TreeNode left, TreeNode right){
    	if (left == null && right == null) return true;
    	if (left == null || right == null) return false;
    	if (left.val != right.val) return false;
    	else {
    		return this.isSymmetric(left.left, right.right) && this.isSymmetric(left.right, right.left); 
    	}
    }
}
