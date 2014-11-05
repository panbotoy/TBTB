package linkedin;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class WeightedLevelSum {

	/**
	 * @param args
	 */
	public int weightedLevelSum(List<Object> list){
		if (list == null) return 0;
		int sum = 0;
		int weight = 1;
		Stack<Iterator> stack = new Stack<Iterator>();
		Iterator<Object> iterator = list.iterator();
		stack.push(iterator);
		weight++;
		while(!stack.isEmpty()){
			iterator = stack.pop();
			weight--;
			while(iterator.hasNext()){
				Object obj = iterator.next();
				if (obj instanceof Integer) sum += weight * (Integer) obj;
				else if (obj instanceof List) {
					stack.push(iterator);
					weight++;
					iterator = ((List)obj).iterator();
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
