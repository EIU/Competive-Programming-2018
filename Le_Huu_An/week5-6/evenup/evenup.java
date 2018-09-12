package Week2_3;

import java.io.*;
import java.util.*;

public class evenup {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		int n = reader.nextInt();
		Stack<Integer> s = new Stack<>();
		int result = n;
		for (int i = 0; i < n; ++i) {
			int curNum = reader.nextInt();
			if (s.isEmpty()) {
				s.push(curNum);
			} else {
				if ((curNum + s.peek()) % 2 == 0) {
					s.pop();
					result -= 2;
				} else {
					s.push(curNum);
				}
			}
		}
		builder.append(result);
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