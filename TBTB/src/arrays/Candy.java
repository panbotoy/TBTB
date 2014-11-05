package arrays;

public class Candy {

	/**
	 * @param args
	 * 
	 * This problem is very similar to get the multiplication of a array except itself;
	 * When an array element's value is dependent on the elements on both sides, we can consider
	 * scan the array from left to right and from right to left.
	 * 
	 */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int [] candy = new int [ratings.length];
        for (int i = 0; i < ratings.length; i++){
        	if ( i == 0 ) candy[i] = 1;
        	else candy[i] = ratings[i] > ratings[i-1] ? candy[i-1] + 1 : 1;
        }
        int candies = 0;
        for (int i = ratings.length - 1; i >= 0; i--){
        	if ( i != ratings.length-1 && ratings[i] > ratings[i+1]) 
        			candy[i] = Math.max(candy[i], candy[i+1] + 1);
			candies += candy[i];
        }
        return candies;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
