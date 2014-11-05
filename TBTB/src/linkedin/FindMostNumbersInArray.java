package linkedin;

import java.util.ArrayList;
import java.util.List;

public class FindMostNumbersInArray {

	/**
	 * @param args
	 */
	public List<Integer> getNumber(int [] A, int k){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if ( A == null || A.length == 0) return result;
		if ( k <= 1 ) return result;
		int N = A.length;
		int [] elements = new int [k];
		int [] count = new int [k];
		for (int i = 0; i < N; i++){
			this.insert(A[i], elements, count);
		}
		for (int i = 0; i < k; i++){
			int counter = 0;
			if (count[i] != 0){
				for (int j = 0; j < N; j++){
					if (A[j] == elements[i]) counter++;
				}
				if (counter > N/k) result.add(elements[i]);
			}
		}
		return result;
	}

	private void insert(int elem, int [] elements, int [] count){
		// can find the element
		for (int i = 0; i < elements.length - 1; i++){
			if (elements[i] == elem) {
				count[i]++;
				return;
			}
		}
		// cannot find element in the first round
		for (int i = 0; i < elements.length; i++){
			// if it is the last element
			if ( i == elements.length - 1) {
				for (int j = 0; j < i; j++){
					count[i]--;
				}
			}
			else if (count[i] == 0){
				elements[i] = elem;
				count[i] = 1;
				return;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {4, 2, 2, 7};
		int k = 3;
		FindMostNumbersInArray find = new FindMostNumbersInArray();
		List<Integer> result = find.getNumber(arr1, k);
		System.out.println();
	}

}
