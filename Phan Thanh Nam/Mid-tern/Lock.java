import java.util.Scanner;

public class Lock {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int start = sc.nextInt();
			int first = sc.nextInt();
			int second = sc.nextInt();
			int third = sc.nextInt();
			if (start == 0 && first == 0 && second == 0 && third == 0) {
				break;
			}
			int degree = 1080 + ((start - first + 40) % 40 + (second - first + 40) % 40 + (second - third + 40) % 40) * 9;
			System.out.println(degree);
		}
	}

}
