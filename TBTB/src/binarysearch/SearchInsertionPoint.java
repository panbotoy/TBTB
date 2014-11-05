package binarysearch;

public class SearchInsertionPoint {

	/**
	 * @param args
	 * 
	 * This will be a basic binary search question
	 */
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) return -1;
		int lo = 0;
		int hi = A.length-1;
		while (lo <= hi){
			int mid = lo + (hi-lo)/2;
			if (A[mid] == target) return mid;
			else if (A[mid] < target) lo = mid + 1;
			else hi = mid - 1;
		}
		return lo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
