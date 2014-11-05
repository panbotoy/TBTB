package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

	/**
	 * @param args
	 */
	
    public List<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
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
        for (String key: map.keySet()){
        	if (map.get(key).size() > 1){
        		result.addAll(map.get(key));
        	}
        }
        return result;
    }
    private String convert(String str){
    	if (str == null || str.length() == 0) return null;
    	int [] arr = new int [26];
    	for (int i = 0; i < str.length(); i++){
    		char c = str.charAt(i);
    		arr[c - 'a'] ++;
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < 26; i++){
    		sb.append(arr[i]).append(",");
    	}
    	return sb.toString(); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
