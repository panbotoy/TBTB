package arrays;

public class ContainerWithMostWater {
	
	/**
	 * Greedy thinking.
	 * very similar to the problem to get the min distance of two sorted list (Yao jie's question)
	 * 
	 * and it is not difficult to prove. 
	 * **/
    public int maxArea(int[] height) {
     	if (height == null || height.length == 0) return 0;
     	int lo = 0;
     	int hi = height.length-1;
     	int max = 0;
     	while (lo < hi){
     		max = Math.max(max, Math.min(height[lo], height[hi]) * (hi - lo));
     		if ( height[lo] >= height[hi]) hi--;
     		else if (height[lo] < height[hi]) lo++; 
     	}
     	return max;
     }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
