package string.dp;

public class InterleavingString {

	/**
	 * @param args
	 * 
	 * When try to use two pointers, found that if there are both same chars in both arrays,
	 * 
	 * we don't know which pointer to move. So comes up with a thought of recursion or DP.
	 * 
	 * string dp usually requires a 2D array of [m+1][n+1], and the first element is ""
	 * 
	 * pay attention to the initialization part
	 */
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1 == null || s2 == null || s3 == null) return false;
    	if (s3.length() != s1.length() + s2.length()) return false;
    	boolean [][] s = new boolean[s1.length() + 1][s2.length() + 1];
    	s[0][0] = true;
    	for (int i = 1; i < s1.length()+1; i++){
    		s[i][0] = s1.charAt(i-1) == s3.charAt(i-1); 
    	}
    	for (int j = 1; j < s2.length()+1; j++){
    		s[0][j] = s2.charAt(j-1) == s3.charAt(j-1); 
    	}
    	for (int i = 1; i < s1.length()+1; i++){
    		for (int j = 1; j < s2.length()+1; j++){
    			s[i][j] = (s[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j-1)) ||
    					(s[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j-1));
    		}
    	}
    	return s[s1.length()][s2.length()];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
