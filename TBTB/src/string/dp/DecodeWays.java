package string.dp;

public class DecodeWays {

	/**
	 * @param args
	 * In this question, input like 013 is not valid. the decode ways is 0. In this approach, we need to pay attention to 
	 * invalid input like this
	 * 
	 * My older version provides better validation for the input.
	 * 
	 * if we assume that the message is a valid message, then we can probably have a shorter solution
	 * 
	 * This question idea is very simple. But need to deal with dirty details when i == 0 or i == 1;
	 * 
	 */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int [] res = new int[s.length()];
        int m  = s.length();
        for (int i = 0; i < m; i++){
            if ( i == 0) {
                int code = s.charAt(i) - '0';
                if (0 < code && code <= 9) res[i] = 1;
            } else {
                int code1 = s.charAt(i) - '0';
                int code2 = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
                if (0 < code1 && code1 <= 9) res[i] += res[i-1];
                if ( i == 1 && (10 <= code2 && code2 <= 26)) res[i] += 1;
                if ( i > 1 && (10 <= code2 && code2 <= 26)) res[i] += res[i-2];
            }

        }
        return res[m-1];
    }
	
    public int numDecodingsOld(String s) {
        if (s == null || s.length() == 0) return 0;
        int [] ways = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            if(i == 0) ways[i] = this.isValid(s, 0, 0);
            else if (i == 1) ways[i] = ways[0] * this.isValid(s, 1,1) + this.isValid(s, 0, 1);
            else {
                ways[i] = ways[i - 2] * this.isValid(s, i - 1, i) + ways[i - 1] * this.isValid(s, i, i);
            }
        }
        return ways[s.length() - 1];
    }
    private int isValid(String s, int start, int end){
        if (start == end ) {
            String substring = s.substring(start,start+1);
            if (Integer.valueOf(substring) > 0 ) return 1;
            return 0;
        }
        String substring = s.substring(start, end + 1);
        if (Integer.valueOf(substring) <= 26 && Integer.valueOf(substring)>= 10) return 1;
        return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
