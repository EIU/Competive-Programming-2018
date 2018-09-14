import java.io.*;
import java.util.*;

class CHATCAY {
	static InputReader reader;

	public static void main(String[] args) throws IOException {
		reader = new InputReader();
		StringBuilder builder = new StringBuilder();
		int n = reader.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextLong();
			if (arr[i] < 0) {
				arr[i] = 0;
			}
		}
		builder.append(find(arr, n));
		System.out.println(builder);
	}

	static long find(long tree[], int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return tree[0];
		if (n == 2)
			return Math.max(tree[0], tree[1]);
		if (n == 3)
			return Math.max(Math.max(tree[0], tree[1]), tree[2]);
		long[] dp = new long[n];

		dp[0] = tree[0];
		dp[1] = Math.max(tree[0], tree[1]);
		dp[2] = Math.max(Math.max(tree[0], tree[1]), tree[2]);
		for (int i = 3; i < n; i++)
			dp[i] = Math.max(Math.max(tree[i] + dp[i - 3], dp[i - 2]), dp[i - 1]);
		return dp[n - 1];
	}

	static class InputReader {

		InputStream is = System.in;
		byte[] inbuf = new byte[1 << 24];
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