package linkedin;

import java.util.Stack;

public class ValidParentheses {

	/**
	 * @param args
	 */
    public boolean isValid(String s) {
        if (s == null || s.length()==0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) return false;
				char lastChar = stack.peek();
				if (s.charAt(i)==')' && lastChar=='(' ||
					s.charAt(i)==']' && lastChar=='[' ||
					s.charAt(i)=='}' && lastChar=='{'){
					stack.pop();						
				} else return false;
			}
        }
        return stack.isEmpty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
