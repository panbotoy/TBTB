package graph;

import java.util.HashMap;
import java.util.HashSet;

public class CloneGraph {

	HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (this.visited.containsKey(node)) {
        	return this.visited.get(node);
        } else {
        	UndirectedGraphNode nodeCp = new UndirectedGraphNode(node.label);
        	this.visited.put(node, nodeCp);
        	for (UndirectedGraphNode neighbor: node.neighbors){
        		nodeCp.neighbors.add(this.cloneGraph(neighbor));
        	}
        	return nodeCp;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
