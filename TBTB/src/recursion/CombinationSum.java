package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	/**
	 * @param args
	 */
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length==0) return new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        return this.combinationSumHelper(candidates, 0, target);
    }
    
    private List<List<Integer>> combinationSumHelper(int[] candidates, int idx, int target){
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if (idx == candidates.length) return results;
    	for (int i = idx; i < candidates.length; i++){
    		if (candidates[i] > target) continue;
    		else if (candidates[i] == target){
    			ArrayList<Integer> result = new ArrayList<Integer>();
    			result.add(candidates[i]);
    			results.add(result);
    		} else {
    			List<List<Integer>> subresults = this.combinationSumHelper(candidates, i+1, target-candidates[i]); 
    			for (List<Integer> subresult : subresults){
    				ArrayList<Integer> result = new ArrayList<Integer>();
    				result.add(candidates[i]);
    				result.addAll(subresult);
    				results.add(result);
    			}
    		} 
    	}
    	return results;
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length==0) return new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        return this.combinationSumHelper(candidates, 0, target);
    }
    
    private List<List<Integer>> combinationSumHelper2(int[] candidates, int idx, int target){
        boolean isDuplicate = false;
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if (idx == candidates.length) return results;
    	for (int i = idx; i < candidates.length; i++){
    		if (candidates[i] > target) continue;
    		else if (candidates[i] == target){
    			ArrayList<Integer> result = new ArrayList<Integer>();
    			result.add(candidates[i]);
    			results.add(result);
    			break;
    		} else {
    			List<List<Integer>> subresults = this.combinationSumHelper2(candidates, i+1, target-candidates[i]); 
    			for (List<Integer> subresult : subresults){
    				ArrayList<Integer> result = new ArrayList<Integer>();
    				result.add(candidates[i]);
    				result.addAll(subresult);
    				results.add(result);
    			}
    		}
    		while (i < candidates.length -1 && candidates[i+1] == candidates[i]) i++;
    	}
    	return results;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
