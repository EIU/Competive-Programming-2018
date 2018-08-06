import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class minimum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			ArrayList<Long> vector1 = new ArrayList<>();
			ArrayList<Long> vector2 = new ArrayList<>();
			for (int j = 0; j < a; j++) {
				long vec1=sc.nextLong();			
				vector1.add(vec1);
				
			}
			for(int j = 0; j < a; j++) {
				long vec2=sc.nextLong();			
				vector2.add(vec2);
			}
			Collections.sort(vector1);
			Collections.sort(vector2);
			Collections.reverse(vector2);
			long sum = 0;
			for (int k = 0; k < a; k++) {
				sum = sum + (vector1.get(k) * vector2.get(k));
			}
			System.out.println("Case #" + i + ":" + " " + (sum));
		}
	}
}