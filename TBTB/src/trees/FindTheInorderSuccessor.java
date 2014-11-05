package trees;

public class FindTheInorderSuccessor {

	/**
	 * @param args
	 * 
	 * 1. the first approach comes to me is to find the root, do an inorder traversal and find the next node.
	 * However, it does not seem to be the solution the question is looking for.
	 * 
	 * 2. Then we need to discuss based on the current position of this node, to get its successsor
	 * 	if this node has successor,
	 *  else if this node has has parent
	 *  	if this node is the left child
	 *  	if this node is the right child
	 */
	public TreeNodeWithParent inorderSuccessor(TreeNodeWithParent node){
		if (node == null) return null;
		else if (node.right != null) { // find the left most node of right
			node = node.right;
			while (node.left!= null) node = node.left;
			return node;
		} else if (node.parent != null){
			if (node == node.parent.left) return node.parent;
			else if (node == node.parent.right){
				while (node.parent!= null && node == node.parent.right){
					node = node.parent;
				}
				return node.parent;
			} else return null;
		} else return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
