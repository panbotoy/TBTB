package string;

public class ValidPalindrome {

	/**
	 * @param args
	 * 
	 * This is a classic two points from sides to mid problem
	 * 
	 * This is a quite good solution.
	 */
	public boolean isPalindrome(String s) {
		int lo = 0;
		int hi = s.length()-1;
		while (lo < hi){
			char c1 = s.charAt(lo);
			char c2 = s.charAt(hi);
			if (isValid(c1) && isValid(c2)){
				c1 = (char) (('a' <= c1 && c1 <= 'z' || '0' <= c1 && c1<= '9')? c1 : (c1 - 'A' + 'a'));
				c2 = (char) (('a' <= c2 && c2 <= 'z' || '0' <= c2 && c2<= '9')? c2 : (c2 - 'A' + 'a'));
				if (c1 == c2) {
					lo++;
					hi--;
				} else return false;
			} else if (isValid(c1)){
				hi--;
			} else if (isValid(c2)){
				lo++;
			} else {
				lo++;
				hi--;
			}
		}
		return true;
	}
	
	private boolean isValid(char c){
		return 'a' <= c && c<='z' || 'A'<= c && c<= 'Z' || '0' <= c && c<='9';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
