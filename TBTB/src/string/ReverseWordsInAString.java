package string;

/**
 * Needs to be very careful about the case like "a b", "abc" and " ";
 * ***/
public class ReverseWordsInAString {
    public String reverseWords(String s){
        if (s == null || s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        int hi = s.length();
        int lo = 0;
        boolean found = false;
        for (int i = s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if (c!=' '){
            	if (found) {
            		if (i!=0) continue;
            		sb.append(s.substring(0, hi));
            	} else {
            		found = true;
            		hi = i + 1;
            		if (i == 0)
            			sb.append(s.substring(0, hi));
            	}
            } else {
                if (!found) continue;
                found = false;
                lo = i+1;
                sb.append(s.substring(lo, hi)).append(" ");
            }
        }
        if (sb.length()!= 0 && sb.charAt(sb.length()-1) == ' ')
           return sb.substring(0, sb.length()-1);
       return sb.toString();
   }
}
