import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Bus_Numbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int i = 0;
		Arrays.sort(arr);
		while (i < n - 1) {
			int temp = i;
			int j = i + 1;
			if (arr[j] - arr[temp] == 1 && j < n - 1 && arr[j + 1] - arr[j] == 1) {
				{
					while (arr[j] - arr[temp] == 1) {
						temp++;
						j = temp + 1;
						if (temp == arr.length - 1) {
							break;
						}
					}
					System.out.println(arr[i] + "-" + arr[temp]);
				}
			} else {
				System.out.println(arr[temp]);
			}
			if (j == n - 1) {
				System.out.println(arr[j]);
			}
			i = temp;
			++i;
		}

	}
}
