package arrays;

public class findTheKthInArray {

	/**
	 * @param args
	 */
	public int findKthElem(int [] A, int [] B, int k){
		if (k > A.length + B.length ) return -1;
		int m = A.length;
		int n = B.length;
		int alo = 0;
		int ahi = m - 1;
		int blo = 0;
		int bhi = n - 1;
		while (alo < A.length && blo < B.length && k > 0){
			int i = alo + (ahi - alo)/2;
			int j = blo + (bhi - blo)/2;
			int ai = A[i];
			int ai_1 = i == 0 ? Integer.MIN_VALUE : A[i-1];
			int bj = B[j];
			int bj_1 = j == 0 ? Integer.MIN_VALUE : B[j-1];
			if (ai_1 < bj && bj < ai) return bj;
			if (bj_1 < ai && ai < bj_1) return ai;
			if (ai > bj) {
				blo += j + 1;
				k = k-j-1;
			} else {
				alo += i+1;
				k = k-i-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findTheKthInArray find = new findTheKthInArray();
		int [] A = new int []{ 1 , 2, 3, 5, 9};
		int [] B = new int [] { 4, 8};
		System.out.println(find.findKthElem(A, B, 3));
	}

}
