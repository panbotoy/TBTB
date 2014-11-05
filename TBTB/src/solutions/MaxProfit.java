package solutions;

public class MaxProfit {
	public int maxProfit(int [] prices){
		return this.getMaxProfit(prices, 0, prices.length - 1);
	}
	
	private int getMaxProfit(int [] prices, int left, int right){
		if (left >= right) return 0;
		if ( right - left == 1) return prices[right] - prices[left] > 0? prices[right] - prices[left]:0;
		else {
			int mid = (left + right) / 2;
			int profitLeft = this.getMaxProfit(prices, left, mid);
			int profitRight = this.getMaxProfit(prices, mid + 1, right);
			int profitCombined = this.getMax(prices, mid +1 , right) - this.getMin(prices, left, mid);
			return this.getMaxOfThree(profitLeft, profitRight, profitCombined);
		}
	}
	
	private int getMax(int [] prices, int left, int right){
		int max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i ++){
			if (prices[i] > max) max = prices[i];
		}
		return max;
	}
	
	private int getMin(int [] prices, int left, int right){
		int min = Integer.MAX_VALUE;
		for (int i = left; i<= right; i++){
			if (prices[i] < min) min = prices[i];
		}
		return min;
	}
	
	private int getMaxOfThree(int a, int b, int c){
		if (a >= b && a >=c) return a;
		else if (b >= a && b >= c) return b;
		else return c;
	}
}
