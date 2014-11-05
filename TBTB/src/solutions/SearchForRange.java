package solutions;

public class SearchForRange {

	/**
	 * @param args
	 */
    public int[] searchRange(int[] A, int target) {
    	int [] res = new int[] {-1, -1}; 
    	if (A == null || A.length == 0)	return res;
    	int start = 0;
    	int end = A.length - 1;
    	while (start <= end){
    		int mid = (start + end) / 2;
    		if (A[mid] < target){
    			start = mid + 1;
    		} else if (A[mid] > target){
    			end = mid - 1;
    		} else{
    			if (mid == 0 || A[mid-1] != A[mid]) res[0] = mid;
    			else {
    				end = mid -1;
    			}
    		}	
    	}
    	
    	start = 0;
    	end = A.length -1;
    	while (start <= end){
    		int mid = (start + end) / 2;
    		if (A[mid] < target){
    			start = mid + 1;
    		} else if (A[mid] > target){
    			end = mid - 1;
    		} else{
    			if (mid==A.length-1 || A[mid+1] != A[mid]) res[1] = mid;
    			else start = mid+1;
    		}	
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
