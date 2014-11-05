package linkedin;

public class SquareRoot {

	/**
	 * 
	 * Be careful with :
	 * 1. Binary Search lo < hi - 1; leaves one space for mid. output the smaller of lo and hi always.
	 * 2. mid * mid may result in integer overflow. need to either cast it to long/double, or need to do mid < x / mid;
	 * @param args
	 */
    public int sqrt(int x) {
        if (x < 0) return -1;
        if (x <= 1) return x;
        int lo = 0;
        int hi = x;
        while (lo < hi - 1){
        	int mid = (lo + hi) / 2;
        	long sqr = (long)mid * (long)mid;
        	if (sqr > x){
        		hi = mid;
        	} else if( sqr < x){
        		lo = mid;
        	} else {
        		return mid;
        	}
        }
        return lo;
    }
    
    public double sqrtDouble(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        double lo = 0;
        double hi = x;
        double eps = 0.01;
        while (lo < hi - eps){
        	double mid = (lo + hi) / 2;

        	if (mid > x / mid){
        		hi = mid;
        	} else if( mid < x / mid){
        		lo = mid;
        	} else {
        		return mid;
        	}
        }
        return lo;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquareRoot sqrt = new SquareRoot();
		System.out.println(sqrt.sqrtDouble(2147395599));
	}

}
