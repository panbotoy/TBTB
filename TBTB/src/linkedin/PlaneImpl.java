package linkedin;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PlaneImpl implements Plane{
	int size = 0;
	HashMap<Integer, HashMap<Integer, Point>> xMap = new HashMap<Integer, HashMap<Integer, Point>>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Point p) {
		// TODO Auto-generated method stub
		if (xMap.containsKey(p.x)){
			if (xMap.get(p.x).containsKey(p.y)){
				//do nothing
			} else {
				xMap.get(p.x).put(p.y, p);
				this.size++;
			}
		} else {
			HashMap<Integer, Point> yMap = new HashMap<Integer, Point>();
			yMap.put(p.y, p);
			xMap.put(p.x, yMap);
		}
	}

	@Override
	public Collection<Point> getClosest(Point center, int N) {
		// TODO Auto-generated method stub
		PriorityQueue<Point> heap = new PriorityQueue<Point>(N, new PointComparator(center));
		for (int X : this.xMap.keySet()){
			for (int Y : this.xMap.get(X).keySet()){
				heap.add(this.xMap.get(X).get(Y));
			}
		}
		return heap;
	}
	
	class PointComparator implements Comparator<Point>{
		Point center = null;
		public PointComparator(Point center){
			this.center = center;
		} 
		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			int d1 = (o1.x - center.x) * (o1.x - center.x) + (o1.y - center.y)*(o1.y - center.y);
			int d2 = (o2.x - center.x) * (o2.x - center.x) +  (o2.y - center.y) * (o2.y - center.y);
			if (d1 < d2) return 1;
			else if (d1 == d2) return 0;
			else return -1;
		}
		
	}

}
