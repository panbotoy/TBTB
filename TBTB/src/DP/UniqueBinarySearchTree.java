package DP;

import java.util.ArrayList;
import java.util.List;

import solutions.tree.TreeNode;

public class UniqueBinarySearchTree {

	/**
	 * @param args
	 */
	public int numTrees(int n) {
		int [] num = new int [n+1];
		num[0] = 1;
		num[1] = 1;
		for (int i = 2; i < n+1; i++){
			int count = 0;
			for (int j = 1; j <= i; j++){
				int left = num[j - 1];
				int right = num[i - j];
				count += left * right;
			}
			num[i] = count;
		}
		return num[n];
	}
	
	public List<TreeNode> generateTrees(int n) {
		return this.generateHelper(1, n);
	}
	
	private List<TreeNode> generateHelper(int start, int end){
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}
		for (int i = start; i <= end; i++){
			TreeNode root = new TreeNode(i);
			List<TreeNode> lefts = this.generateHelper(start, i-1);
			List<TreeNode> rights = this.generateHelper(i+1, end);
			System.out.println( start + " " + end+ " " + i);
			for (TreeNode left : lefts){
				for (TreeNode right : rights){
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTree unique = new UniqueBinarySearchTree();
		unique.generateHelper(1, 3);
	}

}
