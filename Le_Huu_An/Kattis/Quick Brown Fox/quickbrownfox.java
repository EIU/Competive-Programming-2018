package Week2_3;

import java.io.*;
import java.util.*;

public class quickbrownfox {

	public static void main(String[] args) throws IOException {

		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			StringBuilder missing = new StringBuilder();
			HashSet<Character> hs = new HashSet<Character>();
			String phrase = reader.nextLine().toLowerCase();
			for (int j = 0; j < phrase.length(); ++j) {
				hs.add(phrase.charAt(j));
			}
			for (char k = 'a'; k <= 'z'; ++k) {
				if (!hs.contains(k)) {
					missing.append(k);
				}
			}
			builder.append(missing.length() == 0 ? "pangram" + "\n" : "missing" + " " + missing + "\n");
		}
		System.out.print(builder);
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