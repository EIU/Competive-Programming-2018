import java.io.*;
import java.util.*;

public class Main {
	static int maxN = 1001;

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder ans = new StringBuilder();
		int test = scan.nextInt();
		while (test-- > 0) {
			int n = scan.nextInt();
			int[] val = new int[n + 1];
			int[][] dp = new int[n + 1][maxN];
			for (int[] ar : dp) {
				Arrays.fill(ar, -1);
			}
			dp[0][0] = 0;
			for (int i = 1; i <= n; i++) {
				val[i] = scan.nextInt();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < maxN; j++) {
					if (dp[i][j] != -1) {
						int up = j - val[i + 1];
						int down = j + val[i + 1];
						if (up >= 0) {
							if (dp[i + 1][up] == -1) {
								dp[i + 1][up] = Math.max(up, dp[i][j]);
							} else
								dp[i + 1][up] = Math.min(dp[i + 1][up], dp[i][j]);
						}
						if (down < maxN) {
							if (dp[i + 1][down] == -1) {
								dp[i + 1][down] = Math.max(dp[i][j], down);
							} else
								dp[i + 1][down] = Math.min(dp[i + 1][down], Math.max(dp[i][j], down));
						}
					}
				}
			}
			StringBuilder res = new StringBuilder();
			if (dp[n][0] == -1) {
				ans.append("IMPOSSIBLE\n");
			} else {
				int i = n, j = 0;
				while (i != 0) {
					int up = j - val[i] < 0 || dp[i - 1][j - val[i]] == -1 ? Integer.MAX_VALUE : dp[i - 1][j - val[i]];
					int down = j + val[i] > maxN || dp[i - 1][j + val[i]] == -1 ? Integer.MAX_VALUE
							: dp[i - 1][j + val[i]];
					if (up < down) {
						res.append("U");
						j -= val[i];
					} else {
						res.append("D");
						j += val[i];
					}
					i--;
				}
				ans.append(res.reverse() + "\n");
			}
		}
		System.out.println(ans);
	}

	static class InputReader {

		InputStream is = System.in;
		byte[] inbuf = new byte[1 << 23];
		int lenbuf = 0, ptrbuf = 0;

		public InputReader() throws IOException {
			lenbuf = is.read(inbuf);
		}

		public int readByte() {

			if (ptrbuf >= lenbuf) {
				return -1;
			}

			return inbuf[ptrbuf++];
		}

		public boolean hasNext() {
			int t = skip();

			if (t == -1) {
				return false;
			}
			ptrbuf--;
			return true;
		}

		public boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		public int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public char nextChar() {
			return (char) skip();
		}

		public String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public char[] ns(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		public char[][] nm(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++) {
				map[i] = ns(m);
			}
			return map;
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		public long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

	}
}