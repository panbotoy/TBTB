package solutions;

public class removeDuplicatesInArray {
    public int removeDuplicates(int[] A) {
        if (A == null ) return 0;
        if (A.length < 2) return A.length;
        int probe = 0;  // Probe is used to track the index for the latest unique integer. i is used to iterate through the array. 
                        // As i proceeds, if it is same as probe, then do nothing, and move i. if it is larger, then assign A[probe+1] as A[i]
        				// and move both i and probe.
        for (int i = 0; i < A.length; i++){
            if ( A[i] != A[probe]) A[++probe] = A[i];
        }
        return probe + 1;
    }
    
    public int removeDuplicatesI(int[] A) {
        if (A == null || A.length == 0) return 0;
        int probe = 0;
        int counter = 0;
        int counter_size = 2;
        for (int i = 0; i < A.length; i++){
            if (A[probe] == A[i]) {
                if (counter == 0 ){
                    counter ++;
                } else if (counter == 1){
                    counter ++;
                    A[++probe] = A[i];
                } else if (counter > 1){
                    counter ++;
                }
            }
            else {
                counter = 1;
                A[++probe] = A[i];
            }
        }
        return probe + 1;
    }
}
