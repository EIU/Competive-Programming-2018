
import java.io.*;
import java.util.*;

class Main {
	static int[] rowNum = {-1, 0, 1, 0 };
	static int[] colNum = { 0, 1, 0, -1 };
	static int row;
	static int col;

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder result = new StringBuilder();
		int test = 1;
		while (scan.hasNext()) {
			row = scan.nextInt();
			col = scan.nextInt();
			char[][] map = new char[row][];
			for (int i = 0; i < row; i++) {
				map[i] = scan.next().toCharArray();
			}
			int count = 0;
			for (int i=0;i<row;i++) {
				for (int j=0;j<col;j++) {
					if (map[i][j] == '-') {
						count++;
						dfs(i,j,map);
					}
				}
			}
			result.append("Case ").append(test++).append(": ").append(count).append("\n");
		}
		System.out.println(result);
	}

	static boolean isStar(int u, int v, char[][] map) {
		return (u >= 0 && u < row && v >= 0 && v < col && map[u][v] == '-');
	}

	static void dfs(int u, int v, char[][] map) {
		map[u][v] = '#';
		for (int i=0;i<4;i++) {
			if (isStar(u + rowNum[i], v + colNum[i], map)) {
				dfs(u + rowNum[i], v + colNum[i], map);
			}
		}
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
