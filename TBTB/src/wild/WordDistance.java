package wild;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class WordDistance {

	/**
	 * @param args
	 */
	HashMap<String, LinkedList<Integer>> dictionary = new HashMap<String, LinkedList<Integer>>();
 	public WordDistance(String [] dic){
		if (dic  == null) return;
		for (int i = 0; i < dic.length; i++){
			if( this.dictionary.containsKey(dic[i])){
				this.dictionary.get(dic[i]).add(i);
			} else {
				LinkedList<Integer> value = new LinkedList<Integer>();
				value.add(i);
				this.dictionary.put(dic[i], value);
			}
		}
	}
	
	public int getDistance(String word1, String word2){
		if (word1 == null || word2 == null) return -1;
		if ( !this.dictionary.containsKey(word1) || !this.dictionary.containsKey(word2)) return -1;
		if (word1.equals(word2)) return 0;
		LinkedList<Integer> list1 = this.dictionary.get(word1);
		LinkedList<Integer> list2 = this.dictionary.get(word2);
		Iterator<Integer> iter1 = list1.iterator();
		Iterator<Integer> iter2 = list2.iterator();
		int int1 = iter1.next();
		int int2 = iter2.next();
		int dist = Integer.MAX_VALUE;
		while (iter1.hasNext() || iter2.hasNext()){
			int currentDist = Math.abs(int1 - int2);
			dist = Math.min(dist, currentDist);
			if (!iter1.hasNext()){
				if (int1 < int2) break;
			}
			if (!iter2.hasNext()){
				if (int2 < int1) break;
			}		
			if (int1 > int2) int2 = iter2.next();
			else int1 = iter1.next();
		}
		int currentDist = Math.abs(int1 - int2);
		dist = Math.min(dist, currentDist);
		return dist;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] dic = new String[]{"a" , "c", "b", "e","f",  "a"};
		WordDistance dis = new WordDistance(dic);
		int dist = dis.getDistance("c", "a");
		System.out.println(dist);
	}

}
