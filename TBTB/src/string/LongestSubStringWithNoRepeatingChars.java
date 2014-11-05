package string;

public class LongestSubStringWithNoRepeatingChars {

	/**
	 * @param args
	 * 
	 * A typical two pointer problem.
	 * 
	 * One path * two points
	 */
	public int lengthOfLongestSubstring(String s) {
		if ( s == null || s.length() == 0) return 0;
		int lo = 0;
		int [] counters = new int [256];
		int max = 0;
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			counters[c]++;
			if(counters[c] > 1){
				while (counters[c] != 1) counters[s.charAt(lo++)]--;
			}
			max = Math.max(max, (i - lo + 1));
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
