import java.util.Scanner;

public class oddities {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int n = reader.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = reader.nextInt();
			int result = temp < 0 ? (temp * -1) & 1 : temp & 1;
			strBuilder.append(result == 1 ? temp + " is odd\n" : temp + " is even\n");
		}
		System.out.println(strBuilder);
	}
}
