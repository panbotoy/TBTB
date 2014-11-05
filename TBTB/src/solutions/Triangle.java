package solutions;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0) return 0;
    	int[] current = new int[triangle.size()];
    	int[] previous = new int [triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; i--){
        	for (int j = 0; j <= i; j++){
        		if (i == triangle.size() - 1) {
        			previous[j] = triangle.get(i).get(j);
        			current[j] = previous[j];
        		}
        		else {
        			current[j] = Math.min(previous[j], previous[j+1]) + triangle.get(i).get(j);
        		}
        	}
        	for (int k = 0; k <= i; k++) previous[k] = current[k];
        }
        return current[0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
