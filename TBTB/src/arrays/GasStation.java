package arrays;

public class GasStation {

	/**
	 * @param args
	 * 
	 * For array questions like this, needs to be very careful about different cases.
	 * 
	 * To test the code, need to think of cases cover different scenarios.
	 * 
	 * Don't think I have done this before, should be OK.
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null) return -1;
		if (gas.length == 0 || cost.length == 0) return -1;
		if (gas.length != cost.length ) return -1;
		
		int len = gas.length;
		int leftGas = 0;
		int start = 0;
		boolean canComplete = false;
		for (int i= 0; i < len*2; i++){
			if (i - start == len){
				canComplete = true;
				break;
			} 
			leftGas += gas[i%len] - cost[i%len];
			if (leftGas >= 0) {
				continue;
			}
			else {
				start = i+1;
				leftGas = 0;
			}
		}
		return canComplete?start:-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
