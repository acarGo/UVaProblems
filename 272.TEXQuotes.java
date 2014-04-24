import java.util.Scanner;

/**
 * @author Adrian Carenas (acar_go)
 * UVa Problem 272
 */

public class Main {
	private static Scanner in;
	private String inputS;
	private String modS;

	public void process() {
		boolean init = false;
		char letter;
		while(in.hasNext()){
			inputS = "";
			modS = "";
			inputS = in.nextLine();
			for(int i = 0; i < inputS.length(); i++){
				letter = inputS.charAt(i);
				if(letter == '"')
					if(!init){
						modS += "``";
						init = true;
					}else{
						modS += "''";
						init = false;
					}
				else
					modS += letter;
			}
			System.out.println(modS);
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}
