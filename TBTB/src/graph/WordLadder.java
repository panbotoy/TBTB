package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
    	if (start == null || end == null || dict == null) return 0;
    	dict.add(start);
    	dict.add(end);
        ArrayList<String> current = new ArrayList<String>();
        ArrayList<String> next = new ArrayList<String>();
        HashSet<String> visited = new HashSet<String>();
        current.add(start);
        int step = 1;
        while (current.size() != 0){
        	step += 1;
        	for (String node : current){
        		if (visited.contains(node)) continue;
        		else {
        			visited.add(node);
        			ArrayList<String> neighbors = this.getNeighbors(node, dict);
        			for (String neighbor : neighbors){
        				if (neighbor.equals(end)){
        					return step;
        				} else if(visited.contains(neighbor)){
        					continue;
        				} else {
        					next.add(neighbor);
        				}
        			}
        		}
        	}
        	current = next;
        	next = new ArrayList<String>();
        }
        return 0;
    }
    
    private ArrayList<String> getNeighbors(String node, Set<String> dict){
    	ArrayList<String > result = new ArrayList<String>();
    	int length = node.length();
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < length; i++){
    		sb = new StringBuilder(node);
    		for (char replace = 'a'; replace <= 'z'; replace++){
    			sb.replace(i, i+1, String.valueOf(replace));
    			if (dict.contains(sb.toString())) {
    				result.add(sb.toString());
    				sb = new StringBuilder(node);
    			}
    		}
    	}
    	return result;
    }
    
    public List<List<String>> ladderLengthII(String start, String end, Set<String> dict) {
    	HashMap<String, ArrayList<List<String>>> routeMap = new HashMap<String, ArrayList<List<String>>>();
    	boolean foundShortest = false;
    	if (start == null || end == null || dict == null) return null;
    	dict.add(start);
    	dict.add(end);
        ArrayList<String> current = new ArrayList<String>();
        ArrayList<String> next = new ArrayList<String>();
        current.add(start);
        while(!current.isEmpty() && !foundShortest){
        	for (String node: current){
        		ArrayList<List<String>> routes = new ArrayList<List<String>>();
        		
        		if (routeMap.containsKey(node)){
        			routes = routeMap.get(node);
        		} else {
        			ArrayList<String> route = new ArrayList<String>();
        			route.add(node);
        			routes.add(route);
        			routeMap.put(node, routes);
        		}
    			ArrayList<String> neighbors = this.getNeighbors(node, dict);
    			for (String neighbor: neighbors){
    				if (neighbor.equals(end)) foundShortest = true;
    				if (!routeMap.containsKey(neighbor)){
    					ArrayList<List<String>> routesToNeighbor = new ArrayList<List<String>>();
    					for (List<String> route: routes){
    						ArrayList<String> routeToNeighbor = new ArrayList<String>();
    						routeToNeighbor.addAll(route);
    						routeToNeighbor.add(neighbor);
    						routesToNeighbor.add(routeToNeighbor);
    					}
    					routeMap.put(neighbor, routesToNeighbor);
    					next.add(neighbor);
    				} else {
    					ArrayList<List<String>> routesToNeighbor = routeMap.get(neighbor);
    					int oldLength = routesToNeighbor.get(0).size();
    					int newLength = routes.get(0).size() + 1;
    					if (oldLength < newLength){
    						continue;
    					} else if (oldLength == newLength){
        					for (List<String> route: routes){
        						ArrayList<String> routeToNeighbor = new ArrayList<String>();
        						routeToNeighbor.addAll(route);
        						routeToNeighbor.add(neighbor);
        						routesToNeighbor.add(routeToNeighbor);
        					}
    					} else {
    						routesToNeighbor = new ArrayList<List<String>>();
        					for (List<String> route: routes){
        						ArrayList<String> routeToNeighbor = new ArrayList<String>();
        						routeToNeighbor.addAll(route);
        						routeToNeighbor.add(neighbor);
        						routesToNeighbor.add(routeToNeighbor);
        					}
    					}
    				}
    			}
        	}
        	current = next;
        	next = new ArrayList<String>();
        }
        if (routeMap.containsKey(end)) return routeMap.get(end);
        else return new ArrayList<List<String>>();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
