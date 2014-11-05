package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * @param args
	 */
	
    public List<List<Integer>> threeSum(int[] num) {
    	if (num == null || num.length < 3) return new ArrayList<List<Integer>>();
    	Arrays.sort(num);
    	ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
    	
    	for (int i = 0; i < num.length; i++){
    		if (i > 1 && num[i] == num[i] - 1) continue;
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		int sum = -num[i];
    		int lo = i + 1;
    		int hi = num.length - 1;
    		while ( lo < hi){
    			if ( num[lo] + num[hi] == sum){
    				result.add(num[i]);
    				result.add(num[lo]);
    				result.add(num[hi]);
    				results.add(result);
    				result = new ArrayList<Integer>();
    				lo++;
    				hi--;
    			} else if ( num[lo] + num[hi] < sum){
    				lo++;
    			} else {
    				hi--;
    			}
    		}
    	}
    	return results;
    }
    
    public int threeSumClosest(int[] num, int target) {
    	if (num == null || num.length < 3) return -1;
    	Arrays.sort(num);
        int minDist = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < num.length; i++){
        	int lo = i + 1;
        	int hi = num.length - 1;
        	int sum = target - num[i];
        	int midDist = Integer.MAX_VALUE;
        	int midResult = 0;
        	while ( lo < hi){
        		if (num[lo] + num[hi] == sum) return target;
        		int localDist = Math.abs(sum - num[lo] - num[hi]); 
        		if (localDist < midDist) {
        				midDist = localDist;
        				midResult = num[i] + num[lo] + num[hi]; 
        		}
        		if (num[lo] + num[hi] < sum) lo++;
        		else hi--;
        	}
        	if (minDist > midDist){
        		minDist = midDist;
        		result = midResult;
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
