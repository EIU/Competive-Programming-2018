import java.io.*;
import java.util.*;

public class SidewaysSorting {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		while (true) {
			int r = reader.nextInt();
			int c = reader.nextInt();
			if (r == 0 && c == 0) {
				break;
			}
			String[] arr = new String[c];
			for (int i = 0; i < c; ++i) {
				arr[i] = "";
			}
			for (int j = 0; j < r; j++) {
				String line = reader.next();
				for (int i = 0; i < c; i++) {
					arr[i] += line.charAt(i);
				}
			}
			Arrays.sort(arr, new Comparator<String>() {
				public int compare(final String entry1, final String entry2) {
					final String field1 = entry1.toUpperCase();
					final String field2 = entry2.toUpperCase();
					return field1.compareTo(field2);
				}
			});
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(arr[j].charAt(i));
				}
				System.out.println();
			}
			System.out.println();
		}
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