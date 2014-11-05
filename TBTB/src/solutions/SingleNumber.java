package solutions;

public class SingleNumber {
	public SingleNumber(){}
	public int singleNumber(int [] A){
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
}
