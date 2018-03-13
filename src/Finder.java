import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Finder {
	Point start;
	Point end;
	int numOstacoli;
	int[][] ostacoli;
	char[][] mappa;
	ArrayList<Point> stradaMigliore;
	
	
	public Finder(String path){
		
		stradaMigliore = new ArrayList<Point>();
		
		File file = new File(path);

		int numObstacles = 0;

		try {
			Scanner sc = new Scanner(file);

			start = new Point(sc.nextInt(), sc.nextInt());
			end = new Point(sc.nextInt(), sc.nextInt());


			numOstacoli = sc.nextInt();


			ostacoli = new int[numObstacles][6];

			for (int i = 0; i < numObstacles; i++) {
				for (int j = 0; j < 6; j++) {
					ostacoli[i][j] = sc.nextInt();
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Errore: " + e.getMessage());
			return;
		}
	}
	
	//TODO
	public boolean isPointInObstacles(Point A) {
		//degs
		return true;
	}

	public char[][] creaMatrice() {

		int lato = 20000;
		
		char[][] r = new char[lato][lato];

		for (int i = 0; i < lato; i++) {
			for (int j = 0; j < lato; j++) {

				r[i][j] = isPointInObstacles(new Point(i - (lato/2), j + (lato/2))) ? '0' : '1';
			}
		}

		return r;
	}

}
