package arrays;

public class NextPermutation {

	/**
	 * @param args
	 * 
	 * This problem needs very keen observation on how to find the next permutation
	 * 
	 * swap a smaller value into the second half and get out a slightly larger value.
	 * The order in the second half should still be descending. Just sort the second half.
	 * 
	 * The sorting used in this solution is not a regular sorting. Just to reverse the second half.
	 */
	public void nextPermutation(int[] num) {
		if (num == null || num.length < 2) return;
		for (int i = num.length - 1; i >= 0; i--){
			if (i == 0){
				reverse(num, 0, num.length-1);
				break;
			}
			if ( num[i-1] < num[i]){  // look for the transition point. num[i-1] is the number
									  // which should be placed at the second half
									  // after swap num[i-1] into second half, it should be the new smallest			  
				for (int j = num.length-1; j >= i; j--){
					if ( num[j] > num[i-1]){
						swap(num, j, i-1);
						break;
					}
				}
				reverse(num, i, num.length-1);
				break;
			}
		}
	}
	private void swap(int [] num, int i, int j){
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	private void reverse(int [] num, int start, int end){
		while (start < end){
			swap(num, start, end);
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
