import java.awt.Point;
import java.util.ArrayList;

public class bfs {
	public static boolean pathExists(char[][] matrix, Point start, Point end) {
		
		ArrayList<Point> queue = new ArrayList<Point>();
		 		
		queue.add(new Point(start.x, start.y));
		boolean pathExists = false;

		while (!queue.isEmpty()) {
			Point current = queue.remove(0);
			if (current.equals(end)) {
				pathExists = true;
				break;
			}

			matrix[current.x][current.y] = '0'; // mark as visited

			ArrayList<Point> neighbors = getNeighbors(matrix, current);
			
			for(Point p : neighbors){
				if(!queue.contains(p))
					queue.add(p);
			}
		}

		return pathExists;
	}

	public static ArrayList<Point> getNeighbors(char[][] matrix, Point _point) {
		
		ArrayList<Point> neighbors = new ArrayList<Point>();

		if (isValidPoint(matrix, _point.x - 1, _point.y)) {
			neighbors.add(new Point(_point.x - 1, _point.y));
		}

		if (isValidPoint(matrix, _point.x + 1, _point.y)) {
			neighbors.add(new Point(_point.x + 1, _point.y));
		}

		if (isValidPoint(matrix, _point.x, _point.y - 1)) {
			neighbors.add(new Point(_point.x, _point.y - 1));
		}

		if (isValidPoint(matrix, _point.x, _point.y + 1)) {
			neighbors.add(new Point(_point.x, _point.y + 1));
		}

		return neighbors;
	}

	public static boolean isValidPoint(char[][] matrix, int x, int y) {
		return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0');
	}
}