package solutions;

public class LongestPrefix {

	/**
	 * @param args
	 */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return null;
        String longest = null;
        int max_len = 0;
        for (String string : strs){
        	if (string.length() >= max_len) {
        		max_len = string.length();
        		longest = string;
        	}
        }
        int min_len = 0;
        int mid = max_len;
        String prefix = null;
        String result = null;
        while (min_len <= max_len){
        	mid = (min_len + max_len) /2;
        	prefix = longest.substring(0, mid);
        	if (this.allStartsWith(strs, prefix)){
        		result = prefix;
        		min_len = mid + 1;
        	} else {
        		max_len = mid - 1;
        	}
        }
        return result;
    }
    
    private boolean allStartsWith(String [] strs, String prefix){
    	if (strs == null || strs.length == 0) return false;
    	boolean result = true;
    	for (String str: strs){
    		result = result && str.startsWith(prefix);
    		if (!result) break;
    	}
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strs = new String[3];
		strs[0] = "";
		strs[1] = "aab";
		strs[2] = "aaa"	;
		LongestPrefix lp = new LongestPrefix();
		System.out.println(lp.longestCommonPrefix(strs));
	}

}
