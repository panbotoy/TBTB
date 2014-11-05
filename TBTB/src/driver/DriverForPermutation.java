package driver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import recursion.Combination;
import recursion.Permutation;

public class DriverForPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation perm = new Permutation();
		int [] input = new int[]{5,4,2,6,8};
//		ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) perm.permute(input);
//		System.out.println("finish");
		Combination com = new Combination();
		LinkedList<List<Integer>> result = (LinkedList<List<Integer>>) com.combine(5, 3);
		System.out.println("finish");
	}

}
