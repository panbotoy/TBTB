package arrays;

public class BestTimeToBuyAndSellStock {
	/**
	 * @param args
	 * 
	 * 1. brute force, for every point, search for its right, find the max profit for all points
	 * 
	 * 2. improve ment if the point is higher than current one, if it is lower, possibly it will produce
	 * higher profit. because it might be possible that the highest point is on the left of the new lowest point
	 * 
	 * 3. so actually an greedy approach is enough to solve this problem.
	 */
	public int maxProfitI(int [] prices){
		if (prices == null || prices.length == 0) return 0;
		int valley = Integer.MAX_VALUE;
		int peak = Integer.MIN_VALUE;
		int profit = 0;
		int max = 0;
		for (int i = 0; i < prices.length; i++){
			if (prices[i] < valley) {
				valley = prices[i];
				peak = prices[i];
			} else if (prices[i] > peak){
				peak = prices[i];
			}
			profit = peak - valley;
			max = Math.max(profit, max);
		}
		return max;
	}
	
	/******
	 * 1. never think a question is easy, it is even worse to make mistake on an easy question
	 * 2. this time tried a new way to calculate the profit
	 * ********/
    public int maxProfitII(int [] prices){
		if (prices == null || prices.length == 0) return 0;
		int valley = prices[0];
		int peak = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++){
			if (prices[i] < peak){
				profit += peak - valley;
				valley = prices[i];
				peak = prices[i];
			} else if (prices[i] > peak){
				peak = prices[i];
			}
		}
		profit += peak - valley;
		return profit;
	}
	
    public int maxProfitIIIOld(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
		int valley = prices[0];
		int peak = prices[prices.length - 1];
		int [] backProfit = new int [prices.length];
		int [] frontProfit = new int [prices.length];
		int profit = 0;
		for (int i = 0; i < prices.length; i++){
			valley  = (valley < prices[i])?valley:prices[i];
			if (i != 0) backProfit[i] = backProfit[i - 1] > (prices[i] - valley) ? backProfit[i - 1]:(prices[i] - valley);
		}
		for (int i = prices.length - 1; i >= 0; i--){
			peak = (peak > prices[i])?peak:prices[i];
			if (i != prices.length - 1) frontProfit[i] = frontProfit[i + 1] > (peak - prices[i]) ? frontProfit[i+1]:(peak - prices[i]);
		}
		
		for (int i = 0; i < prices.length; i++){
			profit = profit > (frontProfit[i] + backProfit[i]) ? profit : (frontProfit[i] + backProfit[i]);
		}
		return profit;
    }
	
    /*****
     * 1. no question is easy
     * 2. this thinking is very special. get the forward max profit and the back max profit
     * ****/
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
    	int valley = prices[0];
    	int [] forward = new int [prices.length];
    	int [] backward = new int [prices.length];
    	for (int i = 0; i < prices.length; i++){
    		if (prices[i] < valley){
    			prices[i] = valley;
    		}	
    		forward[i] = prices[i] - valley;
    	}
    	
    	int peak = prices[prices.length-1];
    	for (int i = prices.length - 1; i >= 0; i--){
    		if (prices[i] > peak) prices[i] = peak;
    		backward[i] = peak - prices[i];
    	}
    	
		int max = 0;
		for (int i = 0; i < prices.length; i++){
			max = Math.max(max, forward[i] + backward[i]);
		}
		return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
