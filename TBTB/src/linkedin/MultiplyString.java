package linkedin;

public class MultiplyString {

	/**
	 * @param args
	 */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2==null) return null;
        if (num1 == "" || num2 == "") return "";
        int l1 = num1.length();
        int l2 = num2.length();
        int [] result = new int [l1 + l2 - 1];
        for (int j = 0; j < l2; j++){
        	for (int i = 0; i < l1; i++){
        		result[i+j] += (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
        	}
        }
        int carry = 0;
        for (int i = result.length - 1; i >= 0; i--){
        	int tmp = (result[i] + carry) / 10;
        	result[i] = (carry + result[i]) % 10;
        	carry = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        if(carry!=0) sb.append(carry);
        for (int i = 0; i < result.length; i++){
        	if (sb.length() != 0) sb.append(result[i]);
        	else if (result[i] != 0) sb.append(result[i]);
        	else if (i == result.length -1) sb.append(result[i]);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
