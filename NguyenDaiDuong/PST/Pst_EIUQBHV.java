import java.io.*;
import java.util.*;

class Permutation {
	static StringBuilder builder = new StringBuilder();
	public static Set<String> set = new TreeSet<String>();

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		String str = reader.next();
		permutation("", str);
		for (String s : set) {
			builder.append(s + "\n");
		}
		System.out.print(set.size() + "\n" + builder);
	}

	public static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			set.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
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