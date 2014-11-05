package solutions;

import java.util.HashMap;

public class RomanInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanLettersMap = new HashMap<Character, Integer>();
        romanLettersMap.put('I', 1);
        romanLettersMap.put('V', 5);
        romanLettersMap.put('X', 10);
        romanLettersMap.put('L', 50);
        romanLettersMap.put('C', 100);
        romanLettersMap.put('D', 500);
        romanLettersMap.put('M', 1000);
        
        int result = 0;
        int lastValue = 9999;
        for (int i = 0; i < s.length(); i++){
        	char currentChar = s.charAt(i);
        	if (!romanLettersMap.containsKey(currentChar)){
        		return -1;
        	}
        	int currentValue = romanLettersMap.get(currentChar);
        	result += currentValue;
        	if (currentValue > lastValue){
        		result = result - 2 * lastValue;
        	}
        	lastValue = currentValue;
        }
        return result;
    }
}
