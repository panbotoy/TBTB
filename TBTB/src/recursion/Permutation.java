package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutation {
	ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();

//	public List<List<Integer>> permute(int[] num) {
//
//		ArrayList<Integer> current = new ArrayList<Integer>();
//		if (num == null)
//			return resultList;
//		for (int i : num)
//			current.add(i);
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		this.permuteHelper(current, result);
//		return resultList;
//	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) return res;
		//Arrays.sort(num);
		this.permuteSwapHelper(num, 0, res);
		return res; 
	}
	
	private void permuteSwapHelper(int [] num, int index, List<List<Integer>> res){
		if (index == num.length -1){
			ArrayList<Integer> subres = new ArrayList<Integer>();
			for (int i = 0; i < num.length; i++){
				subres.add(num[i]);
			}
			res.add(subres);
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = index; i < num.length; i++){
			if (set.contains(num[i])) continue;
			set.add(num[i]);
//		    if (i != index && num[i] == num[index]) continue;
			this.swap(num, index, i);
			this.permuteSwapHelper(num, index+1, res);
			this.swap(num, index, i);
		}
	}
	
	private void swap(int [] num, int i, int j){
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

//	private void permuteHelper(ArrayList<Integer> current,
//			ArrayList<Integer> result) {
//		if (current == null)
//			return;
//		if (current.size() == 1) {
//			result.add(current.get(0));
//			this.resultList.add(result);
//		} else {
//			HashSet<Integer> set = new HashSet<Integer>();
//
//			for (int i = 0; i < current.size(); i++) {
//				if (!set.contains(current.get(i))) {
//					set.add(current.get(i));
//					ArrayList<Integer> newList = new ArrayList<Integer>();
//					ArrayList<Integer> newResult = new ArrayList<Integer>();
//					for (int j = 0; j < current.size(); j++){
//						if (j != i) newList.add(current.get(j));
//					}
//					for (Integer k : result) {
//						newResult.add(k);
//					}
//					newResult.add(i);
//					this.permuteHelper(newList, newResult);
//				}
//			}
//		}
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Permutation perm = new Permutation();
		int [] in = new int []{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19};
		List<List<Integer>> res = perm.permuteUnique(in);
		System.out.println(res);
	}
}
