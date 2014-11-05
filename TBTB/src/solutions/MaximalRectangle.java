package solutions;

public class MaximalRectangle {

	/**
	 * @param args
	 */
	/*******
	 * 1. analyze how to calculate the area of a rectangle, don't panic
	 * *********/
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length==0) return 0;
        int M = matrix.length;
        int N = matrix[0].length;
        
        int area = 0;
        for (int i = 0; i < M; i++){
        	for (int j = 0; j < N; j++){
        		if (matrix[i][j] == '0') continue;
        		//int localArea = 0;
        		int minLen = N;
        		int height = i;
        		while (height<M && matrix[height][j] != '0'){
        			height++;
        		}
        		for (int k = i; k < height; k++){
        			int len = j;
        			while (len<N && matrix[height][len] != '0'){
        				len++;
        			}
        			if ((len - j) * (height - i) < area) break;
        			minLen = Math.min(minLen, (len - j));
        			area = Math.max(area, minLen * (k - i + 1));
        		}
        	}
        }
        return area;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
