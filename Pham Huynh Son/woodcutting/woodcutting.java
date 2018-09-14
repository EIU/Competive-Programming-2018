import java.io.*;
import java.util.*;

public class woodcutting {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int t = reader.nextInt();
		while (t > 0) {
			int n = reader.nextInt();
			int[] list = new int[n];
			double time = 0, max = 0;
			double avgT = 0;
			for (int i = 0; i < n; i++) {
				int c = reader.nextInt();
				int timeC = 0;
				for (int j = 0; j < c; j++) {
					timeC += reader.nextInt();
				}
				list[i] = timeC;
				// max = max > timeC ? max : timeC;
				// time += timeC;
			}
			Arrays.sort(list);
			if (n > 1) {
				for (int i = 0; i < n - 1; i++) {
					list[i + 1] += list[i];
				}
			}
			for (int i = 0; i < n; i++) {
				time += list[i];
			}
			avgT = time / n;
			strBuilder.append(avgT + "\n");
			t--;
		}
		System.out.println(strBuilder);
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