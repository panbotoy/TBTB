package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	/**
	 * @param args
	 * 
	 * 1. Remember the API Map.Entry<K,V> entry : map.entrySet()
	 * 2. if during the interview, can only come up with a solution like this is OK. but need to be extra careful about the corner cases
	 * 3. such as append to start, append to end, append to both, append to none, and duplicate elements
	 * 
	 * There is a better solution using only one map
	 * if it is possible, never use two maps. Keep the keys synchronized is very painful
	 * if you can find a solution using two maps, keep asking yourself, can I use only one Map?
	 * 
	 */
    public int longestConsecutive(int[] num) {
    	if (num == null || num.length == 0) return 0;
    	HashMap<Integer, Integer> startMap = new HashMap<Integer, Integer>();
    	HashMap<Integer, Integer> endMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < num.length; i++){
    		boolean extendStart = false;
    		boolean extendEnd = false;
    		if (startMap.containsKey(num[i]) || endMap.containsKey(num[i])) continue;
    		if (startMap.containsKey(num[i]+1)) extendStart = true;
    		if (endMap.containsKey(num[i]-1)) extendEnd = true;
    		if (!extendStart && !extendEnd){
    			startMap.put(num[i], num[i]);
    			endMap.put(num[i], num[i]);
    		} else if (extendStart && !extendEnd){
    			int oldStart = num[i] + 1;
    			int oldEnd = startMap.get(num[i]+1);
    			endMap.put(oldEnd, num[i]);
    			startMap.remove(num[i]+1);
    			startMap.put(num[i], oldEnd);
    		} else if (!extendStart && extendEnd){
    			int oldEnd = num[i] - 1;
    			int oldStart = endMap.get(num[i]-1);
    			startMap.put(oldStart, num[i]);
    			endMap.remove(oldEnd);
    			endMap.put(num[i], oldStart);
    		} else{
    			int oldStart = endMap.get(num[i]-1);
    			int oldEnd = startMap.get(num[i]+1);
    			startMap.remove(oldStart);
    			startMap.remove(num[i]+1);
    			endMap.remove(oldEnd);
    			endMap.remove(num[i]-1);
    			startMap.put(oldStart, oldEnd);
    			endMap.put(oldEnd, oldStart);
    		}
    	}
    	int max = 0;
    	for ( Map.Entry<Integer, Integer> entry:  startMap.entrySet()){
    		int start = entry.getKey();
    		int end = entry.getValue();
    		max = Math.max(max, end-start+1);
    	}
    	return max;
    }
    
    /******
     * When talking about O(n) for an array, on average, each element only has O(1) time to operate. So can think about map
     * ****/
    public int longestConsecutiveOneMap(int[] num) {
    	if (num == null || num.length == 0) return 0;
    	HashMap<Integer, Integer> endMap = new HashMap<Integer, Integer>();
    	int max = 0;
    	for (int i = 0; i < num.length; i++){
    		if (endMap.containsKey(num[i])) continue;
    		else {
    			int oldEnd = num[i] - 1; 
    			int oldStart = num[i] + 1;
    			int newEnd = num[i];
    			int newStart = num[i];
    			if (!endMap.containsKey(oldEnd) && !endMap.containsKey(oldStart)){
    				newEnd = num[i];
    				newStart = num[i];
    			} else if ( !endMap.containsKey(oldEnd) && endMap.containsKey(oldStart)){
    				newEnd = endMap.get(oldStart);
    				newStart = num[i];
    			} else if (endMap.containsKey(oldEnd) && !endMap.containsKey(oldStart)){
    				newStart = endMap.get(oldEnd);
    				newEnd = num[i];
    			} else {
    				newStart = endMap.get(oldEnd);
    				newEnd = endMap.get(oldStart);
    				endMap.put(num[i], num[i]);
    			}
 				endMap.put(newStart, newEnd);
				endMap.put(newEnd,newStart);
				max = Math.max(max, newEnd - newStart + 1);
    		}    		
    	}
    	return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
