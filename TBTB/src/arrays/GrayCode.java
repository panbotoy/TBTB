package arrays;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	/**
	 * @param args
	 */
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int inc = 0;
        for (int i = 0; i < n; i++){
        	inc = 1 << i;
        	for (int j = result.size()-1; j>=0; j--){
        		result.add(result.get(j)+inc);
        	}
        }
        return result;
    }
    
    
    /****
     * If n-1 is grey code, then add 1 bit from the n-1 gray code sequence is also going to be gray code.
     * It is easy to approve.
     * Also, in this way, it will be easy to consider in recursion
     * The time complexity is the same ( O(2^n))
     * *****/
	public List<Integer> grayCodeRecursion(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if (n == 0 ) {
		    res.add(0);
		}
		else {
			List<Integer> subres = this.grayCode(n-1);
			for (Integer integer: subres){
				res.add(integer);
			}
			for (int i = subres.size()-1; i >= 0; i--){
				res.add(subres.get(i) | 1 << (n-1));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
