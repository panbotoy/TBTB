package parenthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	/**
	 * @param args
	 * 
	 * This answer is the better then the previous code to "insert" into space that I wrote.
	 * This answer has a time complexity less than O(2^n) because of the back tracking;
	 * The use of StringBuilder makes it even better to add one char to the string
	 */
	public List<String> generateParenthesis(int n) {
		if ( n < 0 ) return new ArrayList<String>();
		List<String> res = new ArrayList<String>();
		this.parenthesisHelper(n, n, res, new StringBuilder());
		return res;
	}
	
	private void parenthesisHelper(int left, int right, List<String> res, StringBuilder sb){
		if ( left > right ) return; // the case where more ) is placed than (, already illegal
		if ( right == 0 ) {
			res.add(sb.toString());
			return;
		}
		if (left == 0) {
			sb.append(")");
			this.parenthesisHelper(left, right - 1, res, sb);
			return; 
		}
		else {
			StringBuilder lsb = new StringBuilder(sb);
			StringBuilder rsb = new StringBuilder(sb);
			lsb.append("(");
			rsb.append(")");
			this.parenthesisHelper(left-1, right, res, lsb);
			this.parenthesisHelper(left, right-1, res, rsb);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis g = new GenerateParenthesis();
		g.generateParenthesis(50);
	}

}
