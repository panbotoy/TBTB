package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	/**
	 * @param args
	 */
	
	/**
	 * *
	 * recursion with backtracking
	 */
    public List<String[]> solveNQueens(int n) {
    	ArrayList<String [] > output = new ArrayList<String [] >();
        if ( n <= 0) return output;
        Integer [] queens = new Integer[n];
        ArrayList<Integer []> results = new ArrayList<Integer []>();
        this.NQueensHelper(queens, 0, results);
        this.convertOutput(results, output);
        return output;
    }
    
    private void NQueensHelper(Integer [] queens, int nthQueen, ArrayList<Integer[]> results){
    	if (queens == null || queens.length == 0) return;
    	int N = queens.length;
    	if (nthQueen == N) {
    		Integer[] result = new Integer [N];
    		for (int i = 0; i < N; i++) result[i] = queens[i];
    		results.add(result);
    		return;
    	}
    	for (int i = 0; i < N; i++){
    		queens[nthQueen] = i;
    		if (this.isConsistent(queens, nthQueen)) {
    			this.NQueensHelper(queens, nthQueen + 1, results);
    		}
    	}
    }
    
    private boolean isConsistent(Integer[] queens, int nthQueen){
    	for (int i = 0; i < nthQueen; i++){
    		if (queens[i] == queens[nthQueen]) return false; 
    		if (queens[i] - queens[nthQueen] == i - nthQueen) return false;
    		if (queens[i] - queens[nthQueen] == nthQueen - i) return false;
    	}
    	return true;
    }
    
    private void convertOutput(ArrayList<Integer[]> results, ArrayList<String []> outputs){
    	for (Integer [] result: results){
    		String [] output = new String[result.length];
    		for (int i = 0; i < result.length; i++){
    			int IthQueenRow = result[i];
    			StringBuilder IthRowOutput = new StringBuilder();
    			for (int j = 0; j < result.length; j++){
    				if (j != IthQueenRow) IthRowOutput.append(".");
    				else IthRowOutput.append("Q");
    			}
    			output[i] = IthRowOutput.toString();
    		}
    		outputs.add(output);
    	}
    }
    
    int count = 0;
    public int totalNQueens(int n) {
        Integer [] queens = new Integer [n];
        this.totalQueenHelper(queens, 0);
        return count;
    }
    
    private void totalQueenHelper(Integer [] queens, int nthQueen){
    	if (queens == null || queens.length == 0) return;
    	int N = queens.length;
    	if (nthQueen == N) {
    		count ++;
    		return;
    	}
    	for (int i = 0; i < N; i++){
    		queens[nthQueen] = i;
        	if (this.isConsistent(queens, nthQueen)){
        		this.totalQueenHelper(queens, nthQueen + 1);
        	}
    	}
    }
    
    
    /*******
     * This solveNQueens is a classic example of dfs recursion. Need to digest
     * *****/
    public List<String[]> solveNQueensNew(int n) {
    	List<String[]> solutions = new ArrayList<String[]> ();
    	int [] res = new int [n];
    	this.QueenHelper(res, 0, solutions);
    	return solutions;
    }

    private void QueenHelper(int[] res, int index, List<String[]> solutions){
    	if (index == res.length) {
    		String[] solution = new String[res.length];
    		for (int i = 0; i < res.length; i++){
    			StringBuilder sb = new StringBuilder();
    			for (int j = 0; j < res.length; j++){
    				if (j == res[i]) sb.append('Q');
    				else sb.append('.');
    			}
    			solution[i] = sb.toString();
    		}
    		solutions.add(solution);
    		return;
    	}
    	for (int i = 0; i < res.length; i++){
    		res[index] = i;
    		if (isValid(res, index)){
    			this.QueenHelper(res, index+1, solutions);
    		}
    	}
    }
    
    /**
     * If we can do NQeens I, II is the same. We need to deal with the pass by reference to count the total number of solutions though
     * **/
    public int totalNQueensNew(int n) {
    	int [] solutions = new int [1];
    	int [] res = new int [n];
    	this.QueenHelper(res, 0, solutions);
    	return solutions[0];
    }

    private void QueenHelper(int[] res, int index, int[] solutions){
    	if (index == res.length) {
    		solutions[0]++;
    		return;
    	}
    	for (int i = 0; i < res.length; i++){
    		res[index] = i;
    		if (isValid(res, index)){
    			this.QueenHelper(res, index+1, solutions);
    		}
    	}
    }

    private boolean isValid(int [] res, int index){
    	for (int i = 0; i < index; i++){
    		if (res[index] == res[i]) return false;
    		else if (res[index] - res[i] == (index-i)) return false;
    		else if (res[index] - res[i] == (i-index)) return false;
    	}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
