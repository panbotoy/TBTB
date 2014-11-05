package solutions.linkedList;

import solutions.tree.TreeNode;

public class ConvertSortedListToTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = head;
        ListNode leftHead = head;
        ListNode leftEnd = head;
        ListNode rightHead = head;
        int length = 0;
        while (head != null){
        	head = head.next;
        	length++;
        }
        for (int i = 0; i < length/2; i++){
        	if (i > 0) leftHead = leftHead.next;
        	mid = mid.next;
        	rightHead = mid.next;
        }
        TreeNode root = new TreeNode(mid.val);
        leftHead.next = null;
        if (leftEnd != mid) root.left= this.sortedListToBST(leftEnd);
        if (rightHead != mid) root.right = this.sortedListToBST(rightHead);
        return root;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
