import java.io.*;
import java.util.*;

class Main {
	static int[][] bee;//the layout of the bee hive
	static int[] eachrow;//number of cell in each row
	static int[] index;//index of the first cell of each row
	static int[] dx = { -1, -1, 0, 0, 1, 1 };//Coordinates of the 6 neighbor cells
	static int[] dy = { -1, 1, -2, 2, -1, 1 };//The bee hive and the cell of the hive are special, unlike 4-neighbor normal cell or 8-neighbor cell we usually meet, each cell of a bee hive has 6 neighbor cells
	static int ROW, COL;                      //So we only consider 6 cells

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int n = scan.nextInt(), K = scan.nextInt();
		ROW = 2 * n + 1;//added one more row on top and bottom for finding
		COL = 4 * n + 1;//added two more columns because there is an empty space between two cells
		bee = new int[ROW][COL];
		eachrow = new int[2 * n - 1];
		index = new int[2 * n - 1];
		int count = 0;
		for (int i = 0; i <= eachrow.length / 2; i++) {//With n = 3, the EachRow array should be {3,4,5,4,3} and the Index array should be {4,3,2,3,4}, we leave 2 extra columns for initial finding
			eachrow[i] = eachrow[eachrow.length - i - 1] = n + count;
			index[i] = index[index.length - 1 - i] = n - count + 1;
			count++;
		}
		for (int k = 0; k < K; k++) {//put each cell into its correct place
			int col = scan.nextInt();
			int row = 0;
			while (col > eachrow[row]) {
				col -= eachrow[row++];
			}
			bee[row + 1][index[row] + (col - 1) * 2] = 1;
		}
		int ans = 0,x1,y1;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0, ((n & 1) == 0 ? 0 : 1)));//somehow bee hives that have odd n start with 1 and 0 when even
		bee[0][((n & 1) == 0 ? 0 : 1)] = 2;
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			for (int i = 0; i < 6; i++) {
				x1 = cur.x + dx[i];
				y1 = cur.y + dy[i];
				if (valid(x1, y1)) {
					if (bee[x1][y1] == 1) {//every time we meet an occupied cell, increase the number of sides
						ans++;
					}
					if (bee[x1][y1] == 0) {
						bee[x1][y1] = 2;
						queue.add(new Pair(x1, y1));
					}
				}
			}
		}
		System.out.println(ans);
	}

	static boolean valid(int x, int y) {
		return (x >= 0 && x < ROW && y >= 0 && y < COL);
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
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

		public String nextLine() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (b != '\n' && b != '\r') {
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