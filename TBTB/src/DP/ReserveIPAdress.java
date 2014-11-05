package DP;

import java.util.ArrayList;
import java.util.List;

public class ReserveIPAdress {

	/**
	 * 1. Be careful with Integer overflow
	 * 2. 010 does not count as valid integer.
	 * **/
    public List<String> restoreIpAddresses(String s) {
    	if (s == null || s.length() < 4) return new ArrayList<String>();
    	for(int i = 0; i < s.length(); i++) {
    		if (!Character.isDigit(s.charAt(i))) return new ArrayList<String>();
    	}
        ArrayList<String> [][] results = new ArrayList[s.length()][4];  
        for (int i = 0; i < s.length(); i++){
        	results[i][0] = new ArrayList<String>();
        	if (this.isValid(s, 0, i)) {
        		results[i][0].add(s.substring(0, i + 1));
        	}
        }
        for (int j = 1; j < 4; j++){
        	for (int i = 0; i < s.length(); i++){
        		boolean threedigit = false;
        		boolean twodigit = false;
        		boolean onedigit = false;
        		ArrayList<String> ipList = new ArrayList<String>();
        		results[i][j] = ipList;
        		if (i >= 3) {
        			threedigit = results[i - 3][j - 1].size()!=0 && this.isValid(s, i - 2, i);
        			if (threedigit){
        				for (String string : results[i -3][j-1]){
        					String ip = new String(string + "." + s.substring(i-2, i+1));
        					ipList.add(ip);
        				}
        			}
        		}
        		if (i >= 2) {
        			twodigit = results[i-2][j-1].size()!=0 && this.isValid(s, i - 1, i);
        			if (twodigit){
        				for (String string : results[i-2][j-1]){
        					String ip = new String(string + "." + s.substring(i-1, i+1));
        					ipList.add(ip);
        				}
        			}
        		}
        		if (i >= 1){
        			onedigit = results[i-1][j-1].size()!=0 && this.isValid(s, i, i);
        			if (onedigit){
        				for (String string : results[i-1][j-1]){
        					String ip = new String(string + "." + s.substring(i, i+1));
        					ipList.add(ip);
        				}
        			}
        		}
        	}
        }
        return results[s.length() - 1][3];
    }
    
    private boolean isValid(String s, int start, int end){
        if(end - start >2) return false;
        if (end == start) return true;
    	String subString = s.substring(start, end + 1);
    	if (subString.startsWith("0")) return false;
    	if (Integer.valueOf(subString) <= 255) return true;
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
