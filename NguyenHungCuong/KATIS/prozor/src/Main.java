import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int row = scan.nextInt(), col = scan.nextInt(), k = scan.nextInt();
		char[][] map = scan.nm(row, col);
		int max = 0, x = -1, y = -1;
		for (int i = k - 1; i < row; i++) {
			for (int j = k - 1; j < col; j++) {
				int res = count(map, i, j, k);
				if (res > max) {
					max = res;
					x = i;
					y = j;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		res.append(max+"\n");
		for (int j = y; j >= y - k + 1; j--) {
			map[x][j] = '-';
			map[x-k+1][j] = '-';
		}
		for (int i = x;i>=x-k+1;i--) {
			map[i][y-k+1] = '|';
			map[i][y] = '|';
		}
		map[x-k+1][y-k+1] = '+';
		map[x-k+1][y] = '+';
		map[x][y-k+1] = '+';
		map[x][y] = '+';
		for (int i=0;i<row;i++) {
			for (int j=0;j<col;j++) {
				res.append(map[i][j]);
			}
			res.append("\n");
		}
		System.out.println(res);
	}

	static int count(char[][] map, int x, int y, int k) {
		int count = 0;
		if (x - k + 2 <= 0 || y - k + 2 <= 0)
			return -1;
		for (int i = x - k + 2; i < x; i++) {
			for (int j = y - k + 2; j < y; j++) {
				count += (map[i][j] == '*') ? 1 : 0;
			}

		}
		return count;
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

		public StringBuilder printIntArr(int[] ar, int n) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < n; i++) {
				res.append(ar[i] + " ");
			}
			res.append("\n");
			return res;
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

		public int[][] nmInt(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = nextInt();
				}
			}
			return map;
		}

		public long[][] nmLong(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = nextLong();
				}
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