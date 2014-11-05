package arrays;

public class SearchInRotatedArray {

	/**
	 * @param args
	 * 
	 * Up to this point, I think it is confident to say questions about sorted array:
	 * if it is not related to lists/trees, it can always connect to binary search.
	 * And the time complexity is almost always logN;
	 * 
	 * Still needs to be very careful about the edge cases
	 */
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) return -1;
		int start = 0;
		int end = A.length - 1;
		int len = A.length;
		while (start <= end){
			int mid = (start + end)/2;
			if ( A[mid] == target) return mid;
			else if ( A[mid] >= A[start]){ // if the left is sorted
				if ( A[start] <= target && target < A[mid]) end = mid-1;
				else {
					start = mid + 1;
				}
			} else{   // if the right is sorted
				if ( A[mid] < target && target <= A[end]) start = mid+1;
				else{
					end = mid - 1;
				}
			}
		}
		return -1;
	}
	public boolean searchII(int[] A, int target) {
		if (A== null || A.length == 0) return false;
		int start = 0;
		int end = A.length;
		while (start <= end){
			int mid = (start + end)/2;
			if (A[mid] == target) return true;
			else if ( A[mid] > A[start]){
				if (A[start] <= target && target < A[mid]) end = mid-1;
				else start = mid + 1;
			} else if (A[mid] == A[start]){
				for (int i = start; i <= end; i++){
					if (A[i] == target) return true;
				}
				return false;
			} else {
				if (A[mid] < target && target <= A[end]) start = mid+1;
				else end = mid - 1;
			}
		}
		return false;
	}
	
	
	/**
	 * A pivot is defined as the index of the largest element in the array
	 * 
	 * This is a very detailed question and it is hard.
	 * 
	 * Needs to decide how to move lo and hi.
	 * 
	 * Also needs to be careful about when only has 2 elemnts
	 * 
	 * **/
	public int findPivot(int [] A){
		if (A == null || A.length == 0) return -1;
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi){
			int mid = lo + (hi - lo)/2;
			if (mid == lo) return A[lo] > A[hi] ? lo : hi;
			else if (A[mid] > A[lo]) lo = mid;
			else hi = mid - 1;
		}
		return lo;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] in = new int [] {9, 10, 1, 2, 3, 4};
		SearchInRotatedArray search = new SearchInRotatedArray();
		System.out.println(search.findPivot(in));
	}

}
