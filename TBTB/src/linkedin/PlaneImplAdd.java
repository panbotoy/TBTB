package linkedin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PlaneImplAdd implements Plane{
	HashMap<String, PriorityQueue<Point>> map = new HashMap<String, PriorityQueue<Point>>();
	
	@Override
	public void add(Point p) {
		// TODO Auto-generated method stub
		String pointId = p.x + " " + p.y;
		if (!map.containsKey(pointId)){
			PriorityQueue<Point> queue = new PriorityQueue<Point>(10, new MyComparator(p));
			for (Map.Entry<String, PriorityQueue<Point>> entry : map.entrySet()){
				entry.getValue().offer(p);
				/*******
				 * Here it seems that we need to define a point class inorder to group the actual Point with
				 * the queue together in the map as the value. Otherwise the new entered points cannot find
				 * the original 			 * 
				 * 
				 * ******/
				
			}
		}
	}

	@Override
	public Collection<Point> getClosest(Point center, int N) {
		// TODO Auto-generated method stub
		List<Point> res = new ArrayList<Point>();
		PriorityQueue<Point> queue = map.get(center.x + " " + center.y);
		for (int i = 0; i < N; i++){
			if (queue.size() > 0){
				res.add(queue.poll());
			}
		}
		for (Point p : res){
			queue.offer(p);
		}
		return res;
	}
	class MyComparator implements Comparator<Point>{
		Point center;
		public MyComparator(Point center){
			this.center = center;
		}
		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			int dist1 = (center.x - o1.x) * (center.x - o1.x) + (center.y - o1.y) * (center.y - o1.y);
			int dist2 = (center.x - o2.x) * (center.x - o2.x) + (center.y - o2.y) * (center.y - o2.y);
			if (dist2 < dist1) return 1;
			else if (dist2 > dist1) return -1;
			else return 0;
		}
		
	}
}
