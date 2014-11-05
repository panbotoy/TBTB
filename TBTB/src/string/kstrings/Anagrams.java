package string.kstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	/**
	 * @param args
	 * 
	 * 1. a very small way to use hashtable to convert n^2 questions to n
	 * 2. a good practice for char set counters
	 * 3. remember: a K strings questions usually have a different solution O(n) vs. O(nlogn) etc. when we do 
	 * K lists etc.
	 */
	
    public List<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs){
        	String code = this.convert(str);
        	if (map.containsKey(code)){
        		map.get(code).add(str);
        	} else {
        		ArrayList<String> list = new ArrayList<String>();
        		list.add(str);
        		map.put(code,list);
        	}
        }
        for (Map.Entry<String, List<String>> entry: map.entrySet()){
            List<String> subres = entry.getValue();
            if (subres.size()>1) result.addAll(subres);
        }
        return result;
    }
    
    private String convert(String str){
    	if (str == null ) return null;
    	int [] arr = new int [26];
    	for (int i = 0; i < str.length(); i++){
    		char c = str.charAt(i);
    		arr[c - 'a'] ++;
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < 26; i++){
    		sb.append((char)(i + 'a')).append(arr[i]);
    	}
    	return sb.toString(); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
