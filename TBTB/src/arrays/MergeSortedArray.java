package arrays;

public class MergeSortedArray {

	/**
	 * @param args
	 * 
	 * When I see this question, I get a feeling that it requires no extra space. Because it says A has enough 
	 * space to merge A and B.
	 * If merge from front as we normally do, we have to either move elements backwards, which result in 
	 * n^2 time complexity, or we need an extra array to store the results.
	 * So think of another way
	 */
	public void merge(int A[], int m, int B[], int n) {
		if (A == null || B == null) return;
		int end = m + n - 1;
		int a = m-1;
		int b = n-1;
		for (int i = end; i >= 0; i--){
			if (b == -1 ) break;
			else if ( a == -1) A[i] = B[b--];
			else if( A[a] >= B[b]) A[i] = A[a--];
			else A[i] = B[b--];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
