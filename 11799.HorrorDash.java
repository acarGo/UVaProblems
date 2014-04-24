import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;


/**
 * @author Adrian Carenas
 * UVa Problem 11799
 *
 */
public class Main {
	private static Scanner in;
	private Vector<Integer> speeds;
	public void process() {
		int nTest = in.nextInt();
		int nStudents;
		for(int i = 1; i <= nTest; i++){
			nStudents = in.nextInt();
			speeds = new Vector<Integer>();
			for(int j = 0; j < nStudents; j++){
				speeds.add(in.nextInt());
			}
			System.out.println("Case " + (i) + ": " + Collections.max(speeds));
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
