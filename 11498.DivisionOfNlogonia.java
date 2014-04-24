import java.util.Scanner;

/**
 * @author Adrian Carenas
 * UV Problem 11498
 */
public class Main {
	private static Scanner in;
	public void process() {
		int nQueries, n, m, x, y;
		while((nQueries = in.nextInt()) != 0){
			n = in.nextInt();
			m = in.nextInt();
			for(int i = 0; i < nQueries; i++){
				x = in.nextInt();
				y = in.nextInt();
				
				if(x == n || y == m)
					System.out.println("divisa");
				else if(x > n && y > m)
					System.out.println("NE");
				else if(x > n && y < m)
					System.out.println("SE");
				else if(x < n && y > m)
					System.out.println("NO");
				else
					System.out.println("SO");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
