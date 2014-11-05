package string;

public class ATOI {
	/**
	 * @param args
	 * 
	 * 1. int problems always remember 1. +/-, 2. overflow. String problems always remember " "
	 * 
	 * things which I did not consider well:
	 * 
	 * 1. when return, always check positive or negative, this can be prevented by using test cases
	 * 2. to prevent overflow, we can use a long to convert int. However, always pay attention when we convert back to int from a long.
	 * Need to cast, and also make sure the cast does not lose any information
	 * 
	 * 3. i used to use if nextval < val to judge if it overflows. However, when it times 10. it's also possible that it converts back to 
	 * a positive number
	 */
    public int atoi(String str) {
        if (str == null ) return 0;
        boolean startConvert = false;
        boolean positive = true;
        int val = 0;
        for (int i = 0;i < str.length(); i++){
        	if (!startConvert){
	        	if ( str.charAt(i) == ' ') continue;
	        	else if (str.charAt(i) == '+') {
	        		startConvert = true; 
	        	} else if (str.charAt(i) == '-' ){
	        		startConvert = true;
	        		positive = false;
	        	} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	        		startConvert = true;
	        		val = val * 10 + (str.charAt(i) - '0');
	        	} else {
	        		return 0;
	        	}
	        } else{
	        	if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	        		long nextval = ((long)val) * 10 + (str.charAt(i) - '0');
	        		if (nextval > Integer.MAX_VALUE) return positive? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        		else val  = (int)nextval;  
	        	} else {
	        		return positive ? val : -val;
	        	}
	        }
        }
        return positive ? val : -val;   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
