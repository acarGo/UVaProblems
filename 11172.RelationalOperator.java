import java.util.Scanner;

/**
 * @author adrian Carenas (acar_go)
 * UVa Problem 11172
 */
public class Main {
	private static Scanner in;

	public void process() {
		int nInputs, a, b;
		nInputs = in.nextInt();
		for (int i = 0; i < nInputs; i++) {
			a = in.nextInt();
			b = in.nextInt();
			if (a < b)
				System.out.println("<");
			else if (b < a)
				System.out.println(">");
			else
				System.out.println("=");
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
