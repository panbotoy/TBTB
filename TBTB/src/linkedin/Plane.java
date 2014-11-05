package linkedin;

import java.util.Collection;

public interface Plane {
	public void add(Point p); //add a point to the plane
	public Collection<Point> getClosest(Point center, int N); // get the closest N to center
		
	class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
