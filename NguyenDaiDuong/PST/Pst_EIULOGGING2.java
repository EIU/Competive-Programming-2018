import java.io.*;
import java.util.*;

class EIULOGGING2_Chat_Cay {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int number = reader.nextInt();
		long a = 0, b = 0, c = 0, temp = 0;
		for (int i = 1; i <= number; i++) {
			temp = (temp = reader.nextLong()) < 0 ? 0 : temp;
			if (i % 3 == 1) {
				b = i == 4 ? Math.max(a < 0 ? 0 : a, b) : b;
				a += temp;
				a = (a = Math.max(Math.max(a, b), c)) < 0 ? 0 : a;
			} else if (i % 3 == 2) {
				c = i == 5 || i == 2 ? Math.max(b < 0 ? 0 : b, c) : c;
				b += temp;
				b = (b = Math.max(Math.max(a, b), c)) < 0 ? 0 : b;
			} else {
				c += temp;
				c = (c = Math.max(Math.max(a, b), c)) < 0 ? 0 : c;
			}
		}
		System.out.print(Math.max(Math.max(a, b), c));

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
