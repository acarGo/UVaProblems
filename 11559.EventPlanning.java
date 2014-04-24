import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go)
 * UVa Problem 11559
 */
public class Main {
	private static Scanner in;

	public void process() {
		int nPart, budget, nHotels, price, nWeeks, nBeds, bestPrice;

		while (in.hasNext()) {
			bestPrice = Integer.MAX_VALUE;
			nPart = in.nextInt();
			budget = in.nextInt();
			nHotels = in.nextInt();
			nWeeks = in.nextInt();

			for (int i = 0; i < nHotels; i++) {
				price = in.nextInt();
				price = price * nPart;
				if (price <= budget)
					for (int j = 0; j < nWeeks; j++) {
						nBeds = in.nextInt();
						if (nBeds >= nPart && bestPrice > price)
							bestPrice = price;
					}
				else{
					in.nextLine();
					in.nextLine();
				}
			}
			if (bestPrice >= Integer.MAX_VALUE)
				System.out.println("stay home");
			else
				System.out.println(bestPrice);
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
