package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        List<Integer> currentList = null;
        for (int i = 0; i < numRows; i++){
        	pascal.add(this.generateNextList(currentList));
        	currentList = pascal.get(i);
        }
        return pascal;
    }
    private List<Integer> generateNextList(List<Integer> currentList){
        List<Integer> nextList = new ArrayList<Integer>();
        nextList.add(1);
        if (currentList == null) {
        	return nextList;
        }
     
        for(int i = 0; i < currentList.size(); i++){
        	
        	if (i == currentList.size() - 1) nextList.add(currentList.get(i));
        	else{
        		nextList.add(currentList.get(i) + currentList.get(i + 1));
        	}
        }
        return nextList;
    }
    
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> current = new ArrayList<Integer>();
        ArrayList<Integer> last = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++){
        	for (int j = 0; j <= i; j++){
        		if (j == 0) current.set(j, 1);
        		else if (j == i) current.set(j, 1);
        		else {
        			current.set(j, last.get(j - 1) + last.get(j));
        		}
        	}
        	last = new ArrayList<Integer>(current);
        	
        }
        return last;
    }
}
