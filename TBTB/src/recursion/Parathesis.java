package recursion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Parathesis {

	/**
	 * @param args
	 * 
	 * 1. this problem is very similar to N-queens etc. 
	 * 1.1 recursion first, and then operate over the sub results
	 * 1.2 does not use much space. tail recursion
	 * 
	 * 2. n^2 complexity
	 * 
	 * 3. There is another solution which has 2^(2n) complexity with back tracking. Which checks the position for each parathesis
	 * Implement that one as well
	 */
	
    public List<String> generateParenthesisInsert(int n) {
        ArrayList<String> results = new ArrayList<String>();
        if (n < 1) return results;
        if (n == 1) {
        	results.add("()");
        	return results;
        }
        HashSet<String> set = new HashSet<String>();
        List<String> subResults = generateParenthesis(n-1);
        for(String subResult : subResults){
            int space = subResult.length() + 1;
        	String [] result = new String[space];
        	for (int i = 0; i < space; i++){
        	    String left = subResult.substring(0, i);
        	    String right = subResult.substring(i);
        	    result[i] = left + "()" + right;
        	}
        	for (String str : result){
        		if (!set.contains(str)){
        			set.add(str);
        			results.add(str);
        		} 
        	}
        }
        return results;
    }
    
    /****
     * This code is now modified as the real recursive DFS code.
     * Very similar to permutation, N-Queens, path sum2
     * ****/
    public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder();
    	if ( n <= 0) return res;
    	parenthesisHelper(n, n, sb, res);
    	return res;
    }
    
    private void parenthesisHelper(int left, int right, StringBuilder sb, List<String> res){
        if (left > right) return;
    	else if (right == 0){
    		String parenthesis = sb.toString();
    		res.add(parenthesis);
    	} else if (left == 0){
    		sb.append(")");
    		parenthesisHelper(left, right-1, sb, res);
    		sb.deleteCharAt(sb.length()-1);
    	} else if (left <= right ){
    		sb.append("(");
    		parenthesisHelper(left-1, right, sb, res);
    		sb.deleteCharAt(sb.length()-1);
    		sb.append(")");
    		parenthesisHelper(left, right-1, sb, res);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = (new Date()).getTime();
		Parathesis para = new Parathesis();
		para.generateParenthesis(15);
		long end =  (new Date()).getTime();
		System.out.println(end - start);
	}

}
