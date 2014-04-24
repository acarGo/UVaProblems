import java.util.Scanner;

/**
 * @author Adrian Carenas
 * UVa Problem 10071
 */
public class Main {
	private static Scanner in;
	private int v;
	private int t;
	
	public void process() {
		while(in.hasNext()){
			v = in.nextInt();
			t = in.nextInt();
			
			System.out.println(v*t*2);
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}