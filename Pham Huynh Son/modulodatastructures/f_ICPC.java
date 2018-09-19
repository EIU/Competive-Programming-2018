import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class f_ICPC {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		int n = reader.nextInt();
		int q = reader.nextInt();

		long[][] arr = new long[201][201];
		long[] arr1 = new long[200001];
		for (int i = 0; i < q; i++) {
			int t = reader.nextInt();
			if (t == 1) {
				int a = reader.nextInt();
				int b = reader.nextInt();
				int c = reader.nextInt();
				if (b < 201) {
					arr[a][b] += c;
				} else {
					int k = a;
					while (k < n + 1) {
						arr1[k] += c;
						k += b;
					}
				}
			} else {
				int d = reader.nextInt();
				long sum = 0;
				int j = 1, temp = 1;
				while (j < 201) {
					int num = d % j;
					sum += arr[num][j];
					j++;
				}

				sum += arr1[d];
				sb.append(sum + "\n");
			}
		}
		System.out.println(sb);
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
