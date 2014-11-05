package arrays;

public class MaxSubArrayProduct {

	/**
	 * @param args
	 * 
	 * This problem is a little tricky. There are two important points:
	 * 1. use max[i] and min[i] to track the maximum/minimum product we can get using A[i];
	 * 2. in the case when A[i] < 0, we need to understand that max[i] >= min[i];
	 * based on this conclusion, we can say that if min[i-1] < 0, max[i-1] must be min[i-1] <= max[i-1]. so max is A[i] * min[i-1]
	 * if min[i-1] > 0, max[i-1] > 0. so the max would be A[i].
	 */
    public int maxProductInitial(int[] A) {
        if (A == null || A.length == 0) return -1;
        int [] max = new int [A.length];
        int [] min = new int [A.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++){
        	if (A[i] > 0){
        		if (i == 0){
        			max[i] = A[i];
        			min[i] = A[i];
        			continue;
        		}
        		if (max[i-1] > 0 ){
        			max[i] = max[i-1] * A[i];
        		} else {
        			max[i] = A[i];
        		}
        		if (min[i-1] <= 0){
        			min[i] = min[i-1] * A[i];
        		} else {
        			min[i] = A[i];
        		}
        		
        	} else if (A[i] == 0) {
        		max[i] = A[i];
        		min[i] = A[i];
        	} else {
        		if (i == 0){
        			max[i] = A[i];
        			min[i] = A[i];
        			continue;
        		}
        		if (min[i-1] < 0 ){
        			max[i] = min[i-1] * A[i];
        		} else {
        			max[i] = A[i];
        		}
        		if (max[i-1]> 0) min[i] = max[i-1]*A[i];
        		else min[i] = A[i];
        	}
        	
        	res = Math.max(res, max[i]);
        }
        return res;
    }
    
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) return -1;
        int [] max = new int [A.length];
        int [] min = new int [A.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++){
            if (i == 0){
        			max[i] = A[i];
        			min[i] = A[i];
        	} else {
        	    if (A[i] > 0){
        	        max[i] = max[i-1] > 0 ? max[i-1] * A[i] : A[i];
        	        min[i] = min[i-1] <= 0 ? min[i-1] * A[i] : A[i];
        	    }else if (A[i] == 0){
        	        max[i] = 0;
        	        min[i] = 0;
        	    } else {
        	        max[i] = min[i-1] < 0 ? min[i-1] * A[i] : A[i];
        	        min[i] = max[i-1] > 0 ? max[i-1] * A[i] : A[i];
        	    }
        	}
        	res = Math.max(res, max[i]);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
