import java.io.*;
import java.util.*;

public class evenUp {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		List<Integer> list = new ArrayList<>();
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (list.isEmpty()) {
				list.add(reader.nextInt() & 1);
			} else {
				temp = list.get(list.size() - 1);
				int v = reader.nextInt() & 1;
				if (v == temp) {
					list.remove(list.size() - 1);
				} else {
					list.add(v);
				}
			}
		}
		System.out.println(list.size() != 0 ? list.size() : "0");
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
