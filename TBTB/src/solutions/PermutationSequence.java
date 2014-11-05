package solutions;

import java.util.LinkedList;

public class PermutationSequence {

	/**
	 * @param args
	 * 
	 * This questions also requires special thinking about how to find the sequence of permutation based on K
	 * 
	 * it is a little bit similar to find the Kth integer.
	 */
	
    public String getPermutation(int n, int k) {
        if ( n <= 1) return "" + n;
        if ( k < 1) return null;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for ( int i = 1; i <= n; i++) list.add(i);
		return getPermHelper(list, k);
    }
    
    private String getPermHelper(LinkedList<Integer> list, int k){
    	if (k == 1){
    		String res = "";
	    	for (Integer i : list) res += i;
	    	return res; 
	    }
	    int n = list.size();
	    int factorial = getFactorial(n-1);
	    int currentIdx = (k-1)/factorial;
	    int remainder = k%factorial;
	    if (remainder == 0) remainder = factorial; 
	    int current = list.get(currentIdx);
	    list.remove(currentIdx);
	    return current + this.getPermHelper(list, remainder);
    }
    
    private int getFactorial(int n){
    	if (n==0) return 1;
    	int result = 1;
    	for (int i = 1; i <= n; i++) result *= i;
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
