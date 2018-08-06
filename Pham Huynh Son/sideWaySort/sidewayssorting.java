import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class sidewayssorting {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while (true) {
			StringBuilder strBuilder = new StringBuilder();
			int n = input.nextInt();
			int m = input.nextInt();
			if (n == 0 && m == 0)
				return;
			String[] line = new String[m];
			for (int i = 0; i < m; i++) {
				line[i] = "";
			}
			for (int i = 0; i < n; i++) {
				String str = input.next();
				for (int j = 0; j < m; j++) {
					line[j] += str.charAt(j);
				}
			}
			Arrays.sort(line, new Comparator<String>() {
				public int compare(String s1, String s2) {
					s1 = s1.toUpperCase();
					s2 = s2.toUpperCase();
					return s1.compareTo(s2);
				}
			});
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					strBuilder.append(line[j].charAt(i));
				}
				strBuilder.append("\n");
			}
			System.out.println(strBuilder);

		}
	}

}
