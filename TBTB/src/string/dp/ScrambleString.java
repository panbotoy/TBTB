package string.dp;

public class ScrambleString {

	/**
	 * @param args
	 * 
	 * WTF is this question!
	 * 
	 * It's hard to understand what "scramble" implies.
	 * It actually means that after the first break, the left and the right of s1 and s2 are further scrambles
	 */
    public boolean isScramble(String s1, String s2) {
    	if (s1 == null || s2 ==null || s1.length() != s2.length()) return false;
    	if (s1.length() == 0 ) return true;
    	if (s1.length() == 1 ) return s1.equals(s2);
    	boolean isScramble = false;
    	for (int i = 1; i < s1.length(); i++){
    		String s11 = s1.substring(0, i);
    		String s12 = s1.substring(i);
    		String s21 = s2.substring(0, i);
    		String s22 = s2.substring(i);
    		String s23 = s2.substring(0, s1.length() - i);
    		String s24 = s2.substring(s1.length() - i);
    		if (isAnagram(s11,s21) && isAnagram(s12, s22))
    		    isScramble = isScramble(s11, s21) && isScramble(s12, s22);
    		if (isAnagram(s11,s24) && isAnagram(s12, s23))
    		    isScramble = isScramble || (isScramble(s11,s24) && isScramble(s12, s23));
    		if (isScramble) return true;
    	}
    	return false;
    }	
    
    private boolean isAnagram(String s1, String s2){
        if (s1 == null || s2 == null) return false;
        int [] counters = new int[256];
        for (int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            counters[c1]++;
            counters[c2]--;
        }
        for (int i = 0; i < 256; i++){
            if (counters[i] != 0) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
