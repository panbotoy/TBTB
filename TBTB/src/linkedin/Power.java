package linkedin;

public class Power {

	/**
	 * @param args
	 */
	/***
	 * Need to be careful with N = Integer.Min_Value
	 * The second solution is so good.
	 * 
	 * **/
    public double pow(double x, int n) {
    	if (x == 1 || x == 0) return x;
        if ( n == 0) return 1;
        if ( n < 0 && n > Integer.MIN_VALUE) return 1.0 * 1/this.pow(x, -1 * n);
        if ( n == Integer.MIN_VALUE) return 1.0 * 1/ this.pow(x, Integer.MAX_VALUE) / x ;
        if ( n <= 10) {
        	double result = 1;
        	for (int i = 0; i <n; i++) result *= x;
        	return result;
        } else {
        	int last = n % 10;
        	double lastPart = this.pow(x, last);
        	int first = n / 10;
        	double firstPart = this.pow(x, first);
        	double firstPartComplete = this.pow(firstPart, 10);
        	return lastPart * firstPartComplete;
        }
    }
    
    public double pow2(double x, int n){
    	if ( n == 0 ) return 1;
    	if ( n == Integer.MIN_VALUE) return 1.0 * 1 / this.pow(x, Integer.MAX_VALUE) / x;
    	if ( n < 0) return 1.0 * 1 / this.pow(x, -n);

    	double subResult = this.pow2(x, n / 2);
    	if ( n % 2 == 0) return subResult * subResult;
    	else  return subResult * subResult * x;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Power pow = new Power();
		double result = pow.pow(-1, -2147483648);
		System.out.println(result);
		System.out.println( -1 * -2147483647);
//		System.out.println(2147483648);
	}

}
