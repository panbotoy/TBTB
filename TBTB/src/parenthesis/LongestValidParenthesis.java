package parenthesis;

import java.util.HashMap;
import java.util.Stack;

public class LongestValidParenthesis {

	/**
	 * @param args
	 */
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0 ) return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		int level = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (c == '('){
				level++;
			}
			else if (c == ')'){
				level--;
				if ( level < 0) {
					map.clear();
					level = 0;
					count = 0;
				} else {
					count = map.containsKey(level)? map.get(level) : 0; 
					if (map.containsKey(level+1)) {
						count += map.get(level+1);
						map.remove(level+1);
					}
					count += 2;
					map.put(level, count);
					max = Math.max(max, count);
				}
			} else {
				return max;
			}
		}
		return max;
	}
	
	/****
	 * Finally come up with a solution with stack
	 * 
	 * It's a bit unnatural because when a parenthesis starts, it pushes to stack with the current counter
	 * when it encounters ) , it will first check if it is illegal, if it is, it should clear everything
	 * else it will adds the upperlevel in the stack, 
	 * ******/
    public int longestValidParenthesesStack(String s) {
    	if (s == null || s.length() == 0) return 0;
    	int count = 0;
    	int max = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i< s.length(); i++){
    		char c = s.charAt(i);
    		if ( c == '('){
    			stack.push(count);
    			count = 0;
    		} else {
    		    if (stack.isEmpty()) count = 0;
    		    else {
    			    count += stack.pop();
    			    count += 2;
    			    max = Math.max(max, count);
    		    }
    		}
    	}
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
