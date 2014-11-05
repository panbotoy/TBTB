package linkedin;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	/**
	 * @param args
	 */
	public List<List<Integer>> combine(int n, int k) {
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		if ( n < k) return results;
		if (k == 1){
			for (int  i = n; i < 0; i--){
				ArrayList<Integer> result = new ArrayList<Integer>();
				result.add(i);
				results.add(result);
			}
			return results;
		}
		List<List<Integer>> rests1 = combine( n - 1, k - 1);
		for ( List<Integer> rest : rests1){
			rest.add(n);
		}
		results.addAll(rests1);
		results.addAll(combine( n - 1, k));
		return results;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
