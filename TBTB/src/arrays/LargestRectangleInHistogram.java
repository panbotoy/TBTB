package arrays;

import java.util.Stack;

public class LargestRectangleInHistogram {

	/**
	 * @param args
	 * 
	 * 1. who can think of an algorithm like this...
	 * 2. be extra careful with stack, can even judge each time before peek and push
	 * 
	 * Need to understand:
	 * we decide the start of a rectangle based on i-1 and stack.peek() or -1.
	 * So if it is a duplicate element, we need to refresh the value in the stack.
	 *  
	 */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int curr = 0;
        int max = 0;
        for (int i = 0; i < height.length + 1; i++){ //leave i = length here, to push a pseudo elem with height -1 into stack
        	if (i==height.length) curr = 0;
        	else curr = height[i];
        	if (!stack.isEmpty() && height[stack.peek()] > curr){
        		while(!stack.isEmpty() && height[stack.peek()] > curr){
        			int hi = height[stack.pop()];
        			int end = i-1;
        			int start = stack.isEmpty()? -1 : stack.peek();
        			int area = (end-start) * hi;
        			max = Math.max(max, area);
        		}
        	}
        	if (stack.isEmpty() || height[stack.peek()] < curr){
        		stack.push(i);
        	} else {
        		stack.pop();
        		stack.push(i);
        	}
        }
        return max;
    }
    
    public int largestRectangleAreaII(int[] height) {
    	if (height == null || height.length == 0) return 0;
    	int area = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < height.length+1; i++){
    		if (i == 0) stack.push(i);
    		else if (i != height.length && height[i] > height[i-1]) stack.push(i);
    		else if (i != height.length && height[i] == height[i-1]) {
    			stack.pop();
    			stack.push(i);
    		}
    		else{
    			int newHeight = i != height.length ? height[i] : 0;
    			while (!stack.isEmpty() && height[stack.peek()] > newHeight){
    				int hIndex = stack.pop();
    				int start = stack.isEmpty()? -1 : stack.peek();
    				int end = i - 1;
    				area = Math.max(area, height[hIndex] * (end - start));
    			}
    			if (!stack.isEmpty() && height[stack.peek()] == newHeight) stack.pop();
    			stack.push(i);
    		}
    	}
    	return area;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
