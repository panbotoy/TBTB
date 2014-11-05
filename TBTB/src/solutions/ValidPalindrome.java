package solutions;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null ) return false;
        int start = 0;
        int end = s.length() - 1;
        
        return this.isPalindromeHelper(s, start, end);
    }
    
    public boolean isPalindromeIter(String s) {
        if (s == null ) return false;
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end){
        	int firstCharIdx = end + 1;
    		int lastCharIdx = start - 1;
    		char firstChar = 0;
    		char lastChar = 0;
    		for (int i = start; i <= end; i++){
    			char c = s.charAt(i);
    			if (('0' <= c && c<='9') || ('a' <= c && c<='z')){
    				firstCharIdx = i;
    				firstChar = c;
    				break;
    			}
    			if ('A' <= c && c<='Z') {
    				firstCharIdx = i;
    				firstChar = (char) (c - 'A' + 'a');
    				break;
    			}
    		}
			for (int j = end; j >= firstCharIdx; j--){
				char c = s.charAt(j);
    			if (('0' <= c && c<='9') || ('a' <= c && c<='z')){
    				lastCharIdx = j;
    				lastChar = c;
    				break;
    			}
    			if  ('A' <= c && c<='Z'){
     				lastCharIdx = j;
     				lastChar = (char) (c - 'A' + 'a');
    				break;
    			}
			}
			if (firstCharIdx >= lastCharIdx || firstChar == lastChar){
				start = firstCharIdx + 1;
				end = lastCharIdx - 1;
			} else {
				return false;
			}
        }
        return true;
    }
    
    private boolean isPalindromeHelper(String s, int start, int end){
    	if (start >= end) return true;
    	else {
    		int firstCharIdx = end + 1;
    		int lastCharIdx = start - 1;
    		char firstChar = 0;
    		char lastChar = 0;
    		for (int i = start; i <= end; i++){
    			char c = s.charAt(i);
    			if (('0' <= c && c<='9') || ('a' <= c && c<='z')){
    				firstCharIdx = i;
    				firstChar = c;
    				break;
    			}
    			if ('A' <= c && c<='Z') {
    				firstCharIdx = i;
    				firstChar = (char) (c - 'A' + 'a');
    				break;
    			}
    		}
			for (int j = end; j >= firstCharIdx; j--){
				char c = s.charAt(j);
    			if (('0' <= c && c<='9') || ('a' <= c && c<='z')){
    				lastCharIdx = j;
    				lastChar = c;
    				break;
    			}
    			if  ('A' <= c && c<='Z'){
     				lastCharIdx = j;
     				lastChar = (char) (c - 'A' + 'a');
    				break;
    			}
			}
			if (firstCharIdx >= lastCharIdx || firstChar == lastChar){
				return isPalindromeHelper(s, firstCharIdx + 1, lastCharIdx - 1);
			} else {
				return false;
			}
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome vp = new ValidPalindrome();
		vp.isPalindromeIter("ab2a");
	}

}
