package recursion;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.List;

public class Combination {
	LinkedList<List<Integer>> resultCollection = new LinkedList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
    	if (n < 1 || k > n) return this.resultCollection;
    	LinkedList<Integer> set = new LinkedList<Integer>();
    	for (int i = 1; i <= n; i ++){
    		set.add(i);
    	}
    	LinkedList<Integer> result = new LinkedList<Integer>();
        this.combineHelper(set, k, result);
        return this.resultCollection;
    }
    
    private void combineHelper(LinkedList<Integer> set, int k, LinkedList<Integer> result){
    	if (set.size() < k) return;
    	if (k == 1) {
    			for (Integer i : set){
    				LinkedList<Integer> newResult = new LinkedList<Integer>();
    				newResult.addAll(result);
    				newResult.add(i);
    				this.resultCollection.add(newResult);
    			}
    	} 
    	else {
    		int i = set.pop();
    		LinkedList<Integer> newSet1 = new LinkedList<Integer>();
    		LinkedList<Integer> newSet2 = new LinkedList<Integer>();
    		newSet1.addAll(set);
    		newSet2.addAll(set);
    		LinkedList<Integer> resultSet1 = new LinkedList<Integer>();
    		resultSet1.addAll(result);
    		LinkedList<Integer> resultSet2 = new LinkedList<Integer>();
    		resultSet2.addAll(result);
    		resultSet1.add(i);
    		this.combineHelper(newSet1, k - 1, resultSet1);
    		this.combineHelper(newSet2, k, resultSet2);
    		
    	}
    }
}
