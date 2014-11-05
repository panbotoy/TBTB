package arrays;

public class RemoveElement {

	/**
	 * @param args
	 */
	public int removeElement(int[] A, int elem) {
		if ( A == null || A.length == 0) return 0;
		int lo = 0, hi = 0;
		int len = A.length;
		while ( lo < len){
			if (A[lo] != elem) lo++;
			else {
				hi = lo + 1;
				while (hi < len){
					if (A[hi] != elem){
						int tmp = A[lo];
						A[lo] = A[hi];
						A[hi] = tmp;
						break;
					} else hi++;
				}
				if (hi == len) return lo;
			}
		}
		return lo;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
