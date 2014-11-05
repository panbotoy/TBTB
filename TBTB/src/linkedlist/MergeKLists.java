package linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import solutions.linkedList.ListNode;

public class MergeKLists {

	/**
	 * @param args
	 * 
	 * 1. heap.
	 * 2. divide and conquer
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null) return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(1, new MyComparator());
		ListNode sudo = new ListNode(0);
		ListNode prev = sudo;
		for (ListNode node : lists){
			if (node != null) queue.offer(node);
		}
		while (queue.size() != 0){
			prev.next = queue.poll();
			prev = prev.next;
			if ( prev.next != null){
				queue.offer(prev.next);
			}
		}
		return sudo.next;
	}

	public class MyComparator implements Comparator<ListNode>{
		@Override
		public int compare(ListNode l1, ListNode l2){
			if (l1.val < l2.val) return -1;
			else if (l1.val > l2.val) return 1;
			else return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
