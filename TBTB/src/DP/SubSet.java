package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubSet {

	/**
	 * @param args
	 */
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
        ArrayList<Integer> empty = new ArrayList<Integer>();
        results.add(empty);
        for (int i = 0; i < S.length; i++){
        	for (List<Integer> result : results){
        		ArrayList<Integer> copyResult = new ArrayList<Integer>(result);
        		copyResult.add(S[i]);
        		temp.add(copyResult);
        	}
        	results.addAll(temp);
        	temp = new ArrayList<List<Integer>>();
        }
        return results;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
        ArrayList<Integer> empty = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        results.add(empty);
        for (int i = 0; i < num.length; i++){
        	for (List<Integer> result : results){
        		ArrayList<Integer> copyResult = new ArrayList<Integer>(result);
        		copyResult.add(num[i]);
        		if(!set.contains(copyResult)){
        			temp.add(copyResult);
        			set.add(copyResult);
        		}
        	}
        	results.addAll(temp);
        	temp = new ArrayList<List<Integer>>();
        }
        return results;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSet set = new SubSet();
		int [] arr = new int[1];
		arr[0] = 0;
		set.subsets(arr);
	}

}
