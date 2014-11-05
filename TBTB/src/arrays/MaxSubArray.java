package arrays;

public class MaxSubArray {
	public MaxSubArray(){}
	
    public int maxSubArray(int[] A) {
        if (A == null) return 0;
        return this.maxSubArrayHelper(A, 0, A.length - 1);
      
    }
    private int maxSubArrayHelper(int [] A, int left, int right){
    	if (left == right) return A[left];
    	int mid = (left+right)/2;
    	int leftanswer = maxSubArrayHelper(A, left, mid);
    	int rightanswer = maxSubArrayHelper(A, mid+1, right);
    	int midanswer = A[mid] + this.maxLeftHalfSum(A, left, mid - 1) + this.maxRightHalfSum(A, mid +1, right);
    	return Math.max(Math.max(leftanswer,rightanswer) , midanswer);
    }
    
    private int maxLeftHalfSum(int [] A, int left, int right){
    	int temp = 0;
    	int result = 0;
    	for (int i = right; i >=left; i--){
    		temp = temp + A[i];
    		if (temp > result) result = temp;
    	}
    	return result;
    }
    
    private int maxRightHalfSum(int [] A, int left, int right){
    	int temp = 0;
    	int result = 0;
    	for (int i = left; i <=right; i++){
    		temp = temp + A [i];
    		if(temp > result) result = temp;
    	}
    	return result;
    }
}
