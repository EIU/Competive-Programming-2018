import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);

		int s = reader.nextInt();
		int c = reader.nextInt();
		int k = reader.nextInt();
		int[] a = new int[s];
		for (int i = 0; i < s; i++) {
			a[i] = reader.nextInt();
		}
		Arrays.sort(a);
		int machine = 1;
		int temp = 1;
		int index=0;

		for (int i = 1; i < s; i++) {
			if (temp<c && a[i]-a[index]<=k) {
				temp++;
			}
			else {
				machine++;
				temp=1;
				index=i;
			}		

		}
		System.out.println(machine);

	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}

				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
