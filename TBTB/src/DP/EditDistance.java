package DP;

public class EditDistance {

	/**
	 * @param args
	 * 
	 * 1. questions with 2 strings may usually use DP. take it into consideration
	 * 2. abcde aaab  is equal to judge the steps needed for abcd + aaa + 1 , abcde + aaa + 1, abcd + aaab + 1
	 * 3. always be careful with the index when deal with 2D arrays. what to return and what to start 
	 * 4. be careful with all the sequences of logical operators. no harm to put operators to brackets!
	 * 
	 */
	
    public int minDistance(String word1, String word2) {
    	if (word1 == null || word2 == null) return -1;
    	int m = word1.length();
    	int n = word2.length();
    	int [][] dist = new int [m+1][n+1];
    	for (int i = 0; i < m+1; i++) dist[i][0] = i;
    	for (int j = 0; j < n+1; j++) dist[0][j] = j;
    	for (int i = 1; i < m+1; i++){
    		for (int j = 1; j < n+1; j++){
    			int min = Math.min(dist[i-1][j] + 1, dist[i][j-1] + 1);
    			dist[i][j] = Math.min(min, dist[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1)? 0 : 1));
    		}
    	}
    	return dist[m][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance("a", "ab"));
	}

}
