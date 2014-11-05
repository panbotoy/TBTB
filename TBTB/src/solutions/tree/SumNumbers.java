package solutions.tree;

public class SumNumbers {
	int sum = 0;
    public int sumNumbers(TreeNode root) {
        this.getNumber(root, 0);
        return sum;
    }
    
    private void getNumber(TreeNode root, int val){
    	if (root == null) return;
    	else {
    		val = val * 10 + root.val;
    		if (root.left == null && root.right == null) {
    			this.sum += val;
    			return;
    		}
    		if (root.left != null) this.getNumber(root.left, val);
    		if (root.right!= null) this.getNumber(root.right, val);
    		
    	}
    }
}
