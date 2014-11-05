package string.dp;

public class EditDistance {

	/**
	 * @param args
	 * 
	 * Please consider DP if the problem has the following characteristics:
	 * 1. Two strings
	 * 2. two strings will merge or one string is the substring of some sort of another string
	 * 
	 * Usually problems of this kind can be solved with recursion, but DP is more efficient;
	 */
    public int minDistance(String word1, String word2) {
    	if (word1 == null || word2 == null) return -1;
    	int m = word1.length();
    	int n = word2.length();
    	int [][] dist = new int [m+1][n+1];
    	for (int i = 0; i < m+1; i++){
    	    for (int j = 0; j < n+1 ; j++){
    	        if (i == 0 && j == 0) dist[i][j] = 0;
    	        else if (i==0 && j!=0) dist[i][j] = dist[i][j-1] + 1;
    	        else if (i!=0 && j==0) dist[i][j] = dist[i-1][j] + 1;
    	        else{
    	            int tmp = dist[i-1][j-1];
    	            if (word1.charAt(i-1) != word2.charAt(j-1)) tmp += 1;
    	            dist[i][j] = Math.min(Math.min(dist[i-1][j] + 1, dist[i][j-1] + 1), tmp);
    	        }
    	    }
    	}
    	return dist[m][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
