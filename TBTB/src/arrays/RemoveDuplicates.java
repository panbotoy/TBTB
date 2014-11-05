package arrays;

public class RemoveDuplicates {

	/**
	 * @param args
	 * 
	 * 1. this is also a very subtle problem;
	 * similar to find the longest sequence in array, here it seems that extra space is needed, 
	 * but actually can use one of the existing space
	 */
	public int removeDuplicates(int[] A) {
		if ( A == null || A.length == 0) return -1;
		if (A.length == 1) return 1;
		int slow = 0;
		for (int i = 0; i < A.length; i++){
			if ( A[slow] != A[i]) {
				slow++;
				A[slow] = A[i];
			} else {
				continue;
			}
		}	
		return slow+1;	
	}
	
	/*****
	 * Needs to be more careful than 1.
	 * need to think of different test cases
	 * don't be lazy. test all possible test cases before submit
	 * ***/
	public int removeDuplicatesII(int[] A) {
		if (A == null) return -1;
		if (A.length <= 2) return A.length;
		int slow = 0;
		int cnt = 1;
		for (int i = 1; i < A.length; i++){
			if (A[i] == A[slow]){
				cnt++;	
				if (cnt <= 2) A[++slow] = A[i];
			} else {
				A[++slow] = A[i];
				cnt = 1;
			}
		}	
		return slow+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
