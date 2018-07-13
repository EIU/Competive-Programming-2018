import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main4 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int[] busNumber = new int[n];
		List<String> out = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			busNumber[i] = reader.nextInt();
		}

		Arrays.sort(busNumber);

		int start = 0, end = 0;
		for (; start < n ; start++) {
			int count = 0;
			for (end=start; end < n - 1; end++) {
				if (busNumber[end + 1] - busNumber[end] == 1) {
					count++;
				} else {
					break;
				}
			}
			if (count >=2&&start!=n-1) {
				out.add(busNumber[start] + "-" + busNumber[end]);
				start = end;
			} else
				out.add(busNumber[start] + "");  			
		}
		for(int i=0;i<out.size();i++) {
			System.out.println(out.get(i));
		}
		
	}

}