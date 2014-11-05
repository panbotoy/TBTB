package solutions;

public class SearchInsert {
    public int searchInsert(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        int mi = (lo + hi) / 2;
        if (target < A[0]) return 0;
        if (target > A[hi]) return A.length;
        while (lo < hi){
        	mi  = (lo + hi) /2;
        	if ( A[mi] < target) lo = mi + 1;
        	else if (A[mi] > target) hi = mi - 1;
        	else return mi;
        }
    	if (target < A[lo]) return lo;
    	else if (target > A[lo]) return lo + 1;
    	else return lo;
    }
}
