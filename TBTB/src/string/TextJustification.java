package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	/**
	 * @param args
	 * 
	 * 1. try to consider all kinds of special cases, it is a really very tedious question
	 */
	
    public List<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) return res;
        List<String> line = new ArrayList<String>();
        int len = 0;  //length of current line
        int count = 0; // count of words in currentline
        
        for (int i = 0; i < words.length; i++){
        	if(line.isEmpty()){
        		if(i != words.length-1){
        			line.add(words[i]);
        			count++;
        			len+=words[i].length();
        		} 
        		else {
        			StringBuilder sb = new StringBuilder();
        			sb.append(words[i]);
        			int extraSpace = L - words[i].length();
        			for (int j = 0; j < extraSpace; j++){
         				sb.append(" ");
         			}
         			res.add(sb.toString());
        		}
        	} else{
        		if (words[i].length() + len + 1 <= L){
        			line.add(words[i]);
        			count++;
        			len += words[i].length() + 1;
        			
        			if ( i == words.length - 1){
        				StringBuilder sb = new StringBuilder();
        				for (int j = 0; j < line.size(); j++){
         					if (j == 0) sb.append(line.get(j));
         					else sb.append(" ").append(line.get(j));
         				}
	        			int extraSpace = L - len;
	        			for (int j = 0; j < extraSpace; j++){
	         				sb.append(" ");
	         			}
	         			res.add(sb.toString());
         			}
         		} else {   // if the line cannot add the next word
     				StringBuilder sb = new StringBuilder();
     				int extraSpace = L - len;

     				sb.append(line.get(0));
     				if (line.size() == 1) {
     					for (int j = 0; j < extraSpace; j++){
     						sb.append(" ");
     					}
     				} else {
         				int avgSpace = extraSpace/(count-1);
         				int leftSpace = extraSpace % (count-1);
     					for (int j = 1; j < line.size(); j++){
     						sb.append(" ");
     						if (leftSpace > 0) {
     							sb.append(" ");
     							leftSpace--;
     						}
     						for (int k = 0; k < avgSpace; k++){
     							sb.append(" ");
     						}
     						sb.append(line.get(j));
     					}
     				}
     				res.add(sb.toString());
     				line = new ArrayList<String>();
     				len = 0;
         			count = 0;
         			i = i-1;
         		}
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
