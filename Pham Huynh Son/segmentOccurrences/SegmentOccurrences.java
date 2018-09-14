import java.util.Scanner;

public class SegmentOccurrences {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int q = reader.nextInt();

		String s = reader.next();
		String subS = reader.next();

		for (int i = 0; i < q; i++) {
			int count = 0;
			int l = reader.nextInt();
			int r = reader.nextInt();

			String temp = s.substring(l-1, r);
			while (temp.contains(subS)) {
				int k = temp.indexOf(subS)+subS.length();
				temp = temp.substring(k, temp.length());
				count ++;
			}
			strBuilder.append(count+"\n");
		}
		System.out.println(strBuilder);
	}
}
