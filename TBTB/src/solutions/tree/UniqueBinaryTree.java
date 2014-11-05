package solutions.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTree {

	/**
	 * @param args
	 */
	
    public int numTrees(int n) {
        int [] result = new int [n+1];
    	if ( n < 2)
    	{
		    return 1;
	    } 
	    else {

		    result[0] = 1;
		    result[1] = 1;
		    for (int i = 2; i < (n+1); i++){
			    for ( int j = 0; j < i; j++){
  				    result[i] += result[j]* result[i-1-j];
			    }	
		    }
		    return result[n];
	    }
    }
    
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode>[][] treeTable = new ArrayList[n + 1][n + 1];
        for (int i = 1; i <= n; i++){
        	treeTable[i][i] = new ArrayList<TreeNode>();
        	treeTable[i][i].add(new TreeNode(i));
        }
        return this.generateSubTrees(1, n, treeTable);
    }
    
    private ArrayList<TreeNode> generateSubTrees(int start, int end, ArrayList<TreeNode>[][] treeTable){
    	if (start > end) {
    		ArrayList<TreeNode> result  = new ArrayList<TreeNode>();
    		result.add(null);
    		return result;
    	}
    			
    	if (treeTable[start][end] != null) {
    		return treeTable[start][end];
    	}
    	treeTable[start][end] = new ArrayList<TreeNode>();
    	for (int i = start; i <= end; i++){
    		ArrayList<TreeNode> left = this.generateSubTrees(start, i - 1, treeTable);
    		ArrayList<TreeNode> right = this.generateSubTrees(i + 1, end, treeTable);
    		for (TreeNode leftNode: left){
    			for (TreeNode rightNode: right){
    				TreeNode root = new TreeNode(i);
    				root.left = leftNode;
    				root.right = rightNode;
    				treeTable[start][end].add(root);
    			}
    		}
    	}
    	return treeTable[start][end];
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinaryTree tree = new UniqueBinaryTree();
		List<TreeNode> list = tree.generateTrees(3);
		System.out.println(list);
	}

}
