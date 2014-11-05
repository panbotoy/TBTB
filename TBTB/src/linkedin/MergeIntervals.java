package linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MergeIntervals {

	/**
	 * @param args
	 */
	/**
	 * Need to be careful:
	 * 1. Comparator Interface compare();
	 * 2. priority queue constructor cannot just take a comparator as parameter;
	 * 
	 * 3. as long as we sort the input list by start/end, we will be able to do it without using complicated structures like heap
	 * ***/
	
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        if (intervals.size() < 2) return intervals;
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(1000, new IntervalComparator());
        for (Interval interval : intervals){
        	heap.offer(interval);
        }
        Interval first = heap.poll();
        heap = this.mergeOneInterval(first, heap);
        
        List<Interval> result = new ArrayList<Interval>();
        for (Interval interval: heap){
        	result.add(interval);
        }
        return result;
    }
    
    private PriorityQueue<Interval> mergeOneInterval(Interval first, PriorityQueue<Interval> heap){
    	if (heap.isEmpty()) {
    		heap.offer(first);
    		return heap;
    	}
    	Interval second = heap.poll();
    	heap = this.mergeOneInterval(second, heap);
    	
    	second = heap.poll();
    	if (first.end < second.start) {
    		heap.offer(second);
    		heap.offer(first);
    	}
    	else if (first.end >= second.start && first.end < second.end){
    		Interval interval = new Interval(first.start, second.end);
    		heap.offer(interval);
    	} else { //first.end >= second.end
    		heap = this.mergeOneInterval(first, heap);
    	}
    	return heap;
    }
    
    public List<Interval> merge1(List<Interval> intervals) {
    	List<Interval> result = new ArrayList<Interval>();
    	if (intervals == null || intervals.size() == 0)  return result;
    	Collections.sort(intervals, new IntervalComparator());
    	int start = intervals.get(0).start;
    	int end = intervals.get(0).end;
    	for (int i = 0; i < intervals.size(); i++){
    		Interval interval = intervals.get(i);
    		if (interval.start > end) {
    			Interval newInterval = new Interval(start, end);
    			result.add(newInterval);
    			end = interval.end;
    			start = interval.start;
    		} else {
    			end = Math.max(end, interval.end);
    		}
    	}
    	Interval newInterval = new Interval(start, end);
    	result.add(newInterval);
    	return result;
    }
    
    public class IntervalComparator implements Comparator<Interval>{
    	@Override
    	public int compare(Interval i1, Interval i2){
    		if (i1.start < i2.start) return -1;
    		else if (i1.start == i2.start){
    			if (i1.end < i2.end) return -1;
    			else if (i1.end == i2.end) return 0;
    			else return 1;
    		} else {
    			return 1;
    		}
    	}
    }
    
    public int totalIntervalLength(List<Interval> intervals) {
    	if (intervals == null || intervals.size() == 0)  return 0;
    	Collections.sort(intervals, new IntervalComparator());
    	int length = 0;
    	int start = Integer.MIN_VALUE;
    	int end = Integer.MIN_VALUE;
    	for (int i = 0; i < intervals.size(); i++){
    		Interval interval = intervals.get(i);
    		if (interval.start > end) {
    			length += end - start;
    			end = interval.end;
    			start = interval.start;
    		} else {
    			end = Math.max(end, interval.end);
    		}
    	}
    	length += end - start;
    	return length;
    }
    
    public Interval findRange(int [] num, int target){
    	if (num == null || num.length == 0) return new Interval(-1, -1);
    	int lo = 0;
    	int hi = num.length -1;
    	int mid = 0;
    	boolean foundTarget = false;
    	while (lo <= hi){
    		mid = (lo + hi)/2;
    		if (num[mid] < target) lo = mid+1;
    		else if (num[mid] > target) hi = mid-1;
    		else {
    			foundTarget = true;
    			break;
    		}
    	}
    	if (!foundTarget) return new Interval(-1, -1);
    	int start = mid;
    	int end = mid;
    	while (start > 0 && num[start - 1] == target){
    		start--;	
    	}
    	while (end < num.length - 1 && num[end+1] == target){
    		end++;
    	}
    	return new Interval(start, end);
    }
    
    public Interval findRangeFast(int [] num, int target){
    	if (num == null || num.length == 0) return new Interval(-1, -1);
    	int lo = 0;
    	int hi = num.length -1;
    	int mid = 0;
    	int start = -1;
    	int end = -1;
    	while (lo <= hi){
    		mid = (lo + hi)/2;
    		if (num[mid] < target) lo = mid+1;
    		else if (num[mid] > target) hi = mid-1;
    		else {
    			if (mid == 0 || num[mid - 1] != target) {
    				start = mid;
    				break;
    			} 
    			else hi = mid - 1;
    		}
    	}
    	
    	lo = 0;
    	hi = num.length -1;
    	mid = 0;
    	while (lo <= hi){
    		mid = (lo + hi)/2;
    		if (num[mid] < target) lo = mid+1;
    		else if (num[mid] > target) hi = mid - 1;
    		else{
    			if (mid == num.length - 1 || num[mid+1] != target){
    				end = mid;
    				break;
    			}
    			else lo = mid + 1;
    		}
    	}
    	return new Interval(start, end);
    }
    
        
    
    public static void main(String[] args) {
    	Interval i1 = new Interval(1,4);
    	Interval i2 = new Interval(2,4);
    	Interval i3 = new Interval (7,9);
    	List<Interval> list = new ArrayList<Interval>();
    	list.add(i1);
    	list.add(i2);
    	list.add(i3);
    	MergeIntervals merge = new MergeIntervals();
    	int [] input = new int[] {0,1,1,1,2,2,3,3,4,5};
    	Interval result = merge.findRangeFast(input, 6);
    	System.out.println(result);
    }
}
