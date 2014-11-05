package solutions;

public class AddOne {
    public int[] plusOne(int[] digits) {
    	if (digits == null || digits.length == 0) return null;
    	int carry = 1;
    	int val = 0;
    	for (int i = digits.length - 1; i >= 0; i--){
    		if (i ==0 && carry==1 && digits[i] == 9){
    			int [] result = new int [digits.length + 1];
    			for (int j = 0; j < result.length; j++){
    				result[j] = (j==0)?1:0;
    			}
    			return result;
    		}
    		digits[i] += carry;
    		carry = digits[i] / 10;
    		digits[i] = digits[i] % 10;
    	}
		return digits;
    }
}
