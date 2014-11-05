package linkedin;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	/**
	 * @param args
	 */
	/***
	 * 1. native approach : double for loops
	 * 2. O(n) space approach: hashmap
	 * 3. O(nlog(n)) time approach, sort first, then two points.
	 * **/
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> numIndexMap = new HashMap<Integer, Integer>();
        if (numbers == null || numbers.length<2 ) return null;
        int [] result = new int [2];
        for (int i = 0; i < numbers.length; i++){
        	int toBeFound = target - numbers[i];
        	if (numIndexMap.containsKey(toBeFound)){
        		result[0] = numIndexMap.get(toBeFound);
        		result[1] = i;
        		return result;
        	} else {
        		numIndexMap.put(numbers[i], i);
        	}
        }
        return result;
    }
    
    public int[] twoSumNohash(int [] numbers, int target){
    	int [] copy = new int[numbers.length];
    	for (int i = 0; i < numbers.length; i++) copy[i] = numbers[i];
    	Arrays.sort(copy);
    	int first = 0;
    	int second = copy.length - 1;
    	
    	while (first < second){
    		if (copy[first] + copy[second] == target) {
    			first = copy[first];
    			second = copy[second];
    		} else if (copy[first] + copy[second] < target){
    			first++;
    		} else {
    			second--;
    		}
    	}
    	
    	int [] result = new int[2];
    	for (int i = 0; i < numbers.length; i++){
    		if (numbers[i] == first) result[0] = i;
    		else if (numbers[i] == second) result[1] = i;
    	}
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
