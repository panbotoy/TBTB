package arrays;

import java.util.Stack;

public class TrappingRainWater {
	
	/**
	 * @param args
	 * 
	 * 1. I come up with a solution very similar to Largest Rectangle in historgram
	 * 
	 * It uses a stack, and adds the water level by level, instead of column by column
	 */
    public int trapStack(int[] A) {
    	if ( A== null || A.length ==0) return 0;
    	int water = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < A.length; i++){
    		if (stack.isEmpty() || A[i] < A[stack.peek()]){
    			stack.push(i);
    		} else if (A[i] == A[stack.peek()]){
    			stack.pop();
    			stack.push(i);
    		} else {
    			while (!stack.isEmpty() && A[i] >= A[stack.peek()]){
    				int bottom = A[stack.pop()];
    				int left = 0;
    				int leftVal = bottom;
    				if (!stack.isEmpty()) {
    				    left = stack.peek();
    				    leftVal = A[left];
    				}
    				water += (Math.min(leftVal, A[i]) - bottom) * (i - left - 1);
    			}
    			stack.push(i);
    		}
    	}
    	return water;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
