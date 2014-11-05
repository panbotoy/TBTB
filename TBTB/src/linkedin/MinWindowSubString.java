package linkedin;

import java.util.HashMap;

public class MinWindowSubString {

	/**
	 * @param args
	 */
    public String minWindow(String S, String T) {
    	if (S == null || T == null || S.length() < T.length()) return ""; 
    	if (T.equals("")) return "";   	
    	HashMap<Character, Integer> charMap = new HashMap<Character,Integer>();
    	int loOut = 0;
    	int hiOut = S.length() - 1;
    	boolean foundSubString = false;
    	int lo = 0;
    	int hi = 0;
    	int count = T.length();
    	//initialize charMap with T
    	for (int i = 0; i < T.length(); i++){
    		if (charMap.containsKey(T.charAt(i))) charMap.put(T.charAt(i), charMap.get(T.charAt(i)) + 1);
    		else charMap.put(T.charAt(i), 1);
    	}
    	
    	while (hi < S.length()){
    		char charHi = S.charAt(hi);
    		if (charMap.containsKey(charHi)){
    			charMap.put(charHi, charMap.get(charHi) - 1);
    			if ( charMap.get(charHi) >= 0)
	    			count--;
    		}
			if (count == 0){
				foundSubString = true;
				while (lo <= hi){
					char charLo = S.charAt(lo);
					if (charMap.containsKey(charLo)){
						charMap.put(charLo, charMap.get(charLo) + 1);
						if (charMap.get(charLo) > 0){
							if (hiOut - loOut > hi - lo){
								hiOut = hi;
								loOut = lo;
							} 
							count++;
							lo++;
							break;
						}
					}
					lo++;
				}
			}    		
    		hi++;
    	}
    	
    	if (foundSubString) return S.substring(loOut, hiOut + 1);
    	else return "";
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
