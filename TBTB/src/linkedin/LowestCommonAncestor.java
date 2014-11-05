package linkedin;

import java.util.Stack;

public class LowestCommonAncestor {
	/**
	* Given two nodes of a tree,
	* method should return the deepest common ancestor of those nodes.
	*
	*     A
	*    / \
	*   B   C
	*  / \   \
	* D   E   M
	*    / \
	*   G   F
	*
	* commonAncestor(D, F) = B
	* commonAncestor(C, G) = A
	*/

	public Node commonAncestor(Node nodeOne, Node nodeTwo)
	{
		Node nodeOnePtr = nodeOne;
		Node nodeTwoPtr = nodeTwo;
		int counter1 = 0;
		int counter2 = 0;
		if (nodeOne == null || nodeTwo == null) return null;
		while (!nodeOne.isRoot()) 
		{
			nodeOne = nodeOne.parent;
			counter1++;
		}
		while (!nodeTwo.isRoot()) {
			nodeTwo = nodeTwo.parent;
			counter2++;
		}
		nodeOne = nodeOnePtr;
		nodeTwo = nodeTwoPtr;
		if (counter1 > counter2){
			int step = counter1 - counter2;
			for (int i = 0; i < step; i++){
				nodeOne = nodeOne.parent;
			}
		} else if (counter2 > counter1) {
			int step = counter2 - counter1;
			for (int i = 0; i < step; i++){
				nodeTwo = nodeTwo.parent;
			}
		}
		while (nodeOne != nodeTwo){
			nodeOne = nodeOne.parent;
			nodeTwo = nodeTwo.parent;
		}
		return nodeOne;
	}
	
	public Node LCA ( Node root, Node node1, Node node2){
		if (this.containsTwoNode(root, node1, node2)){
			boolean left = this.containsTwoNode(root.left, node1, node2);
			boolean right = this.containsTwoNode(root.right, node1, node2);
			if (left && !right) return this.LCA(root.left, node1, node2);
			if (!left && right) return this.LCA(root.right, node1, node2);
			if (!left && !right) return root;
		}
		return null;
	}

	private boolean containsTwoNode(Node root, Node node1, Node node2){
		if(root == null) return false;
		boolean node1found = false;
		boolean node2found = false;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			if (node == node1) node1found = true;
			if (node == node2) node2found = true;
			if (node.left != null) stack.push(node.left);
			if (node.right != null) stack.push(node.right);
		}
		return node1found && node2found;
	}
	
	public Node findNode1OrNode2(Node root, Node node1, Node node2){
		if (root == null) return null;
		if (root == node1 || root == node2) return root;
		Node left = this.findNode1OrNode2(root.left, node1, node2);
		Node right = this.findNode1OrNode2(root.right, node1, node2);
		if (left != null && right != null) return root;
		return left == null? right: left;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(null, null, null, 1);
		Node node2 = new Node(node1, null, null, 2);
		Node node3 = new Node(node1, null, null, 3);
		Node node4 = new Node(node2, null, null, 4);
		Node node5 = new Node(node2, null, null, 5);
		Node node6 = new Node(node3, null, null, 6);
		Node node7 = new Node(node5, null, null, 7);
		Node node8 = new Node(node5, null, null, 8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node5.left = node7;
		node5.right = node8;
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node node = lca.findNode1OrNode2(node1, node5, node7);
		System.out.println(node.data);
	}

}
