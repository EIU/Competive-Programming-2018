import java.io.*;
import java.util.*;

class EightsQueens {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			String s = reader.nextLine();
			if (s.indexOf("*") != s.lastIndexOf("*") || s.length() > 8) {
				System.out.println("invalid");
				return;
			}
			int j = s.indexOf("*");
			col.add(i);
			row.add(j);
		}
		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 8; j++) {
				if (row.get(i) == row.get(j) || row.get(j) == -1
						|| Math.abs(row.get(i) - row.get(j)) == Math.abs(col.get(i) - col.get(j))) {
					System.out.println("invalid");
					return;
				}
			}
		}
		System.out.println("valid");
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