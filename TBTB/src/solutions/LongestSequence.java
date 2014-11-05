package solutions;

import java.util.HashMap;

public class LongestSequence {
    public int longestConsecutive(int[] num) {
    	if (num == null || num.length == 0) return 0;
    	HashMap<Integer, Integer> endLengthMap = new HashMap<Integer, Integer>();
    	int maxLength = 0;
        for (int i = 0; i < num.length; i++){
        	if (endLengthMap.containsKey( num[i] + 1) && endLengthMap.containsKey(num[i] - 1)){
        		int length2 = endLengthMap.get(num[i] + 1);
        		int length1 = endLengthMap.get(num[i] - 1);
        		endLengthMap.put(num[i] + length2, length1 + length2 + 1);
        		endLengthMap.put(num[i] - length1, length1 + length2 + 1);
        		maxLength = Math.max(maxLength, length1 + length2 + 1);
        	} else if (endLengthMap.containsKey(num[i] + 1)){
        		int length = endLengthMap.get(num[i] + 1);
        		endLengthMap.put(num[i] + length, length + 1);
        		endLengthMap.put(num[i], length + 1);
        		maxLength = Math.max(maxLength, length + 1);
        	} else if (endLengthMap.containsKey(num[i] - 1)){
        		int length = endLengthMap.get(num[i] - 1) ;
        		endLengthMap.put(num[i] - length, length + 1);
        		endLengthMap.put(num[i], length + 1);
        		maxLength = Math.max(maxLength, length + 1);
        	} else {
        		endLengthMap.put(num[i], 1);
        		maxLength = Math.max(maxLength, 1);
        	}
        }
        return maxLength;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
