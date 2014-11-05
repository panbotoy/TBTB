package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public int numberOfChanges(String str){
        if (str == null || str.length() % 2 == 1) return -1;
        int [] counters = new int [256];
        int lo = 0;
        int hi = str.length()-1;
        while (lo < hi){
            counters[str.charAt(lo)]++;
            counters[str.charAt(hi)]--;
            lo++;
            hi--;
        }
        int res = 0;
        for (int i = 0; i < 256; i++){
            if (counters[i] > 0) res += counters[i];
        }
        return res;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution sol = new Solution();
        try{
            String line = br.readLine();
            line = br.readLine();
            while (line!=null) {
                System.out.println(sol.numberOfChanges(line));
                line = br.readLine();
            }
        }catch(IOException e){
            
        }
    }
    
}