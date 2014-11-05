package solutions;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1 ) return -1;
        int [][] map = new int[m][n];
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++){
        		if (i == 0 && j==0) map[i][j] = 1;
        		else if (i != 0 && j==0) map[i][j] = map[i-1][j];
        		else if (i ==0 && j != 0) map[i][j] = map[i][j-1];
        		else map[i][j] = map[i-1][j] + map[i][j-1];
        	}
        }
        return map[m-1][n-1];
    }
    
    public int uniquePath2(int[][] obstacleGrid){
    	if (obstacleGrid == null) return 0;
    	int m = obstacleGrid.length;
    	if ( m < 1) return 0;
    	int n = obstacleGrid[0].length;
    	if ( n < 1) return 0;
    	int [][] map = new int [m][n];
    	for (int i = 0; i < m; i++){
    		for (int j = 0; j < n; j++){
    			if (i == 0 && j == 0 ){
    				if (obstacleGrid[0][0] != 1) map[i][j] = 1;
    				else map [i][j] = 0;
    			}
    			else if (i == 0 && j != 0){
    				if (obstacleGrid[i][j] != 1) map[i][j] = map[i][j-1];
    				else map [i][j] = 0;
    			}
    			else if (i != 0 && j == 0){
    				if (obstacleGrid[i][j] != 1) map[i][j] = map[i-1][j];
    				else map[i][j] = 0;
    			}
    			else map[i][j] = obstacleGrid[i][j] == 0 ? (map[i][j-1] + map[i-1][j]):0; 
    		}
    	}
    	return map[m-1][n-1];
    }
}
