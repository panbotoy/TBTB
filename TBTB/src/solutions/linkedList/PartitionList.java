package solutions.linkedList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode pseudoHead = new ListNode(Integer.MIN_VALUE);
        pseudoHead.next = head;
        ListNode runner = pseudoHead;
        ListNode i1 = pseudoHead;
        ListNode i2 = pseudoHead.next;
        boolean foundInsertionPoint = false;
        while(runner != null && runner.next != null){
        	if (runner.next.val >= x && !foundInsertionPoint){
        		foundInsertionPoint = true;
        		i1 = runner;
        		i2 = runner.next;
        	}
        	if (runner.next.val < x && foundInsertionPoint){
        		ListNode next = runner.next.next;
        		ListNode target = runner.next;
        		i1.next = target;
        		target.next = i2;
        		i1 = i1.next;
        		runner.next = next;
        		continue;
        	}
        	runner = runner.next;
        }
        return pseudoHead.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
