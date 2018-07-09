import java.io.*;
import java.util.*;

public class Figure_Rotattion {

	public static void main(String[] args) throws IOException {

		InputReader reader = new InputReader(System.in);
		List<Character> list = new ArrayList<Character>();
		boolean firstline = true;
		while (true) {
			int n = reader.nextInt();
			String line = "";
			char[][] Character = new char[n][n];
			int width2 = 0;
			int width = 0;
			if (n == 0) {
				break;
			}
			for (int i = 0; i < n; i++) {
				line = reader.nextLine();
				line.trim();
				width = Math.max(width2, line.length());
				for (int j = 0; j < width; j++) {
					Character[i][j] = line.charAt(j);
				}
			}

			if (firstline = false) {
				System.out.println("");
			}
			for (int j = 0; j < width + 2; j++) {
				for (int i = 0; i < n; i++) {
					if (Character[i][j] == '-') {
						list.add('|');
					} else if (Character[i][j] == '|') {
						list.add('-');
					} else {
						list.add(Character[i][j]);
					}
				}
				list.toString().trim();
				for (int i = list.size() - 1; i >= 0; i--) {
					System.out.print(list.get(i));
				}
				System.out.println("");
				list.clear();
			}
		}
	}

	static List<Character> TrimRight(List List) {
		for (int i = List.size() - 1; i >= 0; i--) {
			if (List.get(i).equals(" "))
				List.remove(i);
			else
				return List;
		}
		return List;
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