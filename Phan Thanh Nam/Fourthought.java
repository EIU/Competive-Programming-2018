import java.util.Scanner;

public class Fourthought {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int n = sc.nextInt();
			if (4 + 4 + 4 / 4 == n)
				System.out.println("4 + 4 + 4 / 4 = " + n);
			else if (4 + 4 + 4 * 4 == n)
				System.out.println("4 + 4 + 4 * 4 = " + n);
			else if (4 + 4 - 4 / 4 == n)
				System.out.println("4 + 4 - 4 / 4 = " + n);
			else if (4 + 4 - 4 * 4 == n)
				System.out.println("4 + 4 - 4 * 4 = " + n);
			else if (4 + 4 / 4 / 4 == n)
				System.out.println("4 + 4 / 4 / 4 = " + n);

			else if (4 * 4 - 4 - 4 == n)
				System.out.println("4 * 4 - 4 - 4 = " + n);
			else if (4 - 4 - 4 / 4 == n)
				System.out.println("4 - 4 - 4 / 4 = " + n);
			else if (4 - 4 * 4 - 4 == n)
				System.out.println("4 - 4 * 4 - 4 = " + n);
			else if (4 - 4 * 4 * 4 == n)
				System.out.println("4 - 4 * 4 * 4 = " + n);

			else if (4 * 4 + 4 / 4 == n)
				System.out.println("4 * 4 + 4 / 4 = " + n);
			else if (4 * 4 + 4 * 4 == n)
				System.out.println("4 * 4 + 4 * 4 = " + n);
			else if (4 * 4 / 4 / 4 == n)
				System.out.println("4 * 4 / 4 / 4 = " + n);
			else if (4 * 4 - 4 * 4 == n)
				System.out.println("4 * 4 - 4 * 4 = " + n);
			else if (4 * 4 + 4 + 4 == n)
				System.out.println("4 * 4 + 4 + 4 = " + n);
			else if (4 * 4 - 4 / 4 == n)
				System.out.println("4 * 4 - 4 / 4 = " + n);
			else if (4 * 4 * 4 / 4 == n)
				System.out.println("4 * 4 * 4 / 4 = " + n);
			else if (4 * 4 * 4 + 4 == n)
				System.out.println("4 * 4 * 4 + 4 = " + n);
			else if (4 * 4 * 4 - 4 == n)
				System.out.println("4 * 4 * 4 - 4 = " + n);

			else if (4 / 4 - 4 * 4 == n)
				System.out.println("4 / 4 - 4 * 4 = " + n);
			else if (4 / 4 - 4 - 4 == n)
				System.out.println("4 / 4 - 4 - 4 = " + n);
			else if (4 / 4 / 4 - 4 == n)
				System.out.println("4 / 4 / 4 - 4 = " + n);
			else if (4 / 4 + 4 / 4 == n)
				System.out.println("4 / 4 + 4 / 4 = " + n);

			else
				System.out.println("no solution");
		}

	}

}
