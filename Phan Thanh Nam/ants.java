import java.util.Arrays;
import java.util.Scanner;

public class ants {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int length = sc.nextInt();
			int a = sc.nextInt();
			int min = 0;
			int max = 0;
			for (int j = 0; j < a; j++) {
				int arrange = sc.nextInt();
				min = Math.max(min, Math.min(arrange, length - arrange));
				max = Math.max(max, Math.max(arrange, length - arrange));
			}
			System.out.println(min + " " + max);
		}

	}

}
