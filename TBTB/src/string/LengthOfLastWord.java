package string;

public class LengthOfLastWord {

	/**
	 * @param args
	 * 
	 * This question is pretty straight forward
	 * Test case I can think of is abc, abc de, "   " 
	 */
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) return 0;
		int len = 0;
		for (int i = s.length()-1; i>= 0; i--){
			if (s.charAt(i) != ' ') len++;
			else if (len > 0) return len;
		}
		return len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
