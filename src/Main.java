import java.awt.Point;

public class Main {

	public static void main(String args[]) {

		Finder f = new Finder("./input/input_1.txt");
		
		char[][] b = f.creaMatrice();
		
		boolean path = bfs.pathExists(b, f.start, f.end);

		System.out.println(path);
	}
}