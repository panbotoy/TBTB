package solutions.linkedList;

public class LinkedListHelper {
	public static ListNode initializeLinkedList(String string){
		String [] nodeValues = string.split(",");
		ListNode head = null;
		ListNode last = null;
		for (String nodeValue : nodeValues){
			nodeValue = nodeValue.trim();
			ListNode node = new ListNode(Integer.valueOf(nodeValue));
			if(head == null) {
				head = node;
				last = node;
			}
			else {
				last.next = node;
				last = last.next;
			}
		}
		return head;
	}
	
	public  static String printLinkedList(ListNode head){
		StringBuilder sb = new StringBuilder();
		while (head!= null){
			sb.append(head.val).append(", ");
			head = head.next;
		}
		return sb.toString();
	}
}
