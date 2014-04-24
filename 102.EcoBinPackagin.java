import java.util.Scanner;

public class Main {
	private static Scanner in;
	
	public void input() {
		while (in.hasNext()) {
			int b1 = in.nextInt();
			int g1 = in.nextInt();
			int c1 = in.nextInt();
			
			int b2 = in.nextInt();
			int g2 = in.nextInt();
			int c2 = in.nextInt();
			
			int b3 = in.nextInt();
			int g3 = in.nextInt();
			int c3 = in.nextInt();
			
			in.nextLine();
			
			int minCombBot = Integer.MAX_VALUE;
			String minComb = "";
			int res = 0;
			
			res = b2+b3+g1+g3+c1+c2;
			if(res < minCombBot) { minCombBot = res; minComb = "BGC"; }
			
			res = b2+b3+c1+c3+g1+g2;
			if(res < minCombBot) { minCombBot = res; minComb = "BCG";}
			else if(res == minCombBot){ 
				if (minComb.compareTo("BCG") > 0){
					minComb = "BCG";
				}
			}
			
			res = g2+g3+b1+b3+c1+c2;
			if(res < minCombBot) { minCombBot = res; minComb = "GBC";}
			else if(res == minCombBot){ 
				if (minComb.compareTo("GBC") > 0){
					minComb = "GBC";
				}
			}
			
			res = g2+g3+c1+c3+b1+b2;
			if(res < minCombBot) { minCombBot = res; minComb = "GCB";}
			else if(res == minCombBot){
				if (minComb.compareTo("GCB") > 0){
					minComb = "GCB";
				}
			}
			
			res = c2+c3+g1+g3+b1+b2;
			if(res < minCombBot) { minCombBot = res; minComb = "CGB";}
			else if(res == minCombBot){
				if (minComb.compareTo("CGB") > 0){
					minComb = "CGB";
				}
			}
			
			res = c2+c3+b1+b3+g1+g2;
			if(res < minCombBot) { minCombBot = res; minComb = "CBG";}
			else if(res == minCombBot){
				if (minComb.compareTo("CBG") > 0){
					minComb = "CBG";
				}
			}
			
			System.out.println(minComb + " " + minCombBot);
		}
	}
	
	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().input();
		in.close();
	}
}