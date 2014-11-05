package linkedin;

public class ArrayMultiplication {

	/**
	 * @param args
	 */
	
	/***
	 * be careful:
	 * 1. do not define duplicate variables!!
	 * 
	 * **/
	public int[] multiplication (int[] num){
		if (num == null || num.length < 1) return null;
		int [] result = new int[num.length];
		int [] leftResult = new int[num.length];
		int tmp = 1;
		for (int i = 0; i < num.length; i++){
			if(i != 0) tmp = tmp * num[i - 1];
			leftResult[i] = tmp;
		}
		tmp = 1;
		for (int i = num.length - 1; i >=0; i--){
			if (i != num.length - 1) tmp = tmp * num[i + 1];
			result[i] = leftResult[i] * tmp;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayMultiplication multi = new ArrayMultiplication();
		int [] in = new int [] { 0,1,0,4,5};
		int [] result = multi.multiplication(in);
		System.out.println("result");
	}

}
