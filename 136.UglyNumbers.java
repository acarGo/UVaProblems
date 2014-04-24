import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go)
 * UVa Problem 136
 */

public class Main {
	private static Scanner in;
//	private final int MAX_SIZE = 10000000;
	private ArrayList<Double> s = new ArrayList<Double>();

	public void process() {
//		int num = 1;
//		int i = 1;
//		s[i] = 1;
//		while (i < 1500) {
//			num++;
//			System.out.println(num);
//			if (dividido(num))
//				i++;
//		}
		for (int i = 0; i <= 38; i++) {
			for (int j = 0; j <= 38; j++) {
				for (int k = 0; k <= 38; k++) {
					s.add((Math.pow(2, i) * Math.pow(3, j) * Math.pow(5,
							k)));
				}
			}
		}
		Collections.sort(s);
		System.out.printf("The 1500'th ugly number is %.0f.\n", s.get(1499));
	}

//	private boolean dividido(int num) {
//		num = dividido_aux(num);
//		if (num == 1)
//			return true;
//		return false;
//	}

//	private boolean dividido(int num) {
//		if (num < MAX_SIZE) {
//			if (s[num] == 1)
//				return 1;
//			else if(s[num] == -1) 
//				return 0;
//			else if (num % 2 == 0) {
//						dividido_aux(num / 2);
//					} else if (num % 3 == 0) {
//						dividido_aux(num / 3);
//					} else if (num % 5 == 0) {
//						dividido_aux(num / 5);
//					} else
//						return num;
//		}
//		return 0;
//	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
