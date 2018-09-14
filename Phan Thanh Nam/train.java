import java.util.Scanner;

public class train {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int a = sc.nextInt();
		boolean check = true;
		int left = 0;
		int entered = 0;
		int stay = 0;
		int train = 0;
		while (a > 0) {
			left = sc.nextInt();
			entered = sc.nextInt();
			stay = sc.nextInt();
			if (left > train) {
				check = false;
			}
			train -= left;
			if (train + entered > C) {
				check = false;
			}
			train += entered;
			if (train != C && stay != 0) {
				check = false;
			}
			a--;
		}
		if (entered != 0 || stay != 0 || train != 0) {
			check = false;
		}
		if (check) {
			System.out.println("possible");
		} else {
			System.out.println("impossible");
		}
	}

}
