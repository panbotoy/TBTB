package string;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MostFrequentChar {

	/**
	 * @param args
	 */
	public String mostFrequent(String s) {
		if (s == null)
			return null;
		if (s.length() == 0)
			return s;
		int[] counters = new int[256];
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			counters[c]++;
			max = Math.max(max, counters[c]);
		}
		for (char i = 0; i < 256; i++) {
			if (counters[i] == max) {
				Character c = new Character(i);
				return c.toString();
			}
		}
		return null;
	}

	public String mostFrequent2(String s) {
		if (s == null)
			return null;
		if (s.length() == 0)
			return s;
		int[] counters = new int[256];
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			counters[c]++;
			max = Math.max(max, counters[c]);
		}
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(4,
				new MyComparator());
		for (int i = 0; i < 256; i++) {
			if (queue.size() < 4) {
				queue.offer(new Pair(new Character((char) i), counters[i]));
			} else {
				if (counters[i] >= queue.peek().frequency) {
					queue.poll();
					queue.offer(new Pair(new Character((char) i), counters[i]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			sb.append(queue.poll().character);
		}
		return sb.reverse().toString();
	}

	public class Pair {
		char character;
		int frequency;

		public Pair(char character, int frequency) {
			this.character = character;
			this.frequency = frequency;
		}
	}

	public class MyComparator implements Comparator<Pair> {
		@Override
		public int compare(Pair p1, Pair p2) {
			if (p1.frequency < p2.frequency) {
				return -1;
			} else if (p1.frequency > p2.frequency) {
				return 1;
			} else {
				if (p1.character > p2.character) {
					return 1;
				} else if (p1.character < p2.character) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
