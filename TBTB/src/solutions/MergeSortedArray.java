package solutions;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int mIdx = m - 1;
        int nIdx = n - 1;
        for (int resultIdx = m + n - 1; resultIdx >= 0; resultIdx --){
            if (nIdx < 0) return;
            else if (mIdx < 0) A[resultIdx] = B[nIdx--];
            else {
                A[resultIdx] = (A[mIdx]>=B[nIdx]?A[mIdx--]:B[nIdx--]);
            }
        }
        return;
    }
}
