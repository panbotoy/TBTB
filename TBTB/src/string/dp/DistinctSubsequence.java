package string.dp;

import java.util.ArrayList;
import java.util.LinkedList;

public class DistinctSubsequence {

	/**
	 * @param args
	 * 
	 * Very similar to edit Distance
	 * DP for two strings
	 */
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        int m = S.length();
        int n = T.length();
        int [][] res = new int[m+1][n+1];
        for (int j = 0; j < n+1; j++){
            for (int i = 0; i < m+1; i++){
                if (i == 0 && j==0) res[i][j] = 1;
                else if (i==0 && j!=0) res[i][j] = 0;
                else if (i!=0 && j==0) res[i][j] = 1;
                else{
                    if (S.charAt(i-1) == T.charAt(j-1))
                        res[i][j] = res[i-1][j] + res[i-1][j-1];
                    else
                        res[i][j] = res[i-1][j];
                }
            }
        }
        return res[m][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = (" a ");
		String[] out = input.split(" ");
		System.out.println(out);
		LinkedList<String> list=  new LinkedList<String>();
		list.removeLast();
		ArrayList<String> array = new ArrayList<String>();
		
	}

}
