import java.io.*;
import java.util.*;

public class EIUCOL {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder builder = new StringBuilder();
		int prof = reader.nextInt();
		int p1 = reader.nextInt();
		int p2 = reader.nextInt();
		int p3 = reader.nextInt();
		int[] list = new int[prof * 10];
		for (int i = 0; i <= prof; i++) {
			if (list[i] != 0 || i == 0) {
				list[i + p1] = list[i + p1] > list[i] + 1 ? list[i + p1] : list[i] + 1;
				list[i + p2] = list[i + p2] > list[i] + 1 ? list[i + p2] : list[i] + 1;
				list[i + p3] = list[i + p3] > list[i] + 1 ? list[i + p3] : list[i] + 1;
			}
		}
		System.out.println(list[prof]);
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
