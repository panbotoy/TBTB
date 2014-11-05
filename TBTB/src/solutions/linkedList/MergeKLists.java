package solutions.linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

	/**
	 * @param args
	 */
	
    public ListNode mergeKListsHeap(List<ListNode> lists) {
        if (lists ==null || lists.size() == 0) return null;
    	PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
    	for (ListNode node : lists){
    		if (node != null){
    			heap.add(node);
    		}
    	}
    	return this.mergeKListsWithHeap(lists, heap);
    }
    
    private ListNode mergeKListsWithHeap(List<ListNode> lists, PriorityQueue<ListNode> heap){
    	if (!heap.isEmpty()) {
    		ListNode head = heap.remove();
    		if (head.next != null){
    			    heap.add(head.next);
    		}
        	head.next = this.mergeKListsWithHeap(lists, heap);
        	return head;
    	}
    	return null;
    }
    
	private class ListNodeComparator implements Comparator<ListNode>{

		@Override
		public int compare(ListNode node1, ListNode node2) {
			// TODO Auto-generated method stub
			if (node1.val < node2.val) return -1;
			else if (node1.val == node2.val) return 0;
			else return 1;
		}
		
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) return null;
		ArrayList<ListNode> mergedLists = new ArrayList<ListNode>();
		ArrayList<ListNode> currentLists = new ArrayList<ListNode>(lists);
		while(currentLists.size() > 1){
			int lo = 0;
			int hi = currentLists.size() - 1;
			while (lo <= hi){
				mergedLists.add(this.mergeLists(currentLists.get(lo), currentLists.get(hi)));
				lo++;
				hi--;
			}
			currentLists = mergedLists;
			mergedLists = new ArrayList<ListNode>();
		}
		return currentLists.get(0);
	}
	
	private ListNode mergeLists(ListNode node1, ListNode node2){
		if (node1 == null) return node2;
		if (node2 == null) return node1;
		if (node1 == node2) return node1;
		ListNode head = null;
		if (node1.val <= node2.val){
			head = node1;
			head.next = this.mergeLists(node1.next, node2);
		} else {
			head = node2;
			head.next = this.mergeLists(node1, node2.next);
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(null);
		lists.add(null);
		MergeKLists mk = new MergeKLists();
		mk.mergeKLists(lists);
	}
}
