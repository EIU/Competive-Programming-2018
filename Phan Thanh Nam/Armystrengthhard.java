import java.util.Scanner;

public class Armystrengthhard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int God = sc.nextInt();
			int Mecha = sc.nextInt();
			int temp1 = 0;
			int temp2 = 0;
			for (int j = 0; j < God; j++) {
				int g = sc.nextInt();
				if (g > temp1) {
					temp1 = g;
				}
			}
			for (int j = 0; j < Mecha; j++) {
				int m = sc.nextInt();
				if (m > temp2) {
					temp2 = m;
				}
			}
			if (temp1 < temp2) {
				System.out.println("MechaGodzilla");
			} else {
				System.out.println("Godzilla");
			}
		}
	}

}
