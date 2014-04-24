import java.util.Scanner;


/**
 * @author Adrian Carenas
 * UVa Problem 10055
 */
public class Main {
	private static Scanner in;
	private long armyOne;
	private long armyTwo;
	
	public void process() {
		while(in.hasNext()){
			armyOne = in.nextLong();
			armyTwo = in.nextLong();
			if(armyOne > armyTwo)
				System.out.println(armyOne - armyTwo);
			else
				System.out.println(armyTwo - armyOne);
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
