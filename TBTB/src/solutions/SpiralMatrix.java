package solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return result;
        int m = matrix.length;
        if (matrix[0].length < 1) return result;
        int n = matrix[0].length;
        
        this.spiralHelper(matrix, 0, m - 1, 0, n - 1, result);
        return result;	
    }

	private void spiralHelper(int [][] matrix, int mStart, int mEnd, int nStart, int nEnd, ArrayList<Integer> result){
		if (mStart < mEnd && nStart < nEnd){
			for (int i = nStart; i < nEnd; i++) result.add(matrix[mStart][i]);
			for (int i = mStart; i < mEnd; i++) result.add(matrix[i][nEnd]);
			for (int i = nEnd; i > nStart; i--) result.add(matrix[mEnd][i]);
			for (int i = mEnd; i > mStart; i--) result.add(matrix[i][nStart]);
			if ((mEnd - mStart == 1 ) || (nEnd - nStart == 1)) return;
			this.spiralHelper(matrix, mStart+1, mEnd-1, nStart+1, nEnd-1, result);
			return;
		}
		else if (mStart == mEnd && nStart != nEnd){
			for (int i = nStart; i <= nEnd; i++) result.add(matrix[mStart][i]);
		}
		else if (nStart == nEnd){
			for (int i = mStart; i <= mEnd; i++) result.add(matrix[i][nStart]);
		}
	}
	private int count = 1;
    public int[][] generateMatrix(int n) {
        if (n < 0) return null;
    	int [][] matrix = new int [n][n];
        int nSquare = n * n;
    	
        this.generateHelper(matrix, 0, n-1);
        return matrix;
    }
    private void generateHelper(int [][] matrix, int start, int end){
    	if (start > end ) return;
    	else if (start == end) matrix[start][start] = this.count;
    	else {
    		for (int i = start; i < end; i++) matrix[start][i] = this.getCount();
    		for (int i = start; i < end; i++) matrix[i][end] = this.getCount();
    		for (int i = end; i > start; i--) matrix[end][i] = this.getCount();
    		for (int i = end; i > start; i--) matrix[i][start] = this.getCount();
    		this.generateHelper(matrix, start + 1, end - 1);
    	}
    }
    private int getCount(){ return count++;}
}
