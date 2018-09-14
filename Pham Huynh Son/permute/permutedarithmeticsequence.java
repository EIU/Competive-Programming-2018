import java.io.*;
import java.util.*;

public class permutedarithmeticsequence {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int t = reader.nextInt();
		while (t > 0) {
			t--;
			int n = reader.nextInt();
			int[] list = new int[n];
			for (int i = 0; i < n; i++) {
				list[i] = reader.nextInt();
			}
			int temp = list[list.length - 1] - list[list.length - 2];
			int f = 0;
			for (int i = 0; i < n - 1; i++) {
				int v = list[i + 1] - list[i];
				if (v != temp) {
					f = 1;
					break;
				}
			}
			if (f == 1) {
				Arrays.sort(list);
				temp = list[list.length - 1] - list[list.length - 2];
				for (int i = 0; i < n - 1; i++) {
					int v = list[i + 1] - list[i];
					if (v != temp) {
						f = 2;
						break;
					}
				}
			}
			strBuilder.append(f == 0 ? "arithmetic" : f == 1 ? "permuted arithmetic" : "non-arithmetic").append("\n");
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
