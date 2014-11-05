package linkedin;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	/**
	 * @param args
	 * 
	 * Two special cases:
	 * 1. when the interval is at the left of new Interval;
	 * 2. when the interval is at the right of new Interval;
	 * else there is an overlap. need to merge.
	 * 
	 * 3. remember to finally add the last interval to the result;
	 */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> res = new ArrayList<Interval>();
    	if (intervals == null || intervals.size() == 0){
    		res.add(newInterval);
    		return res;
    	}
    	int start = newInterval.start;
    	int end = newInterval.end;
    	for (Interval interval: intervals){
    		if (interval.end < start){
    			res.add(interval);
    		} else{
    			if (interval.start > end) {
    				res.add(new Interval(start, end));
    				start = interval.start;
    				end = interval.end;
    			} else {
    				start = Math.min(interval.start, start);
    				end = Math.max(interval.end, end);
    			}
    		}
    	}
    	res.add(new Interval(start, end));
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
