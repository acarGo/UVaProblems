import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * @author Adrian Carenas 
 * UVa Problem 458
 */
public class Main {
	// private static Scanner in;

//	public void process() {
		// char c;
		// String input;
		// while ((in.hasNext())) {
		// input = in.nextLine();
		// if (input.isEmpty() == false) {
		// for (int i = 0; i < input.length(); i++) {
		// c = (char) (input.charAt(i) - 7);
		// System.out.print(c);
		// }
		// System.out.println();
		// }else
		// break;
		// }
		
//	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
//		in = new Scanner(System.in);
//		new Main().process();
//		in.close();
		DataInputStream in = new DataInputStream(System.in);
		DataOutputStream output = new DataOutputStream(System.out);
		int C;
		while ((C = in.read()) != -1)
			output.write((Character.isSpace((char) C) ? C : (C - 7)));
	}
}
