package solutions.linkedList;

public class mergeSortedList {
	public mergeSortedList() {
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp = null;
		ListNode head = null;
		if (l1 != null && l2 == null) {
			return l1;
		} else if (l1 == null && l2 != null) {
			return l2;
		} else if (l1 == null && l2 == null) {
			return null;
		} else {
			head = (l1.val<=l2.val)?l1:l2;
			while (l1 != null && l2 != null) {

				if (l1.val <= l2.val) {
					temp = l1;
					while (temp.next != null && temp.next.val <= l2.val) {
						temp = temp.next;
					}
					l1 = temp.next;
					temp.next = l2;
				} else {
					temp = l2;
					while (temp.next != null && temp.next.val <= l1.val) {
						temp = temp.next;
					}
					l2 = temp.next;
					temp.next = l1;
				}
			}
			return head;
		}

	}
}
