package linkedin;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

	/**
	 * 
	 * needs to be careful:
	 * 1. map entry iteration:
	 * Map.Entry<K,V> entry: map.entrySet()
	 * entry.getKey(), entry.getValue()
	 * 
	 * 2. the old entries (older than lo, needs to be ignored (or removed, if we can), so
	 * that we won't use the out dated value
	 * 
	 * @param args
	 */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int lo = 0;
        int hi = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (hi < s.length()){
        	char charHi = s.charAt(hi);
        	if (map.containsKey(charHi) && map.get(charHi) >= lo){
        		max = Math.max(max, hi - lo);
        		lo = map.get(charHi) + 1;    		
        	}
        	map.put(charHi, hi);
        	hi++;
        }
        return Math.max(max, hi - lo);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
