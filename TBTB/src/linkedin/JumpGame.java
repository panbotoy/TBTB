package linkedin;

public class JumpGame {
	/***
	 * There is always a way to improve! Even DP.
	 * */
	public boolean canJump(int[] A) {
		if (A == null || A.length < 2) {
			return false;
		}
		boolean[] reach = new boolean[A.length];
		for (int i = A.length - 1; i >= 0; i--) {
			if (i == A.length - 1)
				reach[i] = true;
			else if (A[i] >= (A.length - 1 - i))
				reach[i] = true;
			else {
				int step = A[i];
				for (int j = 1; j <= step; j++) {
					reach[i] = reach[i] || reach[i + j];
					if (reach[i])
						break;
					else {
						j += A[i + j];   //
					}
				}
			}
		}
		return reach[0];
	}
	
    public int jump(int[] A) {
        if (A==null || A.length <= 1) return 0;
        int lastCanArrive = 0, canArrive = 0, step = 0;
        for (int i= 0; i <= canArrive && canArrive < A.length-1; i++){
            if (i > lastCanArrive){
                step++;
                lastCanArrive = canArrive;
            }
            if (canArrive < i + A[i]){
                canArrive = i + A[i];
            }
        }
        if (canArrive >= A.length - 1) return ++step;
        else return Integer.MAX_VALUE;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
