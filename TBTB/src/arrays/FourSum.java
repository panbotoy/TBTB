package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FourSum {

	/**
	 * @param args
	 * 
	 * 1. such a long coding process. I think this question is not going to be asked in an interview
	 * 2. For the Integer in a list, it might be possible that Integer A == Integer B is false even if A.equals(B);
	 * 3. Another non-trivial bug is the index problem
	 * 4. Another non-trivial bug is to check if different subresults combinations are indeed the same combinations (-1,0,1,2) always these 4, but appear in many subresult combinations
	 * 
	 */
	
    public List<List<Integer>> fourSum(int[] num, int target) {
        
        if (num == null || num.length < 4) return new ArrayList<List<Integer>>();
        Arrays.sort(num);
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> subresMap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        HashMap<Integer, Integer> intCountMap = new HashMap<Integer, Integer>();
        HashSet<String> duplicateRemover = new HashSet<String>();
        for (int i = 0; i < num.length; i++){
        	if (intCountMap.containsKey(num[i])) intCountMap.put(num[i], intCountMap.get(num[i])+1);
        	else intCountMap.put(num[i], 1);
        	if (i != 0 && num[i] == num[i-1]) continue;
        	for (int j = i + 1; j < num.length; j++){
        		if (j != i+1 && num[j] == num[j-1]) continue;
        		int subres = num[i] + num[j];
        		ArrayList<Integer> pair = new ArrayList<Integer>();
        		pair.add(num[i]); 
        		pair.add(num[j]);
        		if (subresMap.containsKey(subres)){
        			subresMap.get(subres).add(pair);
        		} else {
        			ArrayList<ArrayList<Integer>> subresList = new ArrayList<ArrayList<Integer>>();
        			subresList.add(pair);
        			subresMap.put(subres, subresList);
        		}
        	}
        }
        for (Integer key1 : subresMap.keySet()){
        	int key2 = target - key1;
        	if (subresMap.containsKey(key2) && key2 >= key1){
        		for (ArrayList<Integer> key1List : subresMap.get(key1)){
        			for (ArrayList<Integer> key2List : subresMap.get(key2)){
        				ArrayList<Integer> possibleRes = this.mergeList(key1List, key2List, intCountMap);
        				if (possibleRes != null){
        				    boolean isDuplicate = false;
        				    StringBuilder sb = new StringBuilder();
        				    for (Integer integer : possibleRes) {
        				        sb.append(integer).append(" ");
        				    }
        				    if (!duplicateRemover.contains(sb.toString())){
        				        results.add(possibleRes);
        				        duplicateRemover.add(sb.toString());
        				    }
        				}
        			}
        		}
        	}
        }
                
        return results;      
    }
    
    private ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2, HashMap<Integer, Integer> map){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int pos1 = 0;
    	int pos2 = 0;
    	int count = 0;
    	while (pos1 < list1.size() && pos2 < list2.size()){
    		if (list1.get(pos1) <= list2.get(pos2)){
    			result.add(list1.get(pos1++));
    		} else {
    			result.add(list2.get(pos2++));
    		}
    		
    	}
    	if (pos1 == list1.size()) {
    		for (int i = pos2; i < list2.size(); i++) result.add(list2.get(i));
    	}
    	else {
    		for (int i = pos1; i < list1.size(); i++) result.add(list1.get(i));
    	}
    	for (int i = 0; i < result.size(); i++){
    		if (i == 0 || !result.get(i).equals(result.get(i-1))) 
    			count = map.get(result.get(i));
    		count--;
    		if (count < 0) return null;
    	}
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum four = new FourSum();
		int [] input = new int [] {-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,-303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485};
		four.fourSum(input, 1057);
	}

}
