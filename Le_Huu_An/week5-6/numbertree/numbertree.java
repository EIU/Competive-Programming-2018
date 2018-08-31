import java.awt.Label;
import java.io.*;
import java.util.*;

public class numbertree {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		String line = reader.nextLine();
		String[] s = line.split(" ");
		String sequense = "";
		int count = 1;
		int H = Integer.parseInt(s[0]);
		int source = (1 << H + 1);
		if (s.length == 2) {
			sequense = s[1];
		} else {
			System.out.println(source - 1);
			return;
		}
		for (int i = 0; i < sequense.length(); ++i) {
			char charS = sequense.charAt(i);
			count <<= 1;
			if (charS == 'R') {
				count += 1;
			}
		}
		source -= count;
		System.out.println(source);

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