package solutions;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int inc = 0;
        for (int i = 0; i < n; i++){
        	inc = 1 << i;
        	for (int j = result.size()-1; j>=0; j--){
        		result.add(result.get(j)+inc);
        	}
        }
        return result;
    }
}
