package solutions;

import java.util.HashMap;

public class WildCardMatching {

	/**
	 * 
	 * 1. improvement: compare p != * and s.length(); use a map to store intermediate results
	 * 2. string problems usually don't use recursion/2d array. it's very easy to stack overflow or out of memory.
	 * @param args
	 */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (p.length() == 0 && s.length()!= 0) return false;
        if (p.length() == 0 && s.length()==0) return true;
        HashMap<Integer, HashMap<Integer, Integer>> cache = new HashMap<Integer, HashMap<Integer, Integer>>();
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
        	if (p.charAt(i)!='*') count++;
        } 
        return isMatchHelper(s, 0, p, 0, cache, count);
    }
    
    private boolean isMatchHelper(String S, int s, String P, int p, HashMap<Integer, HashMap<Integer, Integer>> cache, int count){
    	if (p == P.length()) {
    		return s == S.length();
    	}
    	if (s == S.length()) {
	    	if (P.charAt(p) == '*') return isMatchHelper(S, s, P, p+1, cache, count);
	    	else {
	    		return false;
	    	}
	    }
    	if (S.length() - s < count) return false;
    	if (this.mapGet(cache, s, p) != 0) return this.mapGet(cache, s, p) == -1? false: true;
    	if (P.charAt(p) == '?') {
   			boolean res = isMatchHelper(S, s+1, P, p+1, cache, count - 1);
			this.mapPut(cache, s, p, res? 1 : -1);
			return res;
    	}
    	else if (P.charAt(p) != '*' && P.charAt(p) !='?'){ 
    		if(P.charAt(p) == S.charAt(s)) {
	    		while (s < S.length() && p < P.length() && P.charAt(p) == S.charAt(s) ){
	    			p++;
	    			s++;
	    			count--;
	    		}
    			boolean res = isMatchHelper(S, s, P, p, cache, count);
    			this.mapPut(cache, s, p, res? 1 : -1);
    			return res;
    		}
	    	else {
	    		this.mapPut(cache, s, p, -1);
	    		return false;
	    	}
    	}
    	else {
    		if (p == P.length()-1) {
    			this.mapPut(cache, s, p, 1);
	    		return true;
	    	}
    		if (P.charAt(p+1) == '*') {
    			boolean res = isMatchHelper(S, s, P, p+1, cache, count);
    			this.mapPut(cache, s, p, res? 1 : -1);
    			return res;
    		}
    		else{
    			boolean match = false;
    			for (int i = s; i < S.length(); i++){
    				match = isMatchHelper(S, i, P, p+1, cache, count) || match;
    				if (match) {
    					return match;
    				}
    			}
    			this.mapPut(cache, s, p, match? 1 : -1);
    			return match;
    		}
    	}
    }
    

    
    private void mapPut(HashMap<Integer, HashMap<Integer, Integer>> map, int s, int p, int res){
    	if (map.containsKey(s)){
    		map.get(s).put(p, res);
    	}else {
    		HashMap<Integer, Integer> inner = new HashMap<Integer, Integer>();
    		inner.put(p, res);
    		map.put(s, inner);
    	}
    }
    
    private Integer mapGet(HashMap<Integer, HashMap<Integer, Integer>> map, int s, int p){
    	if (map.containsKey(s)){
    		if (map.get(s).containsKey(p)){
    			return map.get(s).get(p);
    		} else return 0;
    	} else{
    		return 0;
    	}
    }
    
    public boolean isMatchPass(String s, String p) {
    	if (s == null || p == null) return false;
    	int m = s.length();
    	int n = p.length();
    	int sIdx = 0;
    	int pIdx = 0;
    	int pStar = 0;
    	int sStar = 0;
    	boolean hasStar = false;
    	while(sIdx < s.length()){
    		if(pIdx == p.length()) {
    			if(hasStar){
    				sIdx = sStar+1;
    				sStar = sIdx;
    				pIdx = pStar + 1;
    			}
    			else break;
    		}
    		else if(p.charAt(pIdx) == '*'){
    			pStar = pIdx;
    			sStar = sIdx;
    			pIdx = pStar+1;
    			if (pIdx == p.length()) sIdx = s.length();
    			hasStar = true;
    		}else if (p.charAt(pIdx) == '?'){
    			pIdx++;
    			sIdx++;
    		} else{
    			if (p.charAt(pIdx) == s.charAt(sIdx)){
    				pIdx++;
    				sIdx++;
    			} else{
    				if (hasStar) {
    					sIdx = sStar + 1;
    					sStar = sIdx;
    					pIdx = pStar + 1;
    				}
    				else return false;
    			}
    		}
    	}
    	while (pIdx < p.length() && p.charAt(pIdx) == '*'){
    		pIdx++;
    	}
    	return sIdx == s.length() && pIdx == p.length(); 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildCardMatching wc = new WildCardMatching();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < 32137; i++) s.append("a");
		System.out.println(wc.isMatch(s.toString(), '*' + s.toString() + "*"));
	}

}
