import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go) 
 * UVa problem 341
 */
public class Main {

	private static Scanner in;
	private int map[][];
	private int path[][];

	public void process() {
		int nNodes, nInter, aNode, init, target, nTest = 0, minValor;
		while ((nNodes = in.nextInt()) != 0) {
			nTest++;
			map = new int[nNodes][nNodes];
			path = new int[nNodes][nNodes];
			for (int i = 0; i < nNodes; i++) {
				for (int j = 0; j < nNodes; j++) {
					map[i][j] = 1000000000; // Segun CP3 use 1.10^9 to avoid
											// overflow
					path[i][j] = i;
				}
			}
			for (int i = 0; i < nNodes; i++) {
				nInter = in.nextInt();
				for (int j = 0; j < nInter; j++) {
					aNode = in.nextInt();
					if (aNode != 0)
						map[i][aNode - 1] = in.nextInt();
				}
			}
			init = in.nextInt();
			target = in.nextInt();

			for (int k = 0; k < nNodes; k++) {
				for (int i = 0; i < nNodes; i++) {
					for (int j = 0; j < nNodes; j++) {
						minValor = map[i][k] + map[k][j];
						if (minValor < map[i][j]) {
							map[i][j] = minValor;
							path[i][j] = path[k][j];
						}
					}
				}
			}
			System.out.print("Case " + nTest + ": Path = ");
			mostrarRuta(init - 1, target - 1);
			System.out.println(" " + map[init - 1][target - 1]
					+ " second delay");
		}
	}

	private void mostrarRuta(int i, int j) {
		String track = "";
		int ant = path[i][j];
		track = (ant + 1) + " " + (j + 1) + ";";
		while (i != ant) {
			ant = path[i][ant];
			track = (ant + 1) + " " + track;
		}
		System.out.print(track);
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}