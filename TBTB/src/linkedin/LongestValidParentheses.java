package linkedin;

import java.util.HashMap;

public class LongestValidParentheses {

	/**
	 * @param args
	 * 
	 * stack is current level of parentheses
	 * map is used to store <level, longest value>
	 * 
	 * 1. if it is ( , just increase count
	 * 
	 * 2. if it is ), in the map, if it contains the same level, which means we have something like ()(). we will add the previous value 
	 * and 2 to current level
	 * 
	 * 3. if it also has a upper leve, which mean we have something like (()), we will add the upper level value to current level.
	 * 
	 * 4. if there is extra ), like ()), we just clear the map and start from beginning
	 * 
	 * 5. if there is extra (, like (()(()(), we don't care, because the longest is stored in one of the two different levels
	 */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int stack = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++){
        	if (s.charAt(i)=='(') {
        		stack++;
        	}
        	else {
	        	if (stack == 0){
	        		map.clear();
	        	}
	        	else {
	        		stack--;
	        		int currentStackValue = 0;
	        		if (map.containsKey(stack)){
	        			currentStackValue = map.get(stack);
	        		}
        			int upperStackValue = 0;
        			if (map.containsKey(stack+1)){
        				upperStackValue = map.get(stack+1);
        				map.remove(stack+1);
        			}
        			map.put(stack, upperStackValue + currentStackValue + 2);
        			max = Math.max(max, upperStackValue + currentStackValue + 2);
	        	}        	
	        }
        }
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
