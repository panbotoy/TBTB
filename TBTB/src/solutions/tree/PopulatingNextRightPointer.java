package solutions.tree;

import java.util.LinkedList;

public class PopulatingNextRightPointer {

	/**
	 * @param args
	 */
    public void connectBFS(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> todoList = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> currentList = new LinkedList<TreeLinkNode>();
        currentList.add(root);
        while(currentList.size() != 0){
            for (int i = 0; i < currentList.size(); i++){
                TreeLinkNode current = currentList.get(i);
                if (i < (currentList.size() - 1 )){
                    current.next = currentList.get(i + 1);
                }
                if (current.left != null){
                    todoList.add(current.left);
                }
                if (current.right != null) todoList.add(current.right);
            }
            currentList = todoList;
            todoList = new LinkedList<TreeLinkNode>();
        }
    }
    
    public void connect(TreeLinkNode root){
    	TreeLinkNode rowStart = root;
    	TreeLinkNode current = root;
    	TreeLinkNode next = root;
    	boolean nextRowStartFound = false;
    	while (current != null){
    		if (current.left != null){
    			next.next = current.left;
    			next = current.left;
    			if (!nextRowStartFound){
    				nextRowStartFound = true;
    				rowStart = next;
    			}
    		}
    		if (current.right != null){
    			next.next = current.right;
    			next = current.right;
    			if (!nextRowStartFound){
    				nextRowStartFound = true;
    				rowStart = next;
    			}
    		}
    		if (current.next == rowStart){
    			current.next = null;
    			current = rowStart;
    			nextRowStartFound = false;
    		} else {
    			current = current.next;
    		}
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
