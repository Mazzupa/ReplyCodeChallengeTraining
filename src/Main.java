import java.awt.Point;

public class Main {

	public static void main(String args[]) {

		FindBestRoute finder = new FindBestRoute();

		finder.parse("./input/input_3.txt");

		char[][] matrix = finder.convertiMatrice();

		boolean pathExists = bfs.pathExists(matrix, new Point(finder.start.x,
				finder.start.y), new Point(finder.end.x, finder.end.y));

		System.out.println(pathExists ? "YES" : "NO");

	}
}