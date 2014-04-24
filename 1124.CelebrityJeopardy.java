import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go)
 * UVa Problem 1124
 */
public class Main {
	private static Scanner in;
	
	public void process(){
		String aEquation1;
		String aEquation2;
		
		while(in.hasNext()){
			aEquation1 = in.nextLine();
			aEquation2 = in.nextLine();
			System.out.println(aEquation1 + "\n" + aEquation2);
		}
	}
	
	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
