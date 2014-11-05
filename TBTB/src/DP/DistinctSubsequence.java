package DP;

public class DistinctSubsequence {

	/**
	 * @param args
	 */
	
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        if (S.length() < T.length()) return 0;
        int m = S.length();
        int n = T.length();
        int [][] dist = new int [m+1][n+1];
        for (int i = 0; i < n+1; i++) dist[0][i] = 0; // initialize it to 0 because if s == "", res = 0 if T != ""
        for (int i = 0; i < m+1; i++) dist[i][0] = 1; // initialize it to 1 because if T == "", res = 1 no matter what is S.
        for (int i = 1; i < m+1; i++){
        	for (int j = 1; j < n+1; j++){
        		if (S.charAt(i-1) == T.charAt(j-1)){
        			dist[i][j] = dist[i-1][j-1] + dist[i-1][j];
        		}
        		else{
        			dist[i][j] = dist[i-1][j];
        		}
        	}
        }
        return dist[m][n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
