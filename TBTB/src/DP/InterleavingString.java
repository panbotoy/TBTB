package DP;

public class InterleavingString {

	/**
	 * @param args
	 */
    public boolean isInterleaveRC(String s1, String s2, String s3) {
    	if (s1 == null && s2 == null) return false;
    	if (s3 == null) return false;
    	if (s1.length()==0 && s2.length() == 0 && s3.length() == 0) return true;
    	if (s1 == null || s1.length() == 0 ) return s2.equals(s3);
    	if (s2 == null || s2.length() == 0 ) return s1.equals(s3);
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char c3 = s3.charAt(0);
        boolean interLeave1 = false;
        boolean interLeave2 = false;
        if (c3 == c1){
        	String sub3 = s3.substring(1);
        	String sub1 = s1.substring(1);
        	interLeave1 = this.isInterleaveRC(sub1, s2, sub3);
        } 
        if (c3 == c2){
        	String sub3 = s3.substring(1);
        	String sub2 = s2.substring(1);
        	interLeave2 = this.isInterleaveRC(s1, sub2, sub3);
        }
        return interLeave1 || interLeave2;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1 == null && s2 == null) return false;
    	if (s3 == null) return false;
    	if (s1.length()==0 && s2.length() == 0 && s3.length() == 0) return true;
    	if (s1 == null || s1.length() == 0 ) return s2.equals(s3);
    	if (s2 == null || s2.length() == 0 ) return s1.equals(s3);
    	if (s3.length() != s1.length() + s2.length()) return false;
    	boolean [][] s = new boolean[s1.length() + 1][s2.length() + 1];
    	s[0][0] = true;
    	for (int i = 0; i < s1.length(); i++){
    		s[i + 1][0] = s[i][0] && (s1.charAt(i) == s3.charAt(i)); 
    	}
    	for (int j = 0; j < s2.length(); j++){
    		s[0][j + 1] = s[0][j] && (s2.charAt(j) == s3.charAt(j));
    	}
    	for (int i = 0; i < s1.length(); i++){
    		for (int j = 0; j < s2.length(); j++){
    			s[i + 1][j + 1] = (s[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1)) ||
    					(s[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1));
    		}
    	}
    	return s[s1.length()][s2.length()];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString inter = new InterleavingString();
		System.out.println(inter.isInterleaveRC("cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc", "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb", "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb"));
	}

}
