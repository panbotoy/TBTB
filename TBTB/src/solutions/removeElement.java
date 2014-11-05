package solutions;

public class removeElement {
    public int removeElement(int[] A, int elem) {
        int head = 0;
        int length = A.length;

        while (head<=(length-1)){
            if(A[head] == elem){
                this.swap(A, head, length-1);
                length = length -1;
            }
            else{
                head++;
            }
        }
        return length;
        
    }
    
    private void swap(int[]A, int first, int second){
        if (first >= A.length || second >= A.length) return;
        int temp = A[first];
        A[first] = A[second];
        A[second] = temp;
        return;
    }
}
