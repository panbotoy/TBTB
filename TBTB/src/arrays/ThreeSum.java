package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * @param args
	 * 
	 * Need to be very careful about the duplicates in the input
	 */
	public List<List<Integer>> threeSum(int[] num) {
		if (num == null || num.length < 3) return new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		int idx2 = 0;
		int idx3 = 0;
		for (int i = 0; i < num.length; i++){
			if (i != 0 && num[i] == num[i-1]) continue;
			idx2 = i+1;
			idx3 = num.length - 1;
			int target = -num[i];
			while (idx2 < idx3){
				if (idx2 > i + 1 && num[idx2] == num[idx2-1]){
					idx2++;
					continue;
				}
				if (num[idx2] + num[idx3] == target) {
					ArrayList<Integer> res = new ArrayList<Integer>();
					res.add(num[i]);
					res.add(num[idx2++]);
					res.add(num[idx3--]);
					results.add(res);
				} else if ( num[idx2] + num[idx3] > target){
					idx3--;
				} else {
					idx2++;
				}
			}
		}
		return results;
	}
	
	
	/**3 sum closest is actually easier because we do not need to care about duplicate
	 * 
	 * Need to keep track of min and result as we move along
	 * **/
    public int threeSumClosest(int[] num, int target) {
    	if (num == null || num.length < 3) return -1;
    	Arrays.sort(num);
        int minDist = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < num.length; i++){
        	int lo = i + 1;
        	int hi = num.length - 1;
        	int sum = target - num[i];
        	while ( lo < hi){
        		if (num[lo] + num[hi] == sum) return target;
        		int dist = Math.abs(sum - num[lo] - num[hi]); 
        		if (dist < minDist) {
        				minDist = dist;
        				result = num[i] + num[lo] + num[hi]; 
        		}
        		if (num[lo] + num[hi] < sum) lo++;
        		else hi--;
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
