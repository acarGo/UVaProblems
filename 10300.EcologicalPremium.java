import java.util.Scanner;

/**
 * @author Adrian Carenas
 * UVa Problem 10300
 */
public class Main {
	private static Scanner in;
	
	public void process() {
		int nTests = in.nextInt();
		int nFarmers, framyard, envire, premium;
		for(int i = 0; i < nTests; i++){
			nFarmers = in.nextInt();
			premium = 0;
			for(int j = 0; j < nFarmers; j++){
				framyard = in.nextInt();
				in.nextInt();
				envire = in.nextInt();
				premium += framyard * envire;
			}
			System.out.println(premium);	
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}