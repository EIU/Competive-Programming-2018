import java.io.*;
import java.util.*;

class Main {
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int x;
	static int y;
	static boolean[][] vis;

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		y = scan.nextInt();
		x = scan.nextInt();
		map = scan.nmInt(x, y);
		vis = new boolean[x][y];
		int ans = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				ans += flood(i, j);
			}
		}
		System.out.println(ans);
	}

	static int flood(int x, int y) {
		if (vis[x][y])
			return 0;
		vis[x][y] = true;
		boolean ok = true;
		int ans = 1;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(x, y, map[x][y]));
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			int i = cur.x;
			int j = cur.y;
			for (int k = 0; k < 4; k++) {
				int a = i + dx[k];
				int b = j + dy[k];
				if (!valid(a, b))
					continue;
				if (map[a][b] < map[i][j])
					ok = false;
				else if (map[a][b] == map[i][j] && !vis[a][b]) {
					queue.add(new Pair(a,b,map[a][b]));
					vis[a][b] = true;
					ans++;
				}
			}
		}
		return ok ? ans : 0;
	}

	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int height;

		public Pair(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public int compareTo(Pair other) {
			return this.height - other.height;
		}
	}

	static boolean valid(int a, int b) {
		return (a >= 0 && a < x && b >= 0 && b < y);
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