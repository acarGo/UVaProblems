import java.util.Scanner;

/**
 * @author Adrián Carenas 
 * UVa Problem 105 - Runtime: 0.562
 */

public class Main {
	private static Scanner in;
	private final int MAX_SIZE = 10001;
	private int[] track = new int[MAX_SIZE];
	
	public void draw() {
		for(int i=0;i<MAX_SIZE;i++) 
			track[i] = 0;
		int l;
		int h;
		int r = 0;
		int lmin = MAX_SIZE;
		int rmax = 0;
		while (in.hasNext()) {
			l = in.nextInt();
			h = in.nextInt();
			r = in.nextInt();
			if(lmin > l) 
				lmin = l;
			if(rmax < r)
				rmax = r;
			while(l<r){ 
				if(h>track[l]) 
					track[l] = h;  
				l++;
			}
		}
		int hChange = track[lmin];
		System.out.print(lmin + " " + hChange + " ");
		for (int i = lmin; i < rmax; i++) {
			if (track[i] != hChange) {
				hChange = track[i];
				System.out.print(i + " " + hChange + " ");
			}
		}
		System.out.println(rmax + " 0");
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().draw();
		in.close();
	}
}