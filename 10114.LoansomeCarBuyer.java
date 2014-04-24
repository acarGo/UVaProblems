import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go)
 * UVa Problem 10114
 */
public class Main {
	private static Scanner in;
	private double[] sDepreciation;

	public void process() {
		int duration, nDepreciation, aDepreciation;
		boolean found, end = false;
		double depreciation = 0, amountDepreciation, downPayment, amount, remainAmount, monthly;
		while (in.hasNext() && !end) {
			duration = in.nextInt();
			if (duration > 0) {
				found = false;
				downPayment = in.nextDouble();
				amount = in.nextDouble();
				nDepreciation = in.nextInt();
				sDepreciation = new double[duration + 1];
				remainAmount = amount;
				monthly = amount / duration;
				for (int j = 0; j < nDepreciation; j++) {
					aDepreciation = in.nextInt();
					depreciation = in.nextDouble();
					sDepreciation[aDepreciation] = depreciation;
					for (int k = aDepreciation; k < duration; k++) {
						sDepreciation[k] = depreciation;
					}
				}
				int i = 0;
				amountDepreciation = amount + downPayment;
				if (downPayment <= amount)
					do {
						amountDepreciation = amountDepreciation
								- (sDepreciation[i] * amountDepreciation);
						if (amountDepreciation > remainAmount) {
							found = true;
						}
						remainAmount -= monthly;
					} while (i++ <= duration && !found);
				else
					i++;
				if (i - 1 != 1)
					System.out.println(i - 1 + " months");
				else
					System.out.println(i - 1 + " month");
			}else{
				end = true;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
