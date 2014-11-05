package string;

public class LongestPalindromeSubstring {

	/**
	 * @param args
	 * 
	 * Actually this is one of the brute force way that I can think of.
	 * 
	 * However, it needs some careful thinking about how to deal with both the even and the odd substring.
	 */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        int reslo = 0;
        int reshi = 0;
        for (int i = 0; i < s.length(); i++){
            //find the longest palindrome centered at i
            int lo = i;
            int hi = i;
            while (lo >= 0 && hi <= s.length()-1 && s.charAt(lo) == s.charAt(hi)){
                lo--;
                hi++;
            }
            if (hi - lo - 2 > reshi-reslo) {
                reslo = lo+1;
                reshi = hi-1;
            }
            
            // find the longest even palindrome, centered at i and i+1;
            lo = i;
            hi = i+1;
            while (lo >= 0 && hi <= s.length()-1 && s.charAt(lo) == s.charAt(hi)){
                lo--;
                hi++;
            }
            if (hi - lo - 2 > reshi - reslo){
                reslo = lo+1;
                reshi = hi-1;
            }
        }
        return s.substring(reslo, reshi+1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
