import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wood {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				int time = sc.nextInt();
				int total = 0;
				for (int k = 0; k < time; k++) {
					total += sc.nextInt();				
				}	
				arr.add(total);
			}
			Collections.sort(arr);
			int sum = 0;
			long value = 0;
			for (int j = 0; j < arr.size(); j++) {
				sum += arr.get(j);
				value += sum;
			}
			double avg = value / ((double) arr.size());
			System.out.printf("%.7f", avg);
			System.out.println();
		}
	}

}
