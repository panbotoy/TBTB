package trees;

import java.util.LinkedList;

import solutions.tree.TreeNode;

public class BalancedBinaryTree {

	/**
	 * @param args
	 *   First thought comes to my mind is BFS
	 * However, this problem is a little bit strange.
	 * 
	 * A tree is balanced is defined as the depth of the subtrees does not differ by 1.
	 * such as 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, #, #, 5, 5, is balanced
	 * 
	 * The second thought is based on Recursive DFS.
	 * 
	 * However, I want to just have O(n) complexity. 
	 * The naive approach is to get depth of left, and depth of right, and see if it is balanced.
	 * This needs to be done for every node, so it's O(n^2) complexity.
	 * I change it to this in order to do O(n) traverse
	 */
	public boolean isBalancedBFS(TreeNode root) {
		if (root == null) return true;
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		curr.offer(root);
		int lo = 0;
		boolean foundLo = false;
		while (!curr.isEmpty()){
			if (!foundLo){
				for (TreeNode node : curr){
						if (node.left == null || node.right == null)
							foundLo = true;
						if (node.left != null) next.add(node.left);
						if (node.right != null) next.add(node.right);
				}
			}else{
				for (TreeNode node : curr){
					if (node.left!= null || node.right != null) return false;
				}
			}
			curr = next;
			next = new LinkedList<TreeNode>();
		}
		return true;
	}
	
	public boolean isBalanced(TreeNode root) {
		Node node = isBalancedHelper(root);
		return node.balanced;
	}
	
	private Node isBalancedHelper(TreeNode root){
		if (root == null) return new Node();
		Node left = isBalancedHelper(root.left);
		Node right = isBalancedHelper(root.right);
		int depth = Math.max(left.depth, right.depth) + 1;
		boolean balanced = Math.abs(left.depth - right.depth) <= 1 && left.balanced && right.balanced;
		return new Node (depth, balanced);
	}
	/****
	 * Node class records the depth of this node and if it is balanced at the same time.
	 * ***/
	class Node {
		int depth = 0;
		boolean balanced = true;
		public Node (){
				
		}
		public Node(int depth, boolean balanced){
			this.depth = depth;
			this.balanced = balanced;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
