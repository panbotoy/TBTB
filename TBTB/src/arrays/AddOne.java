package arrays;

import solutions.linkedList.ListNode;

public class AddOne {

	/**
	 * @param args
	 * 
	 * I put all the questions related to big number addition to here.
	 * 
	 */
    public int[] plusOne(int[] digits) {
    	if (digits == null || digits.length == 0) return null;
    	int carry = 1;
    	for (int i = digits.length - 1; i >= 0; i--){
    		digits[i] += carry;
    		carry = digits[i] / 10;
    		digits[i] = digits[i] % 10;
    	}
    	if (carry == 1){
    	    digits = new int [digits.length + 1];
    	    digits[0] = 1;
    	}
		return digits;
    }
    
    
    /**
     * Need to be careful with parsing a char to int. Need to convert char to string first, otherwise it will 
     * use ascii code of char as the integer value
     * ***/
    public String addBinary(String a, String b) {
    	if (a == null || b == null || a.length() == 0 || b.length()==0) return null;
    	int i = a.length() - 1;
    	int j = b.length() - 1;
    	StringBuilder sb = new StringBuilder();
    	int carry = 0;
    	while (i >= 0 || j >= 0){
    		int num1 = i >= 0 ? Integer.parseInt(String.valueOf(a.charAt(i--))) : 0;
    		int num2 = j >= 0 ? Integer.parseInt(String.valueOf(b.charAt(j--))) : 0;
    		int sum = num1 + num2 + carry;
    		int val = sum % 2;
    		carry = sum/2;
    		sb.append(val);
    	}
    	if (carry == 1) sb.append(1);
    	return sb.reverse().toString();
    }
    
    
    /**
     * Add two numbers
     * **/
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode sudo = new ListNode(1);
    	ListNode prev = sudo;
    	int carry = 0;
    	while (l1 != null || l2 != null){
    		int num1 = l1 != null ? l1.val : 0;
    		int num2 = l2 != null ? l2.val : 0;
    		int sum = num1 + num2 + carry;
    		int val = sum % 10;
    		carry = sum / 10;
    		ListNode node = new ListNode(val);
    		prev.next = node;
    		prev = prev.next;
    		if (l1 != null ) l1 = l1.next;
    		if (l2 != null) l2 = l2.next;
    	}
    	if (carry == 1) prev.next = new ListNode(1);
    	return sudo.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOne add = new AddOne();
		add.addBinary("1", "1");
		
	}

}
