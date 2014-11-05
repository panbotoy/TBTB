package solutions;

import java.util.ArrayList;
import java.util.Stack;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;
        Stack<ArrayList<Integer>> row = new Stack<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> column = new Stack<ArrayList<Integer>>();
        int lastCanArrive = 0, canArrive = 0, step = 0;
        int M = board.length;
        int N = board[0].length;
        boolean [][] visit = new boolean[M][N];
        for (int i = 0; i < M; i++){
        	for (int j = 0; j < N; j++){
        		if (board[i][j] == word.charAt(0)) {
        			ArrayList<Integer> rowlist = new ArrayList<Integer>();
        			ArrayList<Integer> columnlist = new ArrayList<Integer>();
        			rowlist.add(i);
        			columnlist.add(j);
        			row.push(rowlist);
        			column.push(columnlist);
        		}
        	}
        }
        int idx = 0;;
        while (!row.isEmpty()){
        	int charRow = row.peek().get(row.peek().size()-1);
        	int charColumn = column.peek().get(column.peek().size()-1);
        	if (visit[charRow][charColumn]){
        		for (int i = 0; i < row.peek().size(); i++){
        			int x = row.peek().get(i);
        			int y = column.peek().get(i);
        			visit[x][y] = false;
        			idx--;
        		}
        		row.pop();
        		column.pop();
        		continue;
        	} else{
        		visit[charRow][charColumn] = true;
            	idx++;
        	}
        	if (idx == word.length()) return true;
        	ArrayList<Integer> newRow = new ArrayList<Integer>();
        	ArrayList<Integer> newColumn = new ArrayList<Integer>();
        	if (charRow - 1 >= 0 && board[charRow-1][charColumn] == word.charAt(idx) 
        		&& !visit[charRow-1][charColumn]) {
				newRow.add(charRow-1);
				newColumn.add(charColumn);
        	}
        	if (charRow + 1 < M && board[charRow+1][charColumn] == word.charAt(idx)
        		&& !visit[charRow+1][charColumn]) {
        		newRow.add(charRow+1);
        		newColumn.add(charColumn);	
        	}
        	if ( charColumn - 1 >= 0 && board[charRow][charColumn-1] == word.charAt(idx) 
        	&& !visit[charRow][charColumn-1]){
        		newRow.add(charRow);
        		newColumn.add(charColumn-1);
        	}
        	if (charColumn + 1 < N && board[charRow][charColumn+1] == word.charAt(idx)
        	&& !visit[charRow][charColumn+1]){
        		newRow.add(charRow);
        		newColumn.add(charColumn+1);
        	}
        	
        	if (newRow.size() > 1){
        		for (int i = 0; i < newRow.size(); i++) {
        			ArrayList<Integer> branchX = new ArrayList<Integer>();
        			ArrayList<Integer> branchY = new ArrayList<Integer>();
        			branchX.add(newRow.get(i));
        			branchY.add(newColumn.get(i));
        			row.push(branchX);
        			column.push(branchY);
        		}        		
        	}
        	else if (newRow.size() == 1){
        		row.peek().addAll(newRow);
        		column.peek().addAll(newColumn);
        	}       	
        }
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{
				 {'F','Y','C','E', 'N', 'R', 'D'},
				 {'K','L','N','F', 'I', 'N', 'U'},
				 {'A','A','A','R', 'A', 'H', 'R'},
				 {'N','D','K','L','P','N','E'},
				 {'A','L','A','N','S','A','P'},
				 {'O','O','G','O','T','P','N'},
				 {'H','P','O','L','A','N','O'},};
		WordSearch search = new WordSearch();
		System.out.println(search.exist(board, "POLAND"));
	}

}
