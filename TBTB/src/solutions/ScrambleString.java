package solutions;

public class ScrambleString {

	/**
	 * @param args
	 */
    public boolean isScramble(String s1, String s2) {
    	if (s1 == null || s2 ==null || s1.length() != s2.length()) return false;
    	if (s1.length() == 0 ) return true;
    	if (s1.length() == 1 ) return s1.equals(s2);
    	if (!this.isPossibleScramble(s1, s2)) return false;
    	boolean isScramble = false;
    	for (int i = 1; i < s1.length(); i++){
    		String s11 = s1.substring(0, i);
    		String s12 = s1.substring(i);
    		String s21 = s2.substring(0, i);
    		String s22 = s2.substring(i);
    		String s23 = s2.substring(0, s1.length() - i);
    		String s24 = s2.substring(s1.length() - i);
    		boolean temp = (this.isScramble(s11, s21) && this.isScramble(s12, s22)) || (this.isScramble(s11, s24) && this.isScramble(s12, s23));
    		isScramble = isScramble || temp;
    		if (isScramble) return true;
    	}
    	return isScramble;
    }	
    
    private boolean isPossibleScramble(String s1, String s2){
    	int sum1 = 0;
    	int sum2 = 0;
    	for (int i = 0; i < s1.length(); i++){
    		sum1 += s1.charAt(i);
    		sum2 += s2.charAt(i);
    	}
    	return sum1 == sum2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
