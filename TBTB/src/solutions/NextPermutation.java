package solutions;

import java.util.Arrays;

public class NextPermutation {

	/**
	 * @param args
	 */
    public void nextPermutation(int[] num) {
    	if (num == null || num.length < 2) return;
        for (int i=num.length-1; i >= 0; i--){
        	if (i == 0) {
        		Arrays.sort(num);
        		return;
        	}
        	if ( num[i-1] < num[i]){
        		int target = num[i-1];
        		int newHead = Integer.MAX_VALUE;
        		int newHeadIdx = 0;
        		for (int j = i; j < num.length; j++){
        			if (num[j] > num[i-1] && num[j] < newHead) {
        				newHead = num[j];
        				newHeadIdx = j;
        			}
        		}
        		int tmp = num[i-1];
        		num[i-1] = num[newHeadIdx];
        		num[newHeadIdx] = tmp;
        		Arrays.sort(num, i, num.length);       		
        		return;
        	}
        } 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
