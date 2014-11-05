package solutions;

import java.util.HashSet;

public class ValidSudoku {

	/**
	 * @param args
	 */
	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) return false;
        if (board[0] == null || board[0].length != 9) return false;
        
        for (int i = 0; i < 9 ; i++){
        	HashSet<Character> set = new HashSet<Character>();
        	for (int j = 0; j < 9; j++){
        		if ( board[i][j] == '.' ) continue;
        		else if (!( '0' <= board[i][j] && board[i][j] <='9')) return false;
        		else if (!set.contains(board[i][j])) set.add(board[i][j]);
        		else return false;
        	}
        }
        
        for (int j = 0; j < 9; j++){
        	HashSet<Character> set = new HashSet<Character>();
        	for (int i = 0; i < 9; i++){
        		if (board[i][j] == '.') continue;
        		else if (!('0' <= board[i][j] && board[i][j] <='9')) return false;
        		else if (set.contains(board[i][j])) return false;
        		else set.add(board[i][j]);
        	}
        }
        
        for (int i = 0; i < 3; i++){
        	for (int j = 0; j < 3; j++){
        		HashSet<Character> set = new HashSet<Character>();
        		for (int k = 0; k < 3; k++){
        			for (int l=0; l < 3; l++){
        				int row = i * 3 + k;
        				int col = j * 3 + l;
        				if (board[row][col] == '.') continue;
        				else if (!('0' <= board[row][col] && board[row][col] <= '9' )) return false;
        				else if (set.contains(board[row][col])) return false;
        				else set.add(board[row][col]);
        			}
        		}
        	}
        }
        return true;        
    }
	
    public void solveSudoku(char[][] board) {
    	this.solveSudokuHelper(board, 0, 0);
    }
    /***
    * row is the row index of the most recently added element
    * col is the col index of the most recently added element
    ****/
    private boolean solveSudokuHelper(char[][] board, int row, int col){
    	for (int i = 0; i < 9; i++){
    		for (int j = 0; j < 9; j++){
    			// find the first empty spot
    			if (board[i][j] == '.'){
    				// find all possible values for this spot
    				HashSet<Character> possibleValues = new HashSet<Character>();
    				for (char k = '1'; k <= '9'; k++) possibleValues.add(k);
    				for (int l = 0; l < 9; l++) {
    					if ('0' <= board[i][l] && board[i][l] <= '9' && possibleValues.contains(board[i][l])) possibleValues.remove(board[i][l]);   
    				}
    				for (int l = 0; l < 9; l++){
    					if ('0' <= board[l][j] && board[l][j] <= '9' && possibleValues.contains(board[l][j])) possibleValues.remove(board[l][j]);
    				}
    				int gridrow = (i / 3) * 3;
    				int gridcol = (j / 3) * 3;
    				for (int l = gridrow; l < gridrow + 3; l++){
    					for (int m = gridcol; m < gridcol + 3; m++){
    						if ('0' <= board[l][m] && board[l][m] <= '9' && possibleValues.contains(board[l][m])) possibleValues.remove(board[l][m]);
    					} 
    				}
    				for (Character c : possibleValues){
    					board[i][j] = c;
    					boolean isCorrectValue = this.solveSudokuHelper(board, i, j);
    					if (isCorrectValue) return true;
    				}
    				board[row][col] = '.';
    				return false;
    			}
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
