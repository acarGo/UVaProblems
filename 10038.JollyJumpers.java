import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @Author Adrian Carenas (acar_go)
 * @Runtime 0.462
 */

public class Main {
	private static BufferedReader stdin;
	private static ArrayList<Integer> sequence;

	public void process() throws IOException {
		int ant, act, numNum = 0, i;
		StringTokenizer st;
		String line;
		while ((line = stdin.readLine()) != null) {
			st = new StringTokenizer(line);
			numNum = Integer.parseInt(st.nextToken());
			i = 0;
			if (numNum > 1) {
				sequence = new ArrayList<Integer>(numNum);
				ant = Integer.parseInt(st.nextToken());
				while (i < numNum -1) {
					act = Integer.parseInt(st.nextToken());
					sequence.add(Math.abs(ant - act));
					ant = act;
					i++;
				}
				boolean notJolly = false;
				Collections.sort(sequence);
				if (sequence.get(0) == 1) {
					for (i = 0; i < numNum - 2 && !notJolly; i++) {
						if (sequence.get(i + 1) - sequence.get(i) != 1) {
							notJolly = true;
						}
					}
				} else
					notJolly = true;

				if (notJolly)
					System.out.println("Not jolly");
				else
					System.out.println("Jolly");
			}else
				System.out.println("Jolly");
		}
	}

	public static void main(String[] args) throws Exception {
		stdin = new BufferedReader(new InputStreamReader(System.in));
		new Main().process();
		stdin.close();
	}
}