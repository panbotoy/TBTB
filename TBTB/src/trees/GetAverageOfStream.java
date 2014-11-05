package trees;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class GetAverageOfStream {

	/**
	 * @param args
	 */
	TreeSet<Node> tree = new TreeSet<Node>(new MyComparator());
	public void add(int i){
		Node node = new Node(i, 1, i);
		Node prev = tree.lower(node);
		if (prev == null){
			for (Node elem : tree){
				elem.count += node.count;
				elem.sum += node.sum;
			}
		} else {
			Set<Node> set = tree.tailSet(node, true);
			for (Node elem : set){
				elem.count += node.count;
				elem.sum += node.sum;
			}
			node.count += prev.count;
			node.sum += prev.sum;
		}
		tree.add(node);
	}
	
	public double getAverage(int lo, int hi){
		Node low = tree.lower(new Node(lo, 1, lo));
		Node high = tree.floor(new Node(hi, 1, hi));
		if (low != null){
			int sum = high.sum - low.sum;
			int count = high.count - low.count;
			return 1.0 * sum / count;
		} else {
			return 1.0 * high.sum / high.count;
		}
	}
	
	class Node{
		int val;
		int count;
		int sum;
		public Node (int val, int count, int sum){
			this.val = val;
			this.count = count;
			this.sum = sum;
		}
	}
	
	public class MyComparator implements Comparator<Node>{
		@Override 
		public int compare(Node n1, Node n2){
			if (n1.val < n2.val) return -1;
			else if (n1.val > n2.val) return 1;
			else return 0;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetAverageOfStream avg = new GetAverageOfStream();
		avg.add(1);
		avg.add(5);
		avg.add(3);
		avg.add(8);
		System.out.println(avg.getAverage(2, 8));
	}

}
