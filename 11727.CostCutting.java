import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Adrian Carenas 
 * UVa Problem 11727
 * 
 */
public class Main {
	private static Scanner in;
	private final int N_SALARIES = 3;
	private Vector<Integer> salaries;;

	public void process() {
		int nTests;
			nTests = in.nextInt();
			for (int i = 0; i < nTests; i++) {
				salaries = new Vector<Integer>(N_SALARIES);
				salaries.add(in.nextInt());
				salaries.add(in.nextInt());
				salaries.add(in.nextInt());
				Collections.sort(salaries);
				System.out.println("Case " + (i+1) + ": " + salaries.get(1));
			}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
