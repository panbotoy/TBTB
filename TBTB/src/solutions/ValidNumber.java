package solutions;

public class ValidNumber {

	/**
	 * @param args
	 */
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;
		s = s.trim();
		if (s.length() == 0)
			return false;
		int dotCounter = 0;
		int eCounter = 0;
		int eIndex = -1;
		int signCounter = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9')
				continue;
			else if (c == 'e') {
				if (i == 0 || i == s.length() - 1)
					return false;
				if (++eCounter > 1)
					return false;
				dotCounter = 0;
				signCounter = 0;
				eIndex = i;
			} else if (c == '+' || c == '-') {
				if (i != eIndex + 1 && i != 0)
					return false;
				if (i == s.length() - 1)
					return false;
				char rightChar = s.charAt(i + 1);
				if (rightChar == 'e')
					return false;
				if (++signCounter > 1)
					return false;
				else
					continue;
			} else if (c == '.') {
				if ((++dotCounter > 1) || eCounter > 0)
					return false;
				char leftChar = i > 0 ? s.charAt(i - 1) : ' ';
				char rightChar = i < s.length() - 1 ? s.charAt(i + 1) : ' ';
				if (!('0' <= leftChar && leftChar <= '9')
						&& !('0' <= rightChar && rightChar <= '9'))
					return false;
			} else
				return false;
		}
		return true;
	}

	private boolean isValidSubNumber(String s) {
		if (s.length() == 0)
			return false;
		int dotCounter = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9')
				continue;
			else if (c == '+' || c == '-') {
				if (i != 0)
					return false;
				else
					continue;
			} else if (c == '.') {
				if (dotCounter < 1) {
					dotCounter++;
					continue;
				} else
					return false;
			} else
				return false;
		}
		return true;
	}

	private boolean isValidNumberSign(String s) {
		if (s == null || s.length() == 0)
			return false;
		char c = s.charAt(0);
		if (c == '-' || c == '+') {
			String[] subStrings = s.split("[+-]");
			if (subStrings.length == 2)
				return isValidNumberDot(subStrings[1]);
			else
				return false;
		} else {
			return isValidNumberDot(s);
		}
	}

	private boolean isValidNumberDot(String s) {
		if (s == null || s.length() == 0)
			return false;
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '.') {
				if (i == 0 && s.length() == 1)
					return false;
				if (++counter > 1)
					return false;
			}
			if (c >= '0' && c <= '9') {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber num = new ValidNumber();
		num.isNumber("-1.");
		System.out.println("e123".split("e").length);
	}

}
