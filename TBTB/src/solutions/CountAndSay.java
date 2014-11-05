package solutions;

public class CountAndSay {

	/**
	 * @param args
	 */
    public String countAndSay(int n) {
    	if (n < 1 ) return null;
    	String in = "1";
    	StringBuilder result = new StringBuilder(in);
    	for (int i = 1; i < n; i++){
    		int len = in.length();
    		result = new StringBuilder();
    		int counter = 0;
    		for (int j = 0; j < len; j++){
    			if (j == 0 || in.charAt(j) == in.charAt(j-1)){
    				counter++;
    			} else if (in.charAt(j) != in.charAt(j-1)){
    				result.append(counter).append(in.charAt(j-1));
    				counter = 1;
    			}
    		}
    		result.append(counter).append(in.charAt(in.length()-1));
    		in = result.toString();
    	}
    	return result.toString();    
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
