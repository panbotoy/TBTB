package solutions;

public class setZero {

	/**
	 * @param args
	 */
    public void setZeroes(int[][] matrix) {
    	if (matrix == null || matrix.length < 1) return;
    	int m = matrix.length;
    	if (matrix[0].length < 1) return;
    	int n = matrix[0].length;
    	
        int [] rows = new int [m];
        int [] columns = new int [n];
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++){
        		if (matrix[i][j] == 0){
        			rows[i] = 1;
        			columns[j] = 1;
        		}
        	}
        }
        for (int i = 0; i < m ; i++){
        	if (rows[i] == 1) {
        		for (int j = 0; j < n; j++){
        			matrix[i][j] = 0;
        		}
        	}
        }
        for (int j = 0; j < n; j++){
        	if (columns[j] == 1){
        		for (int i = 0; i < m; i ++){
        			matrix[i][j] = 0;
        		}
        	}
        }
    }

}
