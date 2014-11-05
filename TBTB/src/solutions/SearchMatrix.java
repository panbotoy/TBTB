package solutions;
//Could have done with one binary search, but complexity is log(mn), instead of log(m) + log(n)
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length < 1) return false;
        int m = matrix.length;
        if (matrix[0].length < 1) return false;
        int n = matrix[0].length;
        
        int targetRow = this.searchForRow(matrix, target, m);
        if (targetRow == -1) return false;
        int targetColumn = this.searchForColumn(matrix[targetRow], target, n);
        return targetColumn != -1;
    }
    
    private int searchForRow(int[][] matrix, int target, int m){
    	int left = 0;
    	int right = m - 1;
    	int mid = (left + right) / 2;
    	while ( left <= right){
    		if ( target < matrix[mid][0]){
    			right = mid - 1;
    			mid = (left + right)/2;
    		} else if (target > matrix[mid][0]){
    			left = mid + 1;
    			mid = (left + right)/2;
    		}
    		else {
    			return mid;
    		}
    	}
    	return mid;
    }
    
    private int searchForColumn(int [] row, int target, int n){
    	int left = 0;
    	int right = n - 1;
    	int mid = (left + right) / 2;
    	while (left <= right){
    		if (target < row[mid]){
    			right = mid - 1;
    			mid = (left + right) / 2;
    		} else if (target > row[mid]){
    			left = mid + 1;
    			mid = (left + right) / 2;
    		} else 
    			return mid;
    	}
    	return -1;
    }
}
