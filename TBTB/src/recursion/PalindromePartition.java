package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartition {
	public List<List<String>> partition(String s) {
		if (s == null)
			return null;
		HashMap<String, ArrayList<List<String>>> map = new HashMap<String, ArrayList<List<String>>>();
		this.parlindromePartitionHelper(s, map);
		return map.get(s);
	}

	private ArrayList<List<String>> parlindromePartitionHelper(String s,
			HashMap<String, ArrayList<List<String>>> map) {
		ArrayList<List<String>> results = new ArrayList<List<String>>();
		ArrayList<List<String>> rightResults = new ArrayList<List<String>>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			String left = s.substring(0, i + 1);
			String right = s.substring(i + 1);
			if (this.isPalindrome(left)) {
				if (right.length() == 0) {
					ArrayList<String> result = new ArrayList<String>();
					result.add(left);
					results.add(result);
				} else {
					if (map.containsKey(right)) {
						rightResults = map.get(right);

					} else {
						rightResults = this.parlindromePartitionHelper(right,
								map);
					}
					for (List<String> rightResult : rightResults) {
						ArrayList<String> result = new ArrayList<String>();
						result.add(left);
						result.addAll(rightResult);
						results.add(result);
					}
				}
			}
		}
		map.put(s, results);
		return results;
	}
	private boolean isPalindrome(String s) {
		if (s == null)
			return false;
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
	private boolean isPalindromeDP(String s, HashMap<String, Boolean> isPalindromeMap) {
		if (s == null)
			return false;
		if (s.length() <= 1) return true;
		int start = 0;
 		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			else {
				String innerStr = s.substring(start + 1, end );
				if (isPalindromeMap.containsKey(innerStr)) return isPalindromeMap.get(innerStr);
			}
			start++;
			end --;
		}
		return true;
	}
	
    public int minCut(String s) {
		if (s == null)
			return 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Boolean> isPalindromeMap = new HashMap<String, Boolean>();
		this.minCutHelper(s, map, isPalindromeMap);
		return map.get(s);
    }
    
    private int minCutHelper(String s, HashMap<String, Integer> map ,HashMap<String, Boolean> isPalindromeMap){
    	int minCut = Integer.MAX_VALUE;
    	for (int i = s.length() - 1; i >=0; i--){
    		String left = s.substring(0, i + 1);
    		String right = s.substring(i + 1);
    		boolean isLeftPalindrome = false;
    		if (isPalindromeMap.containsKey(left)){
    			isLeftPalindrome = isPalindromeMap.get(left);
    		} else {
    			isLeftPalindrome = this.isPalindromeDP(left, isPalindromeMap);
    			isPalindromeMap.put(left, isLeftPalindrome);
    		}
    		if (isLeftPalindrome){
    			if (right.length() == 0) {
    				minCut = 0;
    				map.put(left, 0);
    				return 0;
    			} else {
    				int rightMinCut = Integer.MAX_VALUE;
    				if(map.containsKey(right)){
    					rightMinCut = map.get(right);
    				} else {
    					rightMinCut = this.minCutHelper(right, map, isPalindromeMap);
    				}
    				minCut = Math.min(minCut, rightMinCut + 1);
    			}
    		}
    	}
    	map.put(s, minCut);
    	return minCut;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PalindromePartition pp = new PalindromePartition();
//		String s = "adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece";
//		System.out.println(pp.minCut(s));
		
		
	}

}
