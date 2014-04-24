import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author Adrian Carenas (acar_go)
 * @Runtime 0.159
 */

public class Main {
	private static BufferedReader stdin;

	public void process() throws IOException {
		long numCuts;
		StringTokenizer st;
		String line;
		while ((line = stdin.readLine()) != null) {
			st = new StringTokenizer(line);
			numCuts = Integer.parseInt(st.nextToken());
			if (numCuts >= 0)
				System.out.println((numCuts * (numCuts + 1) / 2 + 1));
		}
	}

	public static void main(String[] args) throws Exception {
		stdin = new BufferedReader(new InputStreamReader(System.in));
		new Main().process();
		stdin.close();
	}
}