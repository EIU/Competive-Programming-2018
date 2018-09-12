import java.util.Arrays;
import java.util.Scanner;

public class Permuted {
	public static boolean find(int[] arr) {
		int m = arr[0] - arr[1];
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] - arr[i + 1] != m) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			if (find(arr) == false) {
				System.out.println("arithmetic");
				continue;
			}
			Arrays.sort(arr);
			if (find(arr) == true) {
				System.out.println("non-arithmetic");
				continue;
			}
			System.out.println("permuted arithmetic");
		}

	}

}
