package recursion;

public class SudokuSolver {

	/**
	 * @param args
	 */
	public void solveSudoku(char[][] board) {
		solveHelper(board, 0);
	}
	
	private boolean solveHelper(char[][] board, int index){
		if (index == 9*9) return true;
		int row = index / 9;
		int col = index % 9;
		if (board[row][col] != '.') return solveHelper(board, index+1);
		else {
			for (char i = '1'; i<= '9'; i++){
				board[row][col] = i;
				if (isValid(board,row,col) && solveHelper(board, index+1)) return true;
			}
			board[row][col] = '.';
		}
		return false;
	}
	private boolean isValid(char[][] board, int row, int col){
		for (int i = 0; i < 9; i++) {
			if (i != col && board[row][col] == board[row][i]) return false; 
		}
		for (int i = 0; i < 9; i++) {
			if (i != row && board[row][col] == board[i][col] ) return false;
		}
		int R = row / 3;
		int C = col / 3;
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if ((i+R*3 != row || j+C*3 != col) && board[i+R*3][j+C*3] == board[row][col]) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
