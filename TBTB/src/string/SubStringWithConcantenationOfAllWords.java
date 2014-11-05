package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringWithConcantenationOfAllWords {

	/**
	 * @param args
	 * 
	 *            Note: never come up with a solution using n! time. It will
	 *            break even when n is less than 20.
	 * 
	 *            The BF approach:
	 * 
	 *            Start from every char, get it's next L.length * wordLen chars,
	 *            and see if every word in the substring is a dictionary word
	 *            and the count of the words match the dictionary
	 * 
	 *            The sliding window approach: for every possible path ( the
	 *            number of possible paths are the length of a word) use a
	 *            sliding window to judge possible matches
	 */
	public List<Integer> findSubstringBF(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : L) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		int wordLen = L[0].length();
		int len = L[0].length() * L.length;
		for (int i = 0; i <= S.length() - len; i++) {
			HashMap<String, Integer> tmp = new HashMap<String, Integer>(); // this
																			// hashmap
																			// is
																			// used
																			// to
																			// calculate
																			// the
																			// occurances
																			// of
																			// current
																			// words
																			// starting
																			// from
																			// i
			boolean found = true;
			for (int j = i; j < i + len; j += wordLen) { // for every word
															// starts from i
				String currentWord = S.substring(j, j + wordLen);
				if (map.containsKey(currentWord)) { // if it is a dictionary
													// word
					int count = 1; // get the number of times it has occurred
					if (tmp.containsKey(currentWord)) {
						count += tmp.get(currentWord);
					}
					if (count <= map.get(currentWord)) {
						tmp.put(currentWord, count);
						continue;
					} else { // if the word has occurred more times than the
								// dictionary, break
						found = false;
						break;
					}
				} else { // if the word did not exist in dictionary, break
					found = false;
					break;
				}
			}
			if (found)
				res.add(i);
		}
		return res;
	}

	public List<Integer> findSubstringSlidingWindow(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : L) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		int wordLen = L[0].length();
		int len = L[0].length() * L.length;
		for (int i = 0; i < wordLen; i++) {
			int count = 0;
			HashMap<String, Integer> tmp = new HashMap<String, Integer>(); // the
																			// map
																			// contains
																			// occurred
																			// words
			// if found a word, see if the word is valid, and update count and
			// tmp.
			int lo = i;
			for (int j = i; j <= S.length()- wordLen; j += wordLen) {
				String currentWord = S.substring(j, j + wordLen);
				if (map.containsKey(currentWord)){
				    int currentCount = 1;
				    if (tmp.containsKey(currentWord)) currentCount += tmp.get(currentWord);
				    tmp.put(currentWord, currentCount);
				    if (map.get(currentWord) >= currentCount){
				        count++;
				        if (count == L.length){
				            res.add(lo);
				            String removeWord = S.substring(lo, lo+wordLen);
				            count--;
				            lo = lo+wordLen;
				            tmp.put(removeWord, tmp.get(removeWord)-1);
				        }
				    } else {
				        for (int k = lo; k <= j; k+= wordLen){
				            String removeWord = S.substring(k, k+wordLen);
				            if (removeWord.equals(currentWord)){
				                lo = k+wordLen;
				                tmp.put(removeWord, tmp.get(removeWord)-1);
				                break;
				            }else{
				                tmp.put(removeWord, tmp.get(removeWord)-1);
				                count--;
				            }
				        }
				    }
				}else{
				    count = 0;
				    tmp.clear();
				    lo = j + wordLen;
				}
			}
		}
		return res;
	}
	

	public List<Integer> findSubstringPermute(String S, String[] L) {
		Set<String> possibleStrings = permute(L);
		List<Integer> res = new ArrayList<Integer>();
		int len = L[0].length() * L.length;
		for (int i = 0; (i + len) <= S.length(); i++) {
			if (possibleStrings.contains(S.substring(i, i + len))) {
				res.add(i);
			}
		}
		return res;
	}

	private Set<String> permute(String[] L) {
		Set<String> res = new HashSet<String>();
		permuteHelper(L, 0, res);
		return res;
	}

	private void permuteHelper(String[] L, int index, Set<String> res) {
		if (index == L.length - 1) {
			StringBuilder sb = new StringBuilder();
			for (String str : L) {
				sb.append(str);
			}
			res.add(sb.toString());
			return;
		}
		for (int i = index; i < L.length; i++) {
			HashSet<String> visited = new HashSet<String>();
			if (visited.contains(L[i]))
				continue;
			visited.add(L[i]);
			swap(L, index, i);
			permuteHelper(L, index + 1, res);
			swap(L, index, i);
		}
	}

	private void swap(String[] L, int i, int j) {
		String tmp = L[i];
		L[i] = L[j];
		L[j] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] L = new String[] { "dhvf", "sind", "ffsl", "yekr", "zwzq",
				"kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo",
				"gdcj", "lnle", "sefg", "vimw", "bxcb" };
		String S = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
		SubStringWithConcantenationOfAllWords sol = new SubStringWithConcantenationOfAllWords();
		//System.out.println(sol.findSubstring(S, L));
	}

}
