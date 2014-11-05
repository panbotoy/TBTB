package string;

import java.util.LinkedList;

public class SimplifyPath {

	/**
	 * @param args
	 * 
	 * 1. Things to remember:
	 * 
	 * 1. corner cases clarify "//", "/../", "abc"
	 * 2. how to manipulate the two pointers lo and hi;
	 * 3. Use a deque to store the subpaths.
	 * 4. The java API indexOf('', startIndex);
	 * 
	 */
	public String simplifyPath(String path){
		if (path == null || path.length() == 0) return "/";
		int lo = -1;
		int hi = path.indexOf('/');
		LinkedList<String> list=  new LinkedList<String>();
		while (hi != -1){
			lo = hi;
			hi = path.indexOf('/', lo+1);
			String subpath = null;
			if (hi == -1 ) subpath = path.substring(lo);
			else subpath = path.substring(lo, hi);
			if (subpath.equals("/.") || subpath.equals("/")) continue;
			else if (subpath.equals("/..")){
				if (list.size()!=0) list.removeLast();
			} else {
				list.add(subpath);
			}
		}
		if (list.size() == 0) return "/";
		StringBuilder sb = new StringBuilder();
		for ( String subpath : list){
			sb.append(subpath);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
