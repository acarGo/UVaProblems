import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go) Runtime: 1.555
 */
class Main {
	private static int iTotal, jTotal;
	private static int[][] stepsWeight;
	private static int[][] memo;
	private static int[][] path;
	private static Scanner in;

	// Use BufferedReader
	public static void main(String[] args) {
		int minimalWeight, aux, minPath;
		in = new Scanner(System.in);
		while (in.hasNext()) {
			iTotal = in.nextInt();
			jTotal = in.nextInt();
			stepsWeight = new int[iTotal + 1][jTotal + 1];
			memo = new int[iTotal + 1][jTotal + 1];
			path = new int[iTotal + 1][jTotal + 1];
			for (int i = 1; i <= iTotal; i++) {
				for (int j = 1; j <= jTotal; j++)
					stepsWeight[i][j] = in.nextInt();
			}
			minPath = 1;
			minimalWeight = cmin(1, 1);

			for (int y = 2; y <= iTotal; y++) {
				aux = cmin(y, 1);
				if (aux < minimalWeight) {
					minimalWeight = aux;
					minPath = y;
				}
			}
			displayPath(minPath);
			System.out.println(minimalWeight);
		}
		in.close();
	}

	private static void displayPath(int minPath) {
		// j columna siempre avanza hacia delante
		// sig indica la fila siguiente para obtener el minimal path
		String pathS = Integer.toString(minPath);
		int sig = path[minPath][1];
		int j = 2;
		while (j <= jTotal) {
			pathS += " " + Integer.toString(sig);
			sig = path[sig][j];
			j++;
		}
		System.out.println(pathS);
	}

	private static int cmin(int i, int j) {
		int min = 0, minIndex = 0;
		if (j == jTotal + 1)
			return 0;
		else if (memo[i][j] != 0)
			return memo[i][j];
		else {
			int weight1, weight2, weight3;
			if (i == 1) {
				// i-1
				weight1 = cmin(iTotal, j + 1);
				minIndex = iTotal;
				min = weight1;
				// i
				weight2 = cmin(i, j + 1);
				if (weight2 < min || (weight2 == min && i < minIndex)) {
					min = weight2;
					minIndex = i;
				}
				// i+1
				if (i == iTotal) { // iTotal == 1
					weight3 = cmin(1, j + 1);
					if (weight3 < min || (weight3 == min && 1 < minIndex)) {
						minIndex = 1;
						min = weight3;
					}
				} else {
					weight3 = cmin(i + 1, j + 1);
					if (weight3 < min || (weight3 == min && i + 1 < minIndex)) {
						minIndex = i + 1;
						min = weight3;
					}
				}
				// System.out.println("i == 1 " + "minIndex: " + minIndex +
				// "; min: " + min);
			} else if (i == iTotal) {
				// i-1
				weight1 = cmin(i - 1, j + 1);
				minIndex = i - 1;
				min = weight1;
				// i
				weight2 = cmin(i, j + 1);
				if (weight2 < min || (weight2 == min && i < minIndex)) {
					min = weight2;
					minIndex = i;
				}
				// i+1
				weight3 = cmin(1, j + 1);
				if (weight3 < min || (weight3 == min && 1 < minIndex)) {
					min = weight3;
					minIndex = 1;
				}
				// System.out.println("i == iTotal " + "minIndex: " + minIndex +
				// "; min: " + min);
			} else {
				// i-1
				weight1 = cmin(i - 1, j + 1);
				min = weight1;
				minIndex = i - 1;
				// i
				weight2 = cmin(i, j + 1);
				if (weight2 < min || (weight2 == min && i < minIndex)) {
					min = weight2;
					minIndex = i;
				}
				// i+1
				weight3 = cmin(i + 1, j + 1);
				if (weight3 < min || (weight3 == min && i + 1 < minIndex)) {
					min = weight3;
					minIndex = i + 1;
				}
				// System.out.println("i == Cualquiera " + "minIndex: " +
				// minIndex + "; min: " + min);
			}
			path[i][j] = minIndex;
			return memo[i][j] = stepsWeight[i][j] + min;
		}
	}
}