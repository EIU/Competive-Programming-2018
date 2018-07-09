import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class asciifigurerotation {
	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader(System.in);
		int first = 0;
		while (true) {
			int n = sc.nextInt();
			sc.nextLine();
			if (n == 0) {
				break;
			}
			if (first++ != 0) {
				System.out.println();
			}
			char[][] character = new char[n][n];
			char a;
			int len = 0;
			for (int i = 0; i < n; i++) {
				String s = sc.nextLine();
				if (len < s.length()) {
					len = s.length();
				}
				for (int j = s.length() - 1; j < 20; j++) {
					s += " ";
				}
				character[i] = s.toCharArray();
			}
			String[] ch = new String[n];
			for (int i = 0; i < len; i++) {
				for (int j = n - 1; j >= 0; j--) {
					a = character[j][i];
					if (a == '|') {
						ch[j] = "-";
					} else if (a == '-') {
						ch[j] = "|";
					} else if (a == ' ') {
						ch[j] = " ";
					} else {
						ch[j] = a + "";
					}
				}
				for (int j = 0; j < ch.length; j++) {
					if (ch[j] == " ") {
						ch[j] = "";
					} else {
						break;
					}
				}
				for (int j = n - 1; j >= 0; j--) {
					if (ch[j].equals(" ")) {
						System.out.print(" ");
					} else {
						System.out.print(ch[j]);
					}
				}
				System.out.println();
			}
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
