import java.util.Scanner;


public class Main {
	private static Scanner in;

	public void process() {
		double h,u,d,f, climb;
		boolean exceed = false, failure=false;
		int i;
		while((h = in.nextInt()) != 0){
			i = 0;
			exceed = false;
			failure=false;
			climb = 0;
			u = in.nextDouble();
			d = in.nextDouble();
			f = in.nextDouble();
			
			f = u*(f/100);
			while(climb <= h && !exceed && !failure){
				climb += u;
				if(climb > h)
					exceed = true;
				climb -= d;
				if(climb < 0)
					failure = true;
				u -= f;
				if(u < 0)
					u = 0;
				i++;
			}
			if(exceed)
				System.out.println("success on day " + i);
			else
				System.out.println("failure on day " + i);
		}
	}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		new Main().process();
		in.close();
	}
}

