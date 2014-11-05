package solutions;

import java.util.Stack;

public class EvalRPN {

	/**
	 * @param args
	 */
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		for (String token : tokens) {
			if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				int operand2 = Integer.valueOf(stack.pop());
				int operand1 = Integer.valueOf(stack.pop());
				int result = 0;
				if (token == "+")
					result = operand1 + operand2;
				else if (token == "-")
					result = operand1 - operand2;
				else if (token == "*")
					result = operand1 * operand2;
				else if (token == "/")
					result = operand1 / operand2;
				stack.push(String.valueOf(result));
			} else {
				stack.push(token);
			}
		}
		return Integer.valueOf(stack.pop());
	}
}
