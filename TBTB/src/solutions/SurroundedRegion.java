package solutions;

import java.util.ArrayList;

public class SurroundedRegion {
	int height = 0;
	int width = 0;
    public void solve(char[][] board) {
    	if (board == null || board.length <= 2) return;
    	int m = board.length;
    	if (board[0].length <= 2) return;
    	int n = board[0].length;
    	this.height = m;
    	this.width = n;

    	for (int i = 0; i < m; i++){
    		this.searchRegionOnCopy(board, i, 0);
    		this.searchRegionOnCopy(board, i, n - 1);
    	}
    	for (int i = 0; i < n; i++){
    		this.searchRegionOnCopy(board,  0, i);
    		this.searchRegionOnCopy(board,  m - 1, i);
    	}
    	for (int i = 0; i < m; i++){
    		for (int j = 0; j < n; j++){
    			if (board[i][j] == 'O' ) board[i][j] = 'X'; 
    		}
    	}
    	for (int i = 0; i < m; i++){
    		for (int j = 0; j < n; j++){
    			if (board[i][j] == 'A' ) board[i][j] = 'O'; 
    		}
    	}
    }
    
    private void searchRegionOnCopy(char [][] board, int i, int j){
     	ArrayList<Integer> currentI = new ArrayList<Integer>();
    	ArrayList<Integer> currentJ = new ArrayList<Integer>();
    	ArrayList<Integer> nextI = new ArrayList<Integer>();
    	ArrayList<Integer> nextJ = new ArrayList<Integer>();
    	currentI.add(i);
    	currentJ.add(j);
    	while (!currentI.isEmpty()){
    		for (int k = 0; k < currentI.size(); k++ ){
    			int m = currentI.get(k);
    			int n = currentJ.get(k);
    			if ( 0 <= m && m <= (this.height - 1) && 0 <= n && n <= (this.width - 1) && board[m][n] == 'O') {
    				board[m][n] = 'A';
    			
        			nextI.add(m - 1);
        			nextJ.add(n);
        			
        			nextI.add(m + 1);
        			nextJ.add(n);
        			
        			nextI.add(m);
        			nextJ.add(n - 1);
        			
        			nextI.add(m);
        			nextJ.add(n + 1);
    			}
    		}
    		currentI = nextI;
    		currentJ = nextJ;
    		nextI = new ArrayList<Integer>();
    		nextJ = new ArrayList<Integer>();
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] board = new char [][] {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
		SurroundedRegion region = new SurroundedRegion();
		region.solve(board);
		
	}

}
