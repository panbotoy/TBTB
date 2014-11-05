package linkedin;

public class TrapRainWater {

	/**
	 * 
	 * This problem is very similar to array multiplication problem.
	 * remember this. if we need to get a question requires to do some computation for every element in an array,
	 * we will also need the left and the right elements, we can consider this.
	 * 
	 * Scan the array left and right once
	 * @param args
	 */
	
    public int trap(int[] A) {
        int [] leftMax = new int[A.length];
        for (int i = 0; i < A.length; i++){
        	if (i == 0) leftMax[i] = A[i];
        	else {
        		leftMax[i] = Math.max(leftMax[i-1], A[i]);
        	}
        }
        int rightMax = 0;
        int water = 0;
        for (int i = A.length - 1; i >= 0; i--){
        	if ( i == A.length - 1) rightMax = A[i];
        	else rightMax = Math.max(rightMax, A[i]);
        	water += (Math.min(leftMax[i],rightMax) - A[i]);
        }
        return water;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
