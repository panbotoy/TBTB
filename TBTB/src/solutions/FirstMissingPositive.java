package solutions;

public class FirstMissingPositive {

	/**
	 * @param args
	 */

	/***
	 * other thoughts: 1. sort. if no requirement for time complexity 2. if no
	 * requirements for space put all elements in an arraylist, then read from
	 * the list(1), if it is null, then return the index. 3. constant space with
	 * O(n) make use of current array A. for each element in array, if it is
	 * larger than n, discard it, clear the position. if it is between 0 and
	 * n-1, take it out and put it into A[A[i] - 1]. if A[A[i] - 1] is already
	 * occupied, we will take orig out, put new elem in, and do the same for
	 * orig.
	 * 
	 * need to think for constance space, what can we do ? if it cannot be done
	 * with several vars, can I make use of some existing spaces?
	 */

	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0)
			return 1;
		int N = A.length;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == i + 1)
				continue;
			else if (A[i] > N || A[i] < 1)
				continue;
			else {
				int curr = A[i];
				int next = A[curr - 1];
				A[curr - 1] = curr;
				while (1 <= next && next <= N && A[next - 1] != next) {
					curr = next;
					next = A[curr - 1];
					A[curr - 1] = curr;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return N + 1;
	}
	
	public int firstMissingPositiveII(int[] A) {
		if (A == null || A.length == 0)
			return 1;
		int N = A.length;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == i + 1)
				continue;
			else if (A[i] > N || A[i] < 1)
				continue;
			else {
				int curr = A[i];
				while ( curr >= 1 && curr <= N ){
					int next = A[curr-1];
					if (next == curr) break;
					A[curr-1] = A[i];
					A[i] = next;
					curr = next;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return N + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
