
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);

		String sample = "this is a long string  it's created by me because I like it";
		String[] arr = sample.split("\\s+");
		System.out.println(sample.matches("\\w.*"));
		System.out.println(arr.length);
		for (String i : arr) {
			System.out.println(i);
		}
	}

	static double sumArray(int[] n, InputReader scan) {
		double sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
		}
		return sum;
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
