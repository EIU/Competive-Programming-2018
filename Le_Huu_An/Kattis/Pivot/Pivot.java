import java.io.*;
import java.util.*;

public class Pivot {

	public static void main(String[] args) {

		InputReader reader = new InputReader(System.in);
		int count = 0;
		int n = reader.nextInt();
		int[] arr = new int[n];
		int[] maxNumbers = new int[n];
		int[] minNumbers = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}
		int min = arr[n - 1];
		int max = arr[0];
		maxNumbers[0] = arr[0];
		minNumbers[n - 1] = arr[n - 1];
		for (int i = 0; i < n - 1; i++) {
			max = Math.max(max, arr[i + 1]);
			maxNumbers[i + 1] = max;
		}
		for (int i = n - 1; i >= 0; i--) {
			min = Math.min(min, arr[i - 1]);
			minNumbers[i] = min;
		}
		for (int i = 0; i < n; i++) {
			if (minNumbers[i] == maxNumbers[i]) {
				count++;
			}
		}

		System.out.println(count);
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