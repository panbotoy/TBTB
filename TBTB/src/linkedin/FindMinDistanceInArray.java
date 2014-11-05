package linkedin;

public class FindMinDistanceInArray {

	/**
	 * @param args
	 */
	public int findMinDist(int [] arr1, int [] arr2){
		if (arr1 == null || arr2 == null) return 0;
		int runner1 = 0;
		int runner2 = 0;
		int dist = Integer.MAX_VALUE;
		while (runner1 < arr1.length && runner2 < arr2.length){
			dist = Math.min(dist, Math.abs(arr1[runner1] - arr2[runner2]));
			if (arr1[runner1] < arr2[runner2]) runner1++;
			else runner2++; 
		}
		return dist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinDistanceInArray find = new FindMinDistanceInArray();
		int [] arr1 = new int [] { 0,3,11,19,20};
		int [] arr2 = new int [] { -5};
		System.out.println(find.findMinDist(arr1, arr2));
	}

}
