package recursion;

public class CanIWin {
	boolean canIWin(int N, int total){
		if (0 < total && total <= N) return true;
		if ( total <= 0) return false;
		return canIWin(N, total-N-1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
