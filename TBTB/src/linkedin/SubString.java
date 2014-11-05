package linkedin;

public class SubString {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return null;
        if (needle.length() == 0) return haystack;
        int length = haystack.length();
        int M = needle.length();
        int [][] dfa = new int[256][M];
        
        int X = 0;
        dfa[needle.charAt(0)][0] = 1;
        for (int i = 1; i < M; i++){
        	for (int j = 0; j < 256; j++){
        		dfa[j][i] = dfa[j][X];
        	}
        	dfa[needle.charAt(i)][i] = i+1;
        	X = dfa[needle.charAt(i)][X];
        }
        
        int j = 0;
        for (int i = 0; i < length; i++){
        	j = dfa[haystack.charAt(i)][j];
        	if (j == M) return haystack.substring(i + 1 -j);
        }
        return null;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubString ss = new SubString();
		System.out.println(ss.strStr("mississippi", "issip"));
	}

}
