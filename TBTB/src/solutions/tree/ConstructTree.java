package solutions.tree;

public class ConstructTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length == 0 || postorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        
        int inorderLeftLength = 0;
        for (int i = 0; i < inorder.length; i++){
        	if (inorder[i] == rootVal) inorderLeftLength = i;
        }
        int inorderRightLength = inorder.length - 1 - inorderLeftLength;
        int [] inorderLeft = new int [inorderLeftLength];
        int [] inorderRight = new int [inorderRightLength];
        int [] postorderLeft = new int [inorderLeftLength];
        int [] postorderRight = new int [inorderRightLength];
        for (int i = 0; i < inorderLeftLength; i++){
        	inorderLeft[i] = inorder[i];
        	postorderLeft[i] = postorder[i];
        }
        for (int i = 0; i < inorderRightLength; i++){
        	postorderRight[i] = postorder[inorderLeftLength + i];
        	inorderRight[i] = inorder[inorderLeftLength + 1 + i];
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = this.buildTree(inorderLeft, postorderLeft);
        root.right = this.buildTree(inorderRight, postorderRight);
        return root;
    }
    
    public TreeNode buildTreeII(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null) return null;
        if (inorder.length == 0 || preorder.length == 0) return null;
        int rootVal = preorder[0];
        
        int inorderLeftLength = 0;
        for (int i = 0; i < inorder.length; i++){
        	if (inorder[i] == rootVal) inorderLeftLength = i;
        }
        int inorderRightLength = inorder.length - 1 - inorderLeftLength;
        int [] inorderLeft = new int [inorderLeftLength];
        int [] inorderRight = new int [inorderRightLength];
        int [] preorderLeft = new int [inorderLeftLength];
        int [] preorderRight = new int [inorderRightLength];
        for (int i = 0; i < inorderLeftLength; i++){
        	inorderLeft[i] = inorder[i];
        	preorderLeft[i] = preorder[i + 1];
        }
        for (int i = 0; i < inorderRightLength; i++){
        	preorderRight[i] = preorder[inorderLeftLength + 1 + i];
        	inorderRight[i] = inorder[inorderLeftLength + 1 + i];
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = this.buildTree(preorderLeft, inorderLeft);
        root.right = this.buildTree(preorderRight, inorderRight);
        return root;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
