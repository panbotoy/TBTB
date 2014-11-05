package binarysearch;

public class Pow {

	/**
	 * @param args
	 * 
	 * 1. iterative pow
	 * 	needs to understand how it calculates the pow. It squares the base and half n. if n is odd, need to move current base to result first
	 * 2^7:
	 * move 2 to result
	 * then do 2^6 = 4^3
	 * 
	 * untile n = 1,
	 * move the largest part also to res.
	 */
	double pow(double x, int n) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		if (x == 0){
			if (n == 0) return 1;
			else return 0;
		}
		if (x == 1){
			return 1;
		}
		if ( x == -1) {
			return n % 2 == 1? -1 : 1;
		}
		if ( n < 0) {
			return 1.0/this.pow(x, -n);
		}
		double res = 1;
		double base = x;
		while ( n > 1){
			if (n % 2 == 1){
				res = res * base;
			}
			n = n / 2;
			base = base * base;
		}
		return res;
	}
	public double times(double x, int n) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function
		if (x == 0 || n == 0) return 0;
		if ( n < 0 ){
			n = -n;
			x = -x;
		}
		double res = 0;
		double base = x;
		while ( n > 0){
			if (n % 2 == 1) res = res + base;
			base = base + base;
			n = n / 2;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow pow = new Pow();
		System.out.println(pow.times(5, -3));
	}

}
