package DP;

public class RegularExpressionMatching {

	/**
	 * @param args
	 * 
	 * The most difficult part is to consider the * case
	 * 
	 */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int n = s.length();
        int m = p.length();
        boolean [][] match = new boolean[m+1][n+1];
        for (int i = 0; i < m+1; i++){
            for (int j = 0; j < n+1; j++){
            	if (i == 0 && j == 0) match[i][j] = true;
            	else if (i == 0 && j != 0) match[i][j] = false;
            	else if (i != 0 && j == 0){
            		if (p.charAt(i-1)!='*') match[i][j] = false;
            		else match[i][j] = match[i-1][j] || match[i-2][j];
            	}
            	else{
            		if (p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j-1)){
            			match[i][j] = match[i-1][j-1];
            		}
            		else if (p.charAt(i-1) == '*'){
            			if (i-1 == 0) // * is the first char of p
            			{
            				match[i][j] = false;
            			} else if (p.charAt(i-2) == '*'){
            				match[i][j] = match[i-1][j];
            			} else if (p.charAt(i-2) == '.'){
            				match[i][j] = match[i-2][j] || match[i-1][j] || match[i][j-1];
            			} else {
            				if (j>=2 && s.charAt(j-1) == s.charAt(j-2)){
            					match[i][j] = match[i-2][j] || match[i-1][j] || match[i-1][j-1];
            				} else{
            					match[i][j] = match[i-2][j] || match[i-1][j];
            				}
            			}
            		}
            		
            	}
            }
        }
        return match[m][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching match = new RegularExpressionMatching();
		System.out.println(match.isMatch("aaa", "ab*a"));
	}

}
