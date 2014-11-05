package solutions.tree;

import java.util.ArrayList;
import java.util.List;

public class OnLevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
    	ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (current.size() != 0){
        	ArrayList<Integer> currentLevelResult = new ArrayList<Integer>();
        	for ( TreeNode node: current){
        		currentLevelResult.add(node.val);
        		if (node.left != null) next.add(node.left);
        		if (node.right != null) next.add(node.right);
        	}
        	result.add(currentLevelResult);
        	current = next;
        	next = new ArrayList<TreeNode>();
        }
        return result;
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root){
    	ArrayList<TreeNode > current = new ArrayList<TreeNode>();
    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root == null) return result;
    	current.add(root);
    	result.add(addNodes(current, result));
    	return result;
    }
    
    private ArrayList<Integer> addNodes(ArrayList<TreeNode> current, ArrayList<List<Integer>> result){
    	if (current == null || current.size() == 0) return new ArrayList<Integer>();
    	ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    	ArrayList<Integer> currentLevelResult = new ArrayList<Integer>();
    	for (TreeNode node : current){
    		currentLevelResult.add(node.val);
    		if (node.left != null) next.add(node.left);
    		if (node.right != null) next.add(node.right);
    	}
    	ArrayList<Integer> nextLevelResult = this.addNodes(next, result);
    	if (nextLevelResult != null || nextLevelResult.size()!=0)
    	    result.add(nextLevelResult);
    	return currentLevelResult;
    }
}
