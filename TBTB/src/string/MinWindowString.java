package string;

import java.util.HashSet;

public class MinWindowString {

	/**
	 * @param args
	 * 
	 * 1. need to think through the algorithm
	 * 2. need to pay attention to the operation to lo and i. And also how to update those counters
	 */
	public String minWindow(String S, String T) {
		if (S == null || T == null) return null;
		if (S.length() == 0 || T.length () == 0) return "";
		int [] counter = new int[256];
		for (int i = 0; i < T.length(); i++){
			counter[T.charAt(i)]++;
		}
		int count = T.length();
		int lo = 0;
		int min = Integer.MAX_VALUE;
		String res = "";
		for (int i = 0; i < S.length(); i++){
			char c = S.charAt(i);
			if (counter[c] > 0){
				count--;
			}
			counter[c]--;
			if (count == 0){ // found a substring containing all words
				for (int j = lo; j <= i; j++){
					char clo = S.charAt(j);
					counter[clo]++;
					if (counter[clo] > 0){
						count++;
						int localMin = i - j + 1;
						if (localMin < min){
							min = localMin;
							res = S.substring(j, i + 1);
						}
						lo = j+1;                // move j to next char, and restart moving i;
						break;
					}
				}
			}
		}
		return res;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
