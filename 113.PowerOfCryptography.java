import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go)
 * UVa Problem 113
 *
 */
public class Main {
	private static Scanner in;
	public void process() {
		double n, p, k;
		while(in.hasNext()){
			n = in.nextDouble();
			p = in.nextDouble();
			k = Math.pow(Math.E, Math.log(p)/n);
			System.out.printf("%.0f\n",k);
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
