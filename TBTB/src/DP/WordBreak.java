package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/***
 * A string based DP question
 * need to make use of dict, and carefully consider the index of string and the DP array
 * ***/
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict){
    	if (s == null || s.length() == 0) return false;
    	int len = s.length();
    	boolean [] res = new boolean[len+1];
    	for (int i = 0; i < len+1; i++){
    	    if (i == 0) {
    	        res[i] = true;
    	        continue;
    	    }
    	    for (String str : dict){
    	        int wordLen = str.length();
    	        if ( i - wordLen >= 0 && res[i-wordLen] == true && dict.contains(s.substring(i-wordLen, i))){
    	            res[i] = true;
    	        }
    	    }
    	}
    	return res[len];
    }

	public boolean wordBreakDp(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return false;
		if (dict == null || dict.size() == 0)
			return false;
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		boolean[] table = new boolean[n];
		for (int i = 0; i < table.length; i++) {
			sb.append(s.charAt(i));
			for (String word : dict) {
				if (word != null && word.length() != 0) {
					int length = word.length();
					if (i - length >= 0) {
						table[i] = table[i]
								|| (table[i - length] && sb.substring(
										i - length + 1).equals(word));
					} else {
						table[i] = table[i] || sb.toString().equals(word);
					}
					if (table[i])
						break;
				}
			}
		}
		return table[n - 1];
	}

	public LinkedList<String> wordBreakII(String s, Set<String> dict) {
		LinkedList<String> result = new LinkedList<String>();
		if (s == null || s.length() == 0)
			return result;
		if (dict == null || dict.size() == 0)
			return result;
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		LinkedList<StringBuilder>[] table = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			table[i] = new LinkedList<StringBuilder>();
			sb.append(s.charAt(i));
			for (String word : dict) {
				if (word != null && word.length() != 0) {
					int length = word.length();
					if (i - length >= 0) {
						if (sb.substring(i - length + 1).equals(word)) {
							for (StringBuilder oldSb : table[i - length]) {
								StringBuilder newSb = new StringBuilder()
										.append(oldSb).append(" ").append(word);
								table[i].add(newSb);
							}
						}
					} else if (sb.toString().equals(word)) {
						table[i].add(new StringBuilder().append(word));
					}
				}
			}
		}

		for (StringBuilder resultSb : table[n - 1]) {
			result.add(resultSb.toString());
		}
		return result;
	}
	
	public LinkedList<String> wordBreakIISet(String s, Set<String> dict) {
		LinkedList<String> result = new LinkedList<String>();
		if (s == null || s.length() == 0)
			return result;
		if (dict == null || dict.size() == 0)
			return result;
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		LinkedList<Integer>[] table = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			table[i] = new LinkedList<Integer>();
			sb.append(s.charAt(i));
			if (dict.contains(sb.toString())) table[i].add(i);
			for (int j = 0; j < i; j++){
				String word = sb.substring(j+1);
				if (table[j].size() != 0 && dict.contains(word)){
					table[i].add(j);
				}
			} 
		}
		result = (LinkedList<String>) this.getResultFromList(table, n - 1, s);
		return result;
	}

	private List<String> getResultFromList(LinkedList<Integer>[] table, int index, String s){

		LinkedList<String> result = new LinkedList<String>();
		for (Integer i : table[index]){
			if (i == index) result.add(s.substring(0, i + 1));
			else {
				LinkedList<String> temp = (LinkedList<String>) getResultFromList(table, i, s);
				for (String oldString: temp){
					result.add(oldString + " " + s.substring(i + 1, index + 1));
				}
			}
		}
		return result;
	}
	
	/*****
	 * This is a very beautiful backtracking recursion approach.
	 * using a map to store the imtermediate results to avoid the exponential growth in complexity
	 * ******/
	HashMap<String, List<String>> map= new HashMap<String, List<String>>();
	public List<String> wordBreakMap(String s, Set<String> dict) {
	    List<String> list=new ArrayList<String>();
	    if(map.containsKey(s)) return map.get(s);
	    for(int i=1; i<=s.length();i++){
	        String left=s.substring(0,i);
	        String right=s.substring(i);
	        if(dict.contains(left)){
	            List<String> a=wordBreakMap(right, dict);
	            for(String b:a){
	                list.add(left+" "+b);
	            }
	            if(right.length()==0) list.add(left);
	        }

	    }
	    map.put(s, list);
	    return list;
	}
	
	
	/*******
	 * 1. the correct ways to initialize the subresults:: use the add method!
	 * 2. when get a list from a list, remember to cast it to the correct type, otherwise just 
	 * use List<StringBuilder>
	 * ******/
    public List<String> wordBreakDP(String s, Set<String> dict) {
    	if (s == null || dict == null) return new ArrayList<String>();
    	List<List<Integer>> subresults = new ArrayList<List<Integer>>();
    	int len = s.length();
    	StringBuilder orig = new StringBuilder();
    	for (int i = 0; i < len; i++){ // initialize the results
    		subresults.add(new ArrayList<Integer>());
    		orig.append(s.charAt(i));
    		if (dict.contains(orig.toString())){
    			subresults.get(i).add(i);
    		} 
    		for (int j = 1; j <= i; j++){
    			String part = orig.substring(j);
    			if ( dict.contains(part)){
    				ArrayList<Integer> subresult = (ArrayList<Integer>)subresults.get(j-1);
    				if (subresult.size()!=0){
    				    subresults.get(i).add(j-1);
    				} 
    			} 
    		}
    	}
    	List<String> result = new ArrayList<String>();
    	result = this.getResultFromIndices(subresults, len-1, s);
    	return result;
    }
    
    private List<String> getResultFromIndices(List<List<Integer>> subresults, int index, String s){
    	List<Integer> subresult = subresults.get(index);
    	List<String> result = new ArrayList<String>();
    	for (Integer i : subresult){
    		if (i == index) result.add(s.substring(0,index+1));
    		else {
    			List<String> prev = this.getResultFromIndices(subresults, i, s);
    			for (String string : prev){
    				result.add(string + " " + s.substring(i+1, index+1));
    			}
    		}
    	}
    	return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		WordBreak wb = new WordBreak();
		String s = "aaaab";
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		//String s = "aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaab");
		dict.add("aab");
//		 dict.add("aaaa");
//		 dict.add("aaaaa");
//		 dict.add("aaaaaa");
//		 dict.add("aaaaaaa");
//		 dict.add("aaaaaaaa");
//		 dict.add("aaaaaaaaa"); 
//		 dict.add("aaaaaaaaaa");
//		 dict.add("aggegbnngohbgga");
//		 dict.add("lojckbdfj");
//		 dict.add("akgnn");
//		 dict.add("jadhganf");
//		 dict.add("dkefeddjdnab");
//		 dict.add("mflabckflflja"); 
//		 dict.add("fdlmmbhij");
//		 
//		 dict.add("o");
//		 dict.add("jiaaifedaihn");
//		 dict.add("oinedhhnolc"); 
//		 dict.add("jdam");
		List<String> result = wb.wordBreakIISet(s, dict);
		System.out.println(result);
	}

}
