package solutions;

public class IntegerPalindrome {

	/**
	 * @param args
	 */
	
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
    	int digit = (int)Math.log10(x);
        while(x > 9){
        	if (x / (int) Math.pow(10, digit) != x%10 ) return false;
        	x = (x % (int) Math.pow(10, digit)) / 10;
        	digit = digit -2;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
