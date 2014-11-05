package recursion;

import java.util.Arrays;
import java.util.HashMap;

public class MinCut {

	/**
	 * @param args
	 */
	private boolean isPalindrome(String s, int start, int end, int[][] isPalindromeMap) {
		if (s == null)
			return false;
		if (isPalindromeMap[start][end] != 0){
			return isPalindromeMap[start][end] == 1;
		}
		while (start <= end) {
			if (start == end) {
				isPalindromeMap[start][end] = 1;
				return true;
			} 
			else if (s.charAt(start) != s.charAt(end)){
				isPalindromeMap[start][end] = 2;
				return false;
			}
			else {
				if (start == end - 1) {
					isPalindromeMap[start][end] = 1;
					return true;
				} 
				else {
					boolean isPalindrome = this.isPalindrome(s, start + 1, end - 1, isPalindromeMap);
					isPalindromeMap[start][end] = isPalindrome ? 1 : 2;
					return isPalindrome;
				}
			}
		}
		isPalindromeMap[start][end] = 1;
		return true;
	}
	
    public int minCut(String s) {
		if (s == null)
			return 0;
		int [] map = new int [s.length()];
		Arrays.fill(map, -1);
		int [][] isPalindromeMap = new int[s.length()][s.length()];
		this.minCutHelper(s, map, isPalindromeMap, 0, s.length() - 1);
		return map[0];
    }
    
    private int minCutHelper(String s, int [] map , int[][] isPalindromeMap, int start, int end){
    	int minCut = Integer.MAX_VALUE;
    	if (start > end) return 0;
    	for (int i = end; i >= start; i--){
    		boolean isLeftPalindrome = false;
    		if (isPalindromeMap[start][i] == 0){
    			isLeftPalindrome = this.isPalindrome(s, start, i, isPalindromeMap);
    		} else{
    			isLeftPalindrome = isPalindromeMap[start][i] == 1;
    		}
    		if (isLeftPalindrome){
    			if (i == end) {
    				minCut = 0;
    				break;
    			} else {
    				int rightMinCut = Integer.MAX_VALUE;
    				if(map[i + 1] != -1){
    					rightMinCut = map[i + 1];
    				} else {
    					rightMinCut = this.minCutHelper(s, map, isPalindromeMap, i + 1, end);
    				}
    				minCut = Math.min(minCut, rightMinCut + 1);
    			}
    		}
    	}
    	map[start] = minCut;
    	return minCut;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student bo = new Student();
		AddOne(bo);
		System.out.println(bo.Name);
	}
	static private void AddOne(Student i){
		i.Name = i.Name + i.Name;
		i.age = i.age + i.age;
	}
}



class Student {
	public Student (){}
	public int age = 5;
	public String Name = "bo";
}
