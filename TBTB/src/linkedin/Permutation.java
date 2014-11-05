package linkedin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation {

	/**
	 * @param args
	 * 
	 *            if permutation II, I first sort the num[], and then check if
	 *            num[i] == num[i-1] continue;
	 */
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return results;
		if (num.length == 1) {
			ArrayList<Integer> result = new ArrayList<Integer>(num[0]);
			results.add(result);
			return results;
		}
		for (int i = 0; i < num.length; i++) {
			int[] tmp = new int[num.length - 1];
			int count = 0;
			for (int j = 0; j < num.length; j++) {
				if (j != i)
					tmp[count++] = num[j];
			}
			List<List<Integer>> rests = this.permute(tmp);
			for (List<Integer> rest : rests) {
				rest.add(num[i]);
				results.add(rest);
			}
		}
		return results;
	}

	public void permuteUnique(int[] num, int index, List<List<Integer>> res) {
		if (index == num.length) {
			ArrayList<Integer> per = new ArrayList<Integer>();
			for (int i : num)
				per.add(i);
			res.add(per);
			return;
		}
		for (int i = index; i < num.length; i++) {
			int tmp = num[index];
			num[index] = num[i];
			num[i] = tmp;
			permuteUnique(num, index + 1, res);
			num[i] = num[index];
			num[index] = tmp;

		}

	}

	public void permuteUniqueII(int[] num, int index, List<List<Integer>> res) {
		if (index == num.length) {
			ArrayList<Integer> per = new ArrayList<Integer>();
			for (int i : num)
				per.add(i);
			res.add(per);
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = index; i < num.length; i++) {
			int tmp = num[index];
			if (!set.contains(num[i])) {
				set.add(num[i]);
				num[index] = num[i];
				num[i] = tmp;
				permuteUnique(num, index + 1, res);
				num[i] = num[index];
				num[index] = tmp;
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
