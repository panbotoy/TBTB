package string.dp;

public class WildCardMatching {

	/**
	 * @param args
	 * 
	 * 1. pay attention to the handling with *. very subtle and interesting
	 * 2. it seems that time limit exceeded still happens if we use DP.
	 * 
	 */
	public boolean isMatchOrigDP(String s, String p) {
		if (s == null || p == null) return false;
		int m = s.length();
		int n = p.length();
		boolean [][] res = new boolean[m+1][n+1];
		for (int j = 0; j < n+1; j++){
			for (int i = 0; i < m+1; i++){
				if ( i==0 && j==0) res[i][j] = true;
				else if ( i != 0 && j == 0) res[i][j] = false;
				else if ( i==0 && j!=0) {
					if ( p.charAt(j-1) == '*') res[i][j] = res[i][j-1];
					else res[i][j] = false;
				} else {
					if ( p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
						res[i][j] = res[i-1][j-1];
					} else if (p.charAt(j-1) == '*'){
						res[i][j] = res[i-1][j] || res[i][j-1];
					} else {
						res[i][j] = false;
					}
				}
			}
		}
		return res[m][n];	
	}
	
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		int m = s.length();
		int n = p.length();
		boolean [] res = new boolean[m+1];
		boolean [] prev = new boolean[m+1];
		int startCol = 0;
		for (int j = 0; j < n+1; j++){
			boolean foundStart = false;
			for (int i = startCol; i < m+1; i++){
				if ( i==0 && j==0) res[i] = true;
				else if ( i != 0 && j == 0) res[i] = false;
				else if ( i==0 && j!=0) {
					if ( p.charAt(j-1) == '*') res[i] = prev[i];
					else res[i] = false;
				} else {
					if ( p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
						res[i] = prev[i-1];
					} else if (p.charAt(j-1) == '*'){
						res[i] = res[i-1] || prev[i];
					} else {
						res[i] = false;
					}
				} 
				if (res[i] && !foundStart) {
					startCol = i;
					foundStart = true;
				}
			}
		    prev = res;
		    res = new boolean[m+1];
		}
		return prev[m];	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildCardMatching wc = new WildCardMatching();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < 32137; i++) s.append("a");
		System.out.println(wc.isMatch(s.toString(), '*' + s.toString() + "*"));
		System.out.println(wc.isMatch("hi", "*?"));
	}

}
