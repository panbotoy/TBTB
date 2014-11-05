package string;

import java.util.HashMap;

public class IntToRoman {

	/**
	 * @param args
	 * 
	 * 1. need to be careful with corner cases
	 * 2. when use pow, sqrt functions, need to cast the type to int. it returns double by default
	 * 3. be very careful about every java api used (stringbuilder.append())
	 * 
	 */
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1000; i >= 1; i=i/10){
            int base = i;
        	int digit = num / i;
        	num = num % base;
        	if (digit == 0) continue;
        	else if (map.containsKey(digit*base)){
        	    sb.append(map.get(digit*base));
        	} else if (map.containsKey((digit+1)*base)){
        	    sb.append(map.get(1*base)).append(map.get((digit+1)*base));
        	} else {
        	    if (digit > 5) {
        	        digit = digit-5;
        	        sb.append(map.get(5*base));
        	    }
        	    for (int j = 0; j < digit; j++){
        	        sb.append(map.get(1*base));
        	    }
        	}
        }
        return sb.toString();
    }
    
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = 0;
        int lastVal = Integer.MAX_VALUE;
        int val = 0;
        if (s == null | s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
        	val = map.get(c);
        	if (val > lastVal){
        		val = val - 2 * lastVal;
        	}
        	res += val;
        	lastVal = val;
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntToRoman ro = new IntToRoman();
		ro.intToRoman(3);
	}

}
