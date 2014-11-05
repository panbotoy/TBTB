package parenthesis;

import java.util.Stack;

public class ValidParenthesis {

	/**
	 * @param args
	 * 
	 * The only invalid sequence would be an unpaired parenthesis,
	 * it could be (]
	 * or no left parenthesis at all
	 * 
	 * stack questions always need to be careful about when stack is empty, push, peek, pop etc
	 */
	public boolean isValid(String s) {
		if ( s == null) return false;
		if (s.length() == 0) return true;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[' ) stack.push(c);
			else {
				if (stack.isEmpty()) return false;
				char left = stack.pop();
				if ( c == ')' && left != '(') return false;
				if ( c == ']' && left != '[') return false;
				if ( c == '}' && left != '{') return false; 
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
