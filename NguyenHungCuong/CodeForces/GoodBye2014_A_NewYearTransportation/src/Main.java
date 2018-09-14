import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		int destination = scan.nextInt();
//		int currentPosition = 1;
//		boolean found = false;
//		for (int i=1;i<n;i++) {
//			int input = scan.nextInt();
//			currentPosition += (i == currentPosition)?input:0;
//			if (currentPosition == destination) {
//				found = true;
//			}
//		}
//		System.out.println(found?"YES":"NO");
		int weight = scan.nextInt();
		if (weight <=3 || weight % 2 == 1) {
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
		
	}

}
