package string;

public class ZigZagConversion {

	/**
	 * @param args
	 * 
	 * 1. need to be very careful with the index in the row of the sb to append. in the for loop
	 * 2. To initialize an array of class objects, cannot use iterator, but can only use for (i = 0; i < n; i++);
	 */
	
    public String convert(String s, int nRows) {
        if (s == null || s.length()==0) return s;
        if (nRows <= 1) return s;
        StringBuilder[] sbs = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) sbs[i] = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++){
        	int col = i / (nRows-1);
        	if (col % 2 == 0){ // if it goes from up to down        	
        		int row = i % (nRows-1);
        		sbs[row].append(s.charAt(i));
        	} else { // if it goes from down to up
        		int row = nRows - 1 - i%(nRows-1);
        		sbs[row].append(s.charAt(i));
        	}
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) res.append(sb);
        return res.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion zig = new ZigZagConversion();
		zig.convert("A", 2);
		
	}

}
