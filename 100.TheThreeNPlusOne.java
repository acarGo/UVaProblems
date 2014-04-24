package acg.uva.threenplusone;

import java.util.Scanner;

public class Main {
	private static Scanner in;
	private static int MAX_SIZE = 5000000;
	private int[] container = new int[MAX_SIZE];

	public void input() {
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int result;
			in.nextLine();
			if (n > m) {
				result = maxCycle(m, n);
			} else {
				result = maxCycle(n, m);
			}
			System.out.println(n + " " + m + " " + result);
		}
	}

	private int maxCycle(int m, int n) {
		int maxCount = Integer.MIN_VALUE;
		int res;
		for (int i = m; i <= n; i++) {
			res = cycleLengthOfN(i);
			if (res > maxCount)
				maxCount = res;
		}
		return maxCount;
	}

	private int cycleLengthOfN(long num) {
		if (num < MAX_SIZE){
			if (container[(int) num] > 0) {
				return container[(int) num];
			} else if (num == 1) {
				container[(int) num] = 1;
				return 1;
			} else if (num % 2 == 0) {
				int aux = cycleLengthOfN(num / 2);
				container[(int) num] = aux + 1;
				return aux + 1;
			} else{
				int aux = cycleLengthOfN(num * 3 + 1);
				container[(int) num] = aux + 1;
				return aux + 1;
			}
		}else{
			if (num % 2 == 0) {
				int aux = cycleLengthOfN(num / 2);
				return aux + 1;
			} else{
				int aux = cycleLengthOfN(num * 3 + 1);
				return aux + 1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().input();
		in.close();
	}
}