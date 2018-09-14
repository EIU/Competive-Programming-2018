import java.util.ArrayList;
import java.util.Scanner;

public class Phone_List {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> List = new ArrayList<Integer>();
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scan.nextInt();
				List.add(arr[j]);
			}
			List.sort((Integer num1, Integer num2) -> {
				int a = (int) (num1 - num2);
				if (a != 0)
					return a;
				return a;
			});
			String rs = "";
			for (int k = 0; k < List.size() - 1; k++) {
				if (List.get(k + 1).toString().startsWith(List.get(k).toString())) {
					rs = "NO";
					break;
				} else {
					rs = "YES";
				}
			}
			System.out.println(rs);
			List.clear();
		}
	}
}