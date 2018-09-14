import java.util.Arrays;
import java.util.Scanner;

public class Birds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int distance = sc.nextInt();
		int num = sc.nextInt();
		int[] position = new int[num];
		for (int i = 0; i < num; i++) {
			position[i] = sc.nextInt();
		}
		Arrays.sort(position);
		int count = 0;
		int sum = 6;
		for (int i = 0; i < num; i++) {
			while (true) {
				if (position[i] - sum >= distance) {
					sum += distance;
					count++;
				} else {
					sum = position[i] + distance;
					break;
				}
			}
		}
		while (sum <= length - 6) {
			count++;
			sum += distance;
		}
		System.out.println(count);
	}

}
