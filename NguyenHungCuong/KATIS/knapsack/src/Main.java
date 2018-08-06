
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder res = new StringBuilder();

		while (scan.hasNext()) {
			double c = scan.nextDouble();
			int n = scan.nextInt();
			int[] value = new int[n+1];
			int[] wt = new int[ n + 1];
			for (int i = 0; i < n; i++) {
				value[i+1] = scan.nextInt();
				wt[i+1] = scan.nextInt();
			}
			ArrayList<Integer> k = knapsack(value, wt, (int)c, n);
			res.append(k.size()).append("\n");
			for (Integer i : k) {
				res.append(i).append(" ");
			}
			res.append("\n");
		}
		System.out.println(res);
	}

	static ArrayList<Integer> knapsack(int[] value, int[] wt, int c, int n) {
		int[][] k = new int[n + 1][c + 1];
		boolean[][] path = new boolean[n+1][c+1];
		for (int i = 1; i <= n; i++) {
			for (int w = 0; w <= c; w++) {
				k[i][w] = k[i-1][w];
				if (w >= wt[i] && value[i] + k[i-1][w - wt[i]] > k[i][w]) {
					k[i][w] = value[i] + k[i-1][w - wt[i]];
					path[i][w] = true;
				}
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		int index = c;
		for (int row = n;row > 0;row--) {
			if (path[row][index]) {
				res.add(row-1);
				index -= wt[row];
			}
		}
		res.sort((a,b)->a-b);
		return res;
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
