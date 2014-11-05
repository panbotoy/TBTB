package recursion;

import java.util.ArrayList;
import java.util.List;

public class MouseAndCheese {

	/**
	 * @param args
	 */
	class Position {
		int x;
		int y;
		int z;
		public Position(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		@Override 
		public String toString(){
			return "(" + x + "," + y + "," + z + ")";
		}
	}
	
	public List<List<Position>> canEat(){
		int [][][] cheese = new int[3][3][3];
		cheese[0][0][0] = 1;
		List<Position> res = new ArrayList<Position>();
		res.add(new Position(0,0,0));
		List<List<Position>> paths = new ArrayList<List<Position>>();
		mouseHelper(cheese, 1, res, paths);
		return paths;
	}
	Position destination = new Position(0,1,0);
	public void mouseHelper(int [][][] cheese, int index, List<Position> res, List<List<Position>> paths){
		if (index == 27 && res.get(res.size()-1).toString().equals(this.destination.toString())){
			List<Position> path = new ArrayList<Position>();
			path.addAll(res);
			paths.add(path);
			return;
		}
		if (index != 27 && cheese[destination.x][destination.y][destination.z] == 1) return;
		Position last = res.get(res.size()-1);
		List<Position> neighbors = getNeighbors(last);
		for (Position neighbor : neighbors){
			if(cheese[neighbor.x][neighbor.y][neighbor.z] != 1){
				cheese[neighbor.x][neighbor.y][neighbor.z] = 1;
				res.add(neighbor);
				mouseHelper(cheese, index + 1, res, paths);
				cheese[neighbor.x][neighbor.y][neighbor.z] = 0;
				res.remove(res.size()-1);
			} 
		}
	}
	
	private List<Position> getNeighbors(Position last) {
		// TODO Auto-generated method stub
		List<Position> res = new ArrayList<Position>();
		if (last.x - 1 >= 0) res.add(new Position(last.x-1, last.y, last.z));
		if (last.x + 1 <= 2) res.add(new Position(last.x+1, last.y, last.z));
		if (last.y - 1 >= 0) res.add(new Position(last.x, last.y-1, last.z));
		if (last.y + 1 <= 2) res.add(new Position(last.x, last.y+1, last.z));
		if (last.z - 1 >= 0) res.add(new Position(last.x, last.y, last.z-1));
		if (last.z + 1 <= 2) res.add(new Position(last.x, last.y, last.z+1));
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseAndCheese mouse = new MouseAndCheese();
		List<List<Position>> paths = mouse.canEat();
		System.out.println(paths.size());
	}

}
