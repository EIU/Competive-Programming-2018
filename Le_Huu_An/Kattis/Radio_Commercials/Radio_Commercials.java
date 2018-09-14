package Week2_3;

import java.io.*;
import java.util.*;

public class Radio_Commercials {

	public static void main(String[] args) throws IOException {

		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int p = reader.nextInt();
		StringBuilder builder = new StringBuilder();
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; ++i) {
			int br = reader.nextInt();
			sum += br - p;
			sum = sum < 0 ? 0 : sum;
			max = max >= sum ? max : sum;
		}

		System.out.println(max);
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