package solutions;

public class MaxProfitDP {
	public int maxProfit(int [] prices){
		if(prices == null || prices.length == 0) return -1;
		int valley = prices[0];
		int [] profit = new int [prices.length];
		for (int i = 0; i < prices.length; i++){
			valley = (valley < prices[i])?valley:prices[i];
			if(i!=0){
				profit[i] = (profit[i-1] > (prices[i] - valley))?profit[i-1]:(prices[i] - valley);
			}
		}
		return this.getMax(profit);
	}
	
	private int getMax(int [] prices){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i ++){
			if (prices[i] > max) max = prices[i];
		}
		return max;
	}
	
	public int maxProfit2(int [] prices){
		if (prices == null || prices.length == 0) return -1;
		int valley = prices[0];
		int peak = prices[prices.length - 1];
		int [] backProfit = new int [prices.length];
		int [] frontProfit = new int [prices.length];
		int profit = 0;
		for (int i = 0; i < prices.length; i++){
			valley  = (valley < prices[i])?valley:prices[i];
			if (i != 0) backProfit[i] = backProfit[i - 1] > (prices[i] - valley) ? backProfit[i - 1]:(prices[i] - valley);
		}
		for (int i = prices.length - 1; i >= 0; i++){
			peak = (peak > prices[i])?peak:prices[i];
			if (i != prices.length) frontProfit[i] = frontProfit[i + 1] > (peak - prices[i]) ? frontProfit[i+1]:(peak - prices[i]);
		}
		
		for (int i = 0; i < prices.length; i++){
			profit = profit > (frontProfit[i] + backProfit[i]) ? profit : (frontProfit[i] + backProfit[i]);
		}
		return profit;
	}
}
