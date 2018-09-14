import java.io.*;
import java.util.*;

public class tutorial {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder strBuilder = new StringBuilder();
		long[] h = trim();
		while (true) {
			int n = reader.nextInt();
			if (n == 0)
				break;
			strBuilder.append(h[n] % 10 + "\n");
		}
		System.out.println(strBuilder);
	}

	static long[] trim() {
		long m = 1;
		long[] p = new long[1000000 + 1];
		for (int i = 1; i < 1000000 + 1; i++) {

			m = m * i;
			while (m > 0) {
				if (m % 10 != 0) {
					m %= 10000000;
					break;
				}
				m /= 10;
			}
			p[i] = m;
		}
		return p;
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