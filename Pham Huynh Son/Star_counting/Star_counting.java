import java.util.Arrays;
import java.util.Scanner;

public class Star_counting {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int t=1;
		while (input.hasNext()) {

			int n = input.nextInt();
			int m = input.nextInt();
			String[] star = new String[n];
			int start = 0, end = 0;
			int k=0,count=1;
			for (int i = 0; i < n; i++) {
				star[i] = input.next();
				if (k == 0) {
					start = star[i].indexOf("-");
					end = star[i].lastIndexOf("-");
					k=1;
				}else {		
					
						if(star[i].indexOf("-", start)<=end) {
							start = star[i].indexOf("-");
							end = star[i].lastIndexOf("-");
						} else {
							count++;
							k=0;
						}
				}
			}
			System.out.println("Case"+" "+t+":"+" "+count+"\n");
			t++;
		}
	}
}
