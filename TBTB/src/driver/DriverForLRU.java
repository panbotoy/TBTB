package driver;

import java.util.ArrayList;

import solutions.LRUCache;
import solutions.NumTree;

public class DriverForLRU {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		NumTree nt = new NumTree();
//		System.out.println(nt.numTrees(3));
//		int A [] = {-84,-87,-78,-16,-94,-36,-87,-93,-50,-22,-63,-28,-91,-60,-64,-27,-41,-27,-73,-37,-12,-69,-68,-30,-83,-31,-63,-24,-68,-36,-30,-3,-23,-59,-70,-68,-94,-57,-12,-43,-30,-74,-22,-20,-85,-38,-99,-25,-16,-71,-14,-27,-92,-81,-57,-74,-63,-71,-97,-82,-6,-26,-85,-28,-37,-6,-47,-30,-14,-58,-25,-96,-83,-46,-15,-68,-35,-65,-44,-51,-88,-9,-77,-79,-89,-85,-4,-52,-55,-100,-33,-61,-77,-69,-40,-13,-27,-87,-95,-40
//};
//		MaxSubArray max = new MaxSubArray();
//		int result = max.maxSubArray(A);
//		System.out.println("the max subarray sum is : " + result);
//		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
//		ArrayList<Integer> b  = new ArrayList<Integer>();
//		b.add(1);
//		b.add(2);
//		a.add(b);
//		b.remove(1);
//		System.out.println(a.size());
		LRUCache cache = new LRUCache(10);
		cache.set(10,13);
		cache.set(3,17);
		cache.set(6,11);
		cache.set(10,5);
		cache.set(9,10);
		cache.get(13);
		cache.set(2,19);
		cache.get(2);
		cache.get(3);
		cache.set(5,25);
		cache.get(8);
		cache.set(9,22);
		cache.set(5,5);
		cache.set(1,30);
		cache.get(11);
		cache.set(9,12);
		cache.get(7);
		cache.get(5);
		cache.get(8);
		cache.get(9);
		cache.set(4,30);
		cache.set(9,3);
		cache.get(9);
		cache.get(10);
		cache.get(10);
		cache.set(6,14);
		cache.set(3,1);
		cache.get(3);
		cache.set(10,11);
		cache.get(8);
		cache.set(2,14);
		cache.get(1);
		cache.get(5);
		cache.get(4);
		cache.set(11,4);
		cache.set(12,24);
		cache.set(5,18);
		cache.get(13);
		cache.set(7,23);
		cache.get(8);
		cache.get(12);
		cache.set(3,27);
		cache.set(2,12);
		cache.get(5);
		cache.set(2,9);
		cache.set(13,4);
		cache.set(8,18);
		cache.set(1,7);
		cache.get(6);
		cache.set(9,29);
		cache.set(8,21);
		cache.get(5);
		cache.set(6,30);
		cache.set(1,12);
		cache.get(10);
		cache.set(4,15);
		cache.set(7,22);
		cache.set(11,26);
		cache.set(8,17);
		cache.set(9,29);
		cache.get(5);
		cache.set(3,4);
		cache.set(11,30);
		cache.get(12);
		cache.set(4,29);
		cache.get(3);
		cache.get(9);
		cache.get(6);
		cache.set(3,4);
		cache.get(1);
		cache.get(10);
		cache.set(3,29);
		cache.set(10,28);
		cache.set(1,20);
		cache.set(11,13);
		cache.get(3);
		cache.set(3,12);
		cache.set(3,8);
		cache.set(10,9);
		cache.set(3,26);
		cache.get(8);
		cache.get(7);
		cache.get(5);
		cache.set(13,17);
		cache.set(2,27);
		cache.set(11,15);
		cache.get(12);
		cache.set(9,19);
		cache.set(2,15);
		cache.set(3,16);
		cache.get(1);
		cache.set(12,17);
		cache.set(9,1);
		cache.set(6,19);
		cache.get(4);
		cache.get(5);
		cache.get(5);
		cache.set(8,1);
		cache.set(11,7);
		cache.set(5,2);
		cache.set(9,28);
		cache.get(1);
		cache.set(2,2);
		cache.set(7,4);
		cache.set(4,22);
		cache.set(7,24);
		cache.set(9,26);
		cache.set(13,28);
		cache.set(11,26);
		}

}
