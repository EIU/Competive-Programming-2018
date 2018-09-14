package Week2_3;

import java.io.*;
import java.util.*;

class Minimum_Scalar_Product {

	public static void main(String[] args) {

		InputReader reader = new InputReader(System.in);
		int nCase = reader.nextInt();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < nCase; ++i) {
			long result = 0;
			int n = reader.nextInt();
			List<Long> arr = new ArrayList<>();
			List<Long> arr2 = new ArrayList<>();
			for (int j = 0; j < n; ++j) {
				arr.add(reader.nextLong());
			}
			for (int j = 0; j < n; ++j) {
				arr2.add(reader.nextLong());
			}
			Collections.sort(arr);
			Collections.sort(arr2, Collections.reverseOrder());
			for (int j = 0; j < n; ++j) {
				result += (arr.get(j) * arr2.get(j));
			}
			builder.append("Case " + "#" + (i + 1) + ": " + result + "\n");
		}
		System.out.println(builder);
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