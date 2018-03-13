import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindBestRoute {

	Point start;
	Point end;
	int numObstacles;
	int[][] obstacles;
	ArrayList<Point> bestRoute;

	public FindBestRoute() {
		this.bestRoute = new ArrayList<Point>();
	}

	public void parse(String path) {

		File file = new File(path);

		int[][] graph = null;
		int numObstacles = 0;

		try {
			Scanner sc = new Scanner(file);

			Point s = new Point(sc.nextInt(), sc.nextInt());
			Point e = new Point(sc.nextInt(), sc.nextInt());

			this.start = s;
			this.end = e;

			numObstacles = sc.nextInt();
			this.numObstacles = numObstacles;

			graph = new int[numObstacles][6];

			for (int i = 0; i < numObstacles; i++) {
				for (int j = 0; j < 6; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errore: " + e.getMessage());
			return;
		}

		this.obstacles = graph;
	}

	public boolean isPointInObstacles(Point A) {
		return true;
	}

	public char[][] convertiMatrice() {

		int lato = 10000;

		char[][] r = new char[lato][lato];

		for (int i = 0; i < lato; i++) {
			for (int j = 0; j < lato; j++) {

				r[i][j] = isPointInObstacles(new Point(i, j)) ? '0' : '1';
			}
		}

		return r;
	}

	public void fileOutput(String path) {
		try {
			@SuppressWarnings("resource")
			FileWriter fw = new FileWriter(path);
			fw.write(Integer.toString(bestRoute.size()) + '\n');
			try {
				for (Point i : bestRoute)
					fw.write(Integer.toString(i.x) + ' '
							+ Integer.toString(i.y) + '\n');
			} catch (NullPointerException e1) {
				System.out.println("Errore: " + e1.getMessage());
				return;
			}
			fw.flush();
		} catch (IOException e) {
			System.out.println("Errore: " + e.getMessage());
			return;
		}
	}

	public static boolean intersect(int x1, int y1, int x2, int y2, int x3,
			int y3, int x4, int y4) {

		double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
		if (denom == 0.0) // Lines are parallel.
			return true;

		double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denom;
		double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denom;

		if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f)
			return false;

		return true;
	}

}