import java.util.*;

public class polynomial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder strBuilder = new StringBuilder();
		String str = sc.next();
		char[] p = str.to;
		int k = 0;
		while (k < p.length) {
			int s = p.length;
			int count = s - 2;
			for (int i = 1; count < s; i++) {
				String temp = p[i];
				if (i == s - 1) {
					i = 1;					
					count++;
				} else {
					p[i] = p[1 + i];
					p[i + 1] = temp;
					for (int j = 0; j < s; j++) {
						strBuilder.append(p[j]);
					}
					strBuilder.append("\n");
				}
			}
			String temp = p[0];
			p[0] = p[k];
			p[k] = temp;
			k++;
		}
		System.out.println(strBuilder);
	}
}
