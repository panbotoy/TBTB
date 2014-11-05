package solutions;

public class NumTree {

	/**
	 * @param args
	 */
	public int numTrees(int n){
        int [] result = new int [n+1];
    	if ( n < 2)
    	{
		    return 1;
	    } 
	    else {

		    result[0] = 1;
		    result[1] = 1;
		    for (int i = 2; i < (n+1); i++){
			    for ( int j = 0; j < i; j++){
  				    result[i] += result[j]* result[i-1-j];
			    }	
		    }
		    return result[n];
	    }
	}
}
