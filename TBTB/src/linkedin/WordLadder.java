package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

	/**
	 * @param args
	 * 
	 *            Word Ladder BFS
	 * 
	 *            Points to be alertive:
	 * 
	 *            1. when we before we visit a node, we need to check if it has
	 *            been visited 2. don't use ArrayList.clear 3. remember
	 *            sb.setCharAt(i, char);
	 */
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null)
			return 0;
		ArrayList<String> current = new ArrayList<String>();
		ArrayList<String> next = new ArrayList<String>();
		HashSet<String> visited = new HashSet<String>();
		int hop = 1;
		current.add(start);
		dict.add(start);
		dict.add(end);
		while (current.size() != 0) {
			hop++;
			for (String node : current) {
				if (visited.contains(node))
					continue;
				visited.add(node);
				ArrayList<String> neighbors = this.getNeighbors(node, dict);
				for (String neighbor : neighbors) {
					if (neighbor.equals(end))
						return hop;
					next.add(neighbor);
				}
			}
			current = next;
			next = new ArrayList<String>();
		}
		return 0;
	}

	private ArrayList<String> getNeighbors(String node, Set<String> dict) {
		// TODO Auto-generated method stub
		ArrayList<String> neighbors = new ArrayList<String>();
		for (int i = 0; i < node.length(); i++) {
			StringBuilder sb = new StringBuilder(node);
			for (char j = 'a'; j <= 'z'; j++) {
				sb.setCharAt(i, j);
				if (dict.contains(sb.toString())) {
					neighbors.add(sb.toString());
				}
			}
		}
		return neighbors;
	}

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		HashMap<String, List<List<String>>> routeMap = new HashMap<String, List<List<String>>>();
		boolean foundShortest = false;
		if (start == null || end == null || dict == null)
			return null;
		dict.add(start);
		dict.add(end);
		ArrayList<String> current = new ArrayList<String>();
		ArrayList<String> next = new ArrayList<String>();
		current.add(start);
		List<List<String>> initPaths = new ArrayList<List<String>>();
		List<String> path = new ArrayList<String>();
		path.add(start);
		initPaths.add(path);
		routeMap.put(start, initPaths);
		while (!current.isEmpty() && !foundShortest) {
			for (String node : current) {
				List<List<String>> currs = routeMap.get(node);
				List<String> neighbors = this.getNeighbors(node, dict);
				for (String neighbor : neighbors) {
					if (neighbor.equals(end)) foundShortest = true;
					List<List<String>> newPaths = new ArrayList<List<String>>();
					if (routeMap.containsKey(neighbor)) {
						List<List<String>> oldPaths = routeMap.get(neighbor);
						if (currs.get(0).size() + 1 > oldPaths.get(0).size()){
							continue;
						} else{
							for (List<String> curr : currs) {
								List<String> newPath = new ArrayList<String> ();
								newPath.addAll(curr);
								newPath.add(neighbor);
								newPaths.add(newPath);
							}
							routeMap.get(neighbor).addAll(newPaths);
						}
					} else {
						next.add(neighbor);
						for (List<String> curr : currs) {
							List<String> newPath = new ArrayList<String> ();
							newPath.addAll(curr);
							newPath.add(neighbor);
							newPaths.add(newPath);
						}
						routeMap.put(neighbor, newPaths);
					}
				}
			}
			current = next;
			next = new ArrayList<String>();
		}
		if (routeMap.containsKey(end))
			return routeMap.get(end);
		else
			return new ArrayList<List<String>>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
