package driver;

import solutions.EvalRPN;
import solutions.ReverseWords;

public class DriverForReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ReverseWords rw = new ReverseWords();
//		System.out.println(rw.reverseWords("   a   b "));
		String [] tokens = new String []{"3", "-4" , "+"};
		EvalRPN eval = new EvalRPN();
		int i= eval.evalRPN(tokens);
		System.out.println(i);
	}

}
