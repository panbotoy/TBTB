package points;

import java.util.HashMap;

public class MaxPointsOnALine {

	/**
	 * @param args
	 */
	
	/****
	 * need to be careful:
	 * 1. doube value may change if we do int / int. It may be rounded to int.0
	 * 2. The max for double is DOUBLE.MAV_VALUE. infinity is DOUBLE.POSITIVE_INFINITY/NEGATIVE_INFINITY
	 * 3. be careful with the logic to update itsself and the same point.
	 * @param points
	 * @return
	 */
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		HashMap<Double, Integer> slopePointMap;
		int N = points.length;
		int max = 0;
		for (int i = 0; i < N; i++) {
			slopePointMap = new HashMap<Double, Integer>();
			int samePointCount = 0;
			double slope = 0;
			int localMax = 0;
			for (int j = 0; j < N; j++) {
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					samePointCount++;
					continue;
				} else if (points[j].x == points[i].x) {
					slope = Double.POSITIVE_INFINITY;
					
				} else if (points[j].y == points[i].y) {
					slope = 0;
				} else {
					slope = 1.0 * (points[j].y - points[i].y)
							/ (points[j].x - points[i].x);
				}
				int currentSlopeCount = slopePointMap.containsKey(slope) ? slopePointMap
						.get(slope) + 1 : 1;
				slopePointMap.put(slope, currentSlopeCount);
				localMax = localMax > currentSlopeCount ? localMax
						: currentSlopeCount;
			}
			localMax = localMax + samePointCount;
			max = max > localMax ? max : localMax;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
