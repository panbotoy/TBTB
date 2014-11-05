package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationOfPhoneNumbers {

	/**
	 * @param args
	 */
    public List<String> letterCombinations(String digits) {
        HashMap<Character, Character[]> map = new HashMap<Character, Character[]>();
        map.put('2', new Character [] {'a', 'b', 'c'});
        map.put('3', new Character [] {'d', 'e', 'f'});
        map.put('4', new Character [] {'g', 'h', 'i'});
        map.put('5', new Character [] {'j', 'k', 'l'});
        map.put('6', new Character [] {'m', 'n', 'o'});
        map.put('7', new Character [] {'p', 'q', 'r' , 'x'});
        map.put('8', new Character [] {'t', 'u', 'v'});
        map.put('9', new Character [] {'w', 'x', 'y' ,'z'});
        
        List<StringBuilder> subResult = this.combinationHelper(map, digits, 0);
        List<String> result = new ArrayList<String>();
        for (StringBuilder sb : subResult){
        	result.add(sb.toString());
        }
        return result;
    }
    
    private List<StringBuilder> combinationHelper(HashMap<Character, Character[]> map, String digits, int index){
    	if (index == digits.length()) {
    		ArrayList<StringBuilder> subResult =  new ArrayList<StringBuilder>();
    		subResult.add(new StringBuilder());
    		return subResult;
    	}
    	Character[] chars = map.get(digits.charAt(index));
    	List<StringBuilder> result = new ArrayList<StringBuilder>();
    	List<StringBuilder> subResult = this.combinationHelper(map, digits, index + 1);
    	for (char c : chars){
    		for (StringBuilder sb : subResult){
    			StringBuilder newSb = new StringBuilder();
    			newSb.append(c);
    			newSb.append(sb);
    			result.add(newSb);
    		}
    	}
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Character[]> map = new HashMap<Character, Character[]>();
	}

}
