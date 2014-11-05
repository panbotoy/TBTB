package solutions.tree;

public class FlattenBinaryTree {

	/**
	 * @param args
	 */
    public void flatten(TreeNode root) {
        this.flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode root){
    	if (root == null) return null;
    	TreeNode lastNode = root;
    	
    	TreeNode lastLeftNode = this.flattenHelper(root.left);
    	TreeNode lastRightNode = this.flattenHelper(root.right);
    	
    	if (lastLeftNode != null) {
    		lastNode = lastLeftNode;
    		lastLeftNode.right = root.right;  		
    		root.right = root.left;
    		root.left = null;
    	}
    	
    	if (lastRightNode != null){
    		lastNode = lastRightNode;
    	}
    	return lastNode;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
