package linkedin;

import java.util.ArrayList;
import java.util.List;

public class FindCommonChars {

	/**
	 * @param args
	 * 
	 * Need to be careful:
	 * 
	 * 1. Declare an arraylist of lists, instead of an array of lists;
	 * 2. Need to initialize the lists, even if we have given a capacity;
	 * 3.
	 * 
aghkafgklt
dfghako
qwemnaarkf


	 */
	public int findCommonChars(String [] strs){
		if (strs == null || strs.length == 0) return 0;
		List<List<Integer>> charList = new ArrayList<List<Integer>>(26);
		for (int i = 0; i < 26; i++) charList.add(new ArrayList<Integer>());
		for (int i = 0; i < strs.length; i++){
			for (int j = 0; j < strs[i].length(); j++){
				char c = strs[i].charAt(j);
				if (charList.get(c-'a').isEmpty() || charList.get(c-'a').get(charList.get(c-'a').size()-1) != i) 
					charList.get(c-'a').add(i);
			}
		}
		int result = 0;
		for (List<Integer> list : charList){
			if (list.size() == strs.length) result++;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindCommonChars find = new FindCommonChars();
		String [] strs = new String[]{"aaa", "aaa", "aaa" };
		System.out.println(find.findCommonChars(strs));
	}

}
