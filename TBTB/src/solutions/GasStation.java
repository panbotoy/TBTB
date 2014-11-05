package solutions;

public class GasStation {
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if (gas == null || cost == null) return -1;
    	if (gas.length != cost.length) return -1;
    	if (gas.length == 0 || cost.length == 0) return -1;
    	
    	int [] gain = new int [gas.length * 2];
    	for (int i = 0; i < gain.length; i++){
    		int index = i % gas.length;
    		gain[i] = gas[index] + cost[index];
    	}
    	
    	return this.findStart(gain);
    }
    
    private int findStart(int [] gain){
    	int n = gain.length / 2;
    	int start = 0;
    	int sum = 0;
    	for (int i = 0; i < gain.length; i++){
    		sum += gain[i];
    		if (sum >= 0){
    			if (i - start == n - 1) return start;
    			else continue;
    		} else {
    			start = i + 1;
    			if (start > n - 1) break;
    			sum = 0;
    		}
    	}
    	return -1;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
