package solutions;

import java.util.Stack;

public class ReverseWords {
    public String reverseWords(String s) {
        boolean word = false;
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if(!word && s.charAt(i) !=' '){
                word = true;
                sb.append(s.charAt(i));
            } 
            else if (word && s.charAt(i) != ' '){
            	sb.append(s.charAt(i));
            }
            else if (word && s.charAt(i) == ' ') {
            	word = false;
            	if (stack.size() != 0) stack.push(" ");
            	stack.push(sb.toString());
            	sb = new StringBuilder();
            }
        }
        if (sb.length() != 0) {
        	if (stack.size() != 0) stack.push(" ");
        	stack.push(sb.toString()); 
        	sb = new StringBuilder();
        }
        
        while (stack.size() != 0){
        	sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    public String reverseWordsRecursion(String s){
    	return getNextWord(s, 0);
    }
    
    private String getNextWord(String s, int index){
    	boolean isWord = false;
    	StringBuilder sb = new StringBuilder();
    	for (int i = index; i < s.length(); i++){
    		if (!isWord && s.charAt(i) != ' '){
    			isWord = true;
    			sb.append(s.charAt(i));
    		} else if( isWord && s.charAt(i) != ' '){
    			sb.append(s.charAt(i));
    		} else if ( isWord && s.charAt(i) == ' '){
    			isWord = false;
    			sb.append(" ");
    			return sb.toString() + this.getNextWord(s, i);
    		}
    	}
    	return sb.toString();
    	
    }
}
