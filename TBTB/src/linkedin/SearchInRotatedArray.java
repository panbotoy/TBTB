package linkedin;

public class SearchInRotatedArray {

	/**
	 * @param args
	 */
	
    public boolean search(int[] A, int target) {
    	if (A==null || A.length == 0) return false;
    	int start = 0;
    	int end = A.length -1;
    	while (start <= end){
    		int mid = (start + end) / 2;
    		if (A[mid] == target) return true;
    		if (A[mid] == A[start] && A[mid] == A[end]) {
    		    boolean leftIsSame = true;
    		    for (int i = start; i < mid; i++){
    		        if (A[i] != A[mid]) {
    		            leftIsSame = false;
    		            break;
    		        }
    		    }
    		    if (leftIsSame){
    		        start = mid + 1;
    		    }else{
    		        end = mid -1;
    		    }
    		}
    		else if (A[mid] >= A[start]){ // left is sorted
    			if (A[start] <= target && target < A[mid]) end = mid - 1;
    			else start = mid + 1;
    		} else{  // right is sorted
    			if (A[mid] < target && target <= A[end]) start = mid + 1;
    			else end = mid - 1;
    		}
    	}
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
