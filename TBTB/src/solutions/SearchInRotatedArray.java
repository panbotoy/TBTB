package solutions;

public class SearchInRotatedArray {

	/**
	 * @param args
	 */
    public int search(int[] A, int target) {
    	/**
    	 * Pivot is defined as the index in A of the smallest element.
    	 */
    	if (A == null || A.length == 0) return -1;
    	int pivot = this.findPivot(A);
    	int n = A.length;
    		int indexl = this.findElement(A, target, 0, pivot);
    		int indexr = this.findElement(A, target, pivot, n);
    		if (indexl != -1 || indexr != -1){
    		    return indexl != -1 ? (n - pivot + indexl) : indexr - pivot;
    		} else return -1;
    }
    
    private int findPivot(int [] A){
    	if (A.length == 1) return 0;
    	int left=  0;
    	int right = A.length - 1;
    	
    	while (left < right){
    		int mid = (right + left) / 2;
    		if (A[left] < A[mid]&& A[mid] > A[right]){
    			left = mid;
    		} else if (A[left] > A[mid] && A[mid] < A[right]) {
    			right = mid;
    		} else if (A[left] <= A[mid] && A[mid] <= A[right]){
    			return left;
    		} else if (A[left] == A[mid]) return left + 1;
    	}
    	return left + 1;
    }
    
    private int findElement(int [] A, int target, int left, int right){
    	int lo = left;
    	int hi = right - 1;
    	if (left >= right ) return - 1;
    	while (lo < hi){
    		int mid = (lo + hi) / 2;
    		if (A[mid] < target){
    			lo = mid + 1;
    		} else if (A[mid] > target){
    			hi = mid - 1;
    		} else {
    			return mid;
    		}
    	}
    	return A[lo] == target? lo: -1;
    	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = new int [] {3, 1};
		SearchInRotatedArray search = new SearchInRotatedArray();
		System.out.println(search.findPivot(A));
		System.out.println(search.findElement(A, 1, 0, 2));
	}

}
