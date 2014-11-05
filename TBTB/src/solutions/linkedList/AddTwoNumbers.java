package solutions.linkedList;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)  return null;
        int carry = 0;
        return this.addTwoNumbersHelper(l1, l2, carry);
    }
    
    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry){
        if (l1 == null && l2 == null && carry == 0) return null;
        int val1 = l1 == null? 0 : l1.val;
        int val2 = l2 == null? 0 : l2.val;
        int sum = val1 + val2 + carry;
        int val = sum % 10;
        carry = sum / 10;
        ListNode current = new ListNode (val);
        current.next = this.addTwoNumbersHelper(l1 == null ? null : l1.next, l2 == null? null : l2.next, carry);
        return current;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
