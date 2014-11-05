package linkedlist;

import solutions.linkedList.ListNode;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode pseudo = new ListNode(1);
		ListNode prev = pseudo;
		while (l1 != null || l2 != null) {
			int val1 = (l1 == null) ? 0 : l1.val;
			int val2 = (l2 == null) ? 0 : l2.val;
			int sum = val1 + val2 + carry;
			int val = sum % 10;
			carry = sum / 10;
			ListNode node = new ListNode(val);
			prev.next = node;
			prev = prev.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry == 1) {
			ListNode node = new ListNode(carry);
			prev.next = node;
		}
		return pseudo.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
