import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Knightsearch {
	static int i = 0;
	static boolean check = false;

	public static boolean find(int a, int b, char[] alice, char[][] upper, int n) {
		if (a >= 1 && a <= n && b >= 0 && b <= n - 1) {
			if (upper[a][b] == alice[i]) {
				return true;
			}
		}

		return false;
	}

	public static void dfs(int a, int b, char[] alice, char[][] upper, int n) {	
		if (find(a, b, alice, upper, n) == true) {		
			if (upper[a][b] == 'G') {
				check = true;
				return;
			}
			i++;
			dfs(a + 1, b + 2, alice, upper, n);
			dfs(a + 2, b + 1, alice, upper, n);
			dfs(a + 1, b - 2, alice, upper, n);
			dfs(a + 2, b - 1, alice, upper, n);
			dfs(a - 2, b + 1, alice, upper, n);		
			dfs(a - 1, b + 2, alice, upper, n);
			dfs(a - 2, b - 1, alice, upper, n);
			dfs(a - 1, b - 2, alice, upper, n);
		}
		
		
		
	}

	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		char[] alice = { 'I', 'C', 'P', 'C', 'A', 'S', 'I', 'A', 'S', 'G' };
		char[][] upper = new char[n + 1][n];
		int k = 0;
		for (int i = 1; i <= n; i++) {
			upper[i] = s.substring(k, k + n).toCharArray();
			k += n;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				char c = upper[i][j];
				dfs(i, j, alice, upper, n);
			}
		}
		if (check == true) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
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
