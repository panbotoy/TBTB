package linkedin;

public class Node {
	Node parent;
	Node left;
	Node right;
	int data;

	public Node(Node parent, Node left, Node right, int data) {
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.data = data;
	}

	boolean isRoot() {
		return parent == null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
