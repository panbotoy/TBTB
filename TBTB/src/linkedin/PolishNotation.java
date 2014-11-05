package linkedin;

import java.util.Stack;
import java.util.StringTokenizer;

public class PolishNotation {
	
	/**
	 * IllegalArgumentException is thrown under:
	 * 	1. illegal tokens
	 *  2. stack does not have two numbers when encounter an operator;
	 *  3. stack has left numbers when there are no tokens
	 *  
	 * ArithmeticException:
	 * 	1. divided by 0
	 * **/
	public double evaluate(String[] tokens) throws IllegalArgumentException, ArithmeticException {
		Stack<Double> stack = new Stack<Double>();
		for (String token : tokens){
			if (token.equals("+")){
				if (stack.size() < 2) throw new IllegalArgumentException();
				double ops2 = stack.pop();
				double ops1 = stack.pop();
				stack.push(ops2 + ops1);
			}else if(token.equals("-")){
				if (stack.size() < 2) throw new IllegalArgumentException();
				double ops2 = stack.pop();
				double ops1 = stack.pop();
				stack.push(ops1 - ops2);
			}else if (token.equals("*")){
				if (stack.size() < 2) throw new IllegalArgumentException();
				double ops2 = stack.pop();
				double ops1 = stack.pop();
				stack.push(ops1 * ops2);
			}else if (token.equals("/")){
				if (stack.size() < 2) throw new IllegalArgumentException();
				double ops2 = stack.pop();
				double ops1 = stack.pop();
				if (ops2 == 0) throw new ArithmeticException();
				stack.push(ops1 / ops2);
			}else {
				try {
					double tokenOps = Double.parseDouble(token);
					stack.push(tokenOps);
				} catch( NumberFormatException e){
					throw new IllegalArgumentException();
				}
			}	
		}
		double result = stack.pop();
		if (!stack.isEmpty()) throw new IllegalArgumentException();
		return result;
	}
	
	/**
	 * Haven't used StringTokenizer for a while. Need to remember the APIs.
	 * 
	 * When encounter questions like this, need to be very careful with copy and paste. Double check every case!
	 * 
	 * ***/
	public String convert(String polish){
		StringTokenizer st = new StringTokenizer(polish, " ");
		Stack<String> stack = new Stack<String>();
		
		while (st.hasMoreTokens()){
			String token = st.nextToken();
			StringBuilder currentExp = new StringBuilder();
			if ( token.equals("+")){
				String op2 = stack.pop();
				String op1 = stack.pop();
				currentExp.append("(").append(op1).append("+").append(op2).append(")");
				stack.push(currentExp.toString());
			}
			else if ( token.equals("+")){
				String op2 = stack.pop();
				String op1 = stack.pop();
				currentExp.append("(").append(op1).append("-").append(op2).append(")");
				stack.push(currentExp.toString());
			}
			else if ( token.equals("*")){
				String op2 = stack.pop();
				String op1 = stack.pop();
				currentExp.append(op1).append("*").append(op2);
				stack.push(currentExp.toString());
			}
			else if ( token.equals("/")){
				String op2 = stack.pop();
				String op1 = stack.pop();
				if (Integer.valueOf(op2) == 0) return "Invalid Input 0!";
				currentExp.append(op1).append("/").append(op2);
				stack.push(currentExp.toString());
			} else {
				stack.push(token);
			}
		}
		String out = stack.pop();
		if (!stack.isEmpty()) return "Invalid Input!";
		return out;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in = {"5", "80", "40", "/", "+"} ;
		PolishNotation pn = new PolishNotation();
		double out = pn.evaluate(in);
		System.out.println(out);
	}

}
