package binarysearch;

public class SearchIn2DArray {

	/**
	 * @param args
	 * 
	 * This question examines the knowledge of binary search.
	 * 
	 * A tricky part is that for the first bst, need to make sure it does not only check if it is larget than 
	 * matrix[mid][0] , lo = mid + 1;
	 * it needs to make sure it does not belong to this row by checking the end of this row
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) return false;
		if (matrix.length == 0) return false;
		int m = matrix.length;
		if (matrix[0].length == 0) return false;
		int n = matrix[0].length;
		
		int lo = 0;
		int hi = m - 1;
		int mid = -1;
		while (lo <= hi){
			mid = (lo + hi)/2;
			if ( matrix[mid][0] <= target && target <= matrix[mid][n-1]) break;
			else if (matrix[mid][0] > target) hi = mid-1;
			else lo = mid + 1;
		}
		// now mid should contain the correct row value;
		lo = 0;
		hi = n - 1;
		int row = mid;
		while (lo <= hi){
			mid = (lo + hi) / 2;
			if (matrix[row][mid] == target) return true;
			else if (matrix[row][mid] > target) hi = mid - 1;
			else lo = mid + 1;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
