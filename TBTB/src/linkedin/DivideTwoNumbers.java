package linkedin;

public class DivideTwoNumbers {

	/**
	 * @param args
	 */
	 /**
	 when encounter any integer related question, 
	 first ask yourself:
	 
	 1. positive/negative/0 condition;
	 2. need to consider overflow?
	 3. bit manipulation?
	 **/
	 
	    public int divide(int dividend, int divisor) {
	    	if (divisor == 0) return -1;
	    	boolean negative = false;
	    	long dividendl = (long)dividend;
	    	long divisorl = (long)divisor;
	    	if (dividendl < 0) {
	    		dividendl = -dividendl;
	    		negative = !negative;
	    	}
	    	if (divisor < 0){
	    		divisorl = -divisorl;
	    		negative = !negative;
	    	}
	    	
	        long base = divisorl;
	        long remainder = dividendl;
	        int result = 0;
	        
	        while (base <= dividendl){
	        	base = base << 1;
	        }
	        
	        while (base > divisorl){
	        	base = base >> 1;
	        	result = result << 1;
	        	if (base <= remainder){
	        		result += 1;
	        		remainder -= base;
	        	}
	        }
	        return negative? -result : result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-3/2);
	}

}
