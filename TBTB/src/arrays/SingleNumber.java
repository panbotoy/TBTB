package arrays;

public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return -1;
        int res = 0;
        for (int i = 0; i < A.length; i++){
        	res = res ^ A[i];
        }
        return res;
    }
    
    /*****
     * These two questions are actually questions about bit manipulations
     * ****/
    public int singleNumberII(int[] A) {
        int[] bitCounter = new int[32];
		int result = 0;
		for (int i = 0; i < A.length; i++){
			for (int j = 0; j < 32; j ++){
				if (((A[i] >> j) & 1) == 1){
					bitCounter[j] ++;
				} 
			}
		}
		for (int i = 0; i < 32; i++){
			int bitValue = bitCounter[i] % 3;
			result = result | (bitValue << i);
		}
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
