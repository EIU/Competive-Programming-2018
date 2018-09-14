import java.io.*;
import java.util.*;

public class cuchitunnels {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = reader.nextInt();
		}
		boolean f = true;
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (j == i) {
				break;
			}
			if (list[j] > 0) {
				list[j]--;
				list[i]--;
			} else {
				j++;
				i--;
			}
		}
		for (int i = 0; i < n; i++) {
			if (list[i] != 0)
				f = false;
		}
		System.out.println(f ? "YES" : "NO");

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