import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder res = new StringBuilder();
		int n;
		while ((n = scan.nextInt()) != 0) {
			String[] names = scan.nextLine().split(" ");
			double[][] map = new double[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = (i == j) ? 1 : -1;
				}
			}
			for (int k = 0; k < n - 1; k++) {
				String[] in = scan.nextLine().split(" ");
				int i = find(names, in[0]), j = find(names, in[3]);
				map[i][j] = Double.parseDouble(in[2]);
				map[j][i] = 1 / map[i][j];
			}
		
			for (int e = 0; e < n; e++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == 1 || map[i][j] == -1)
							continue;
						for (int k = 0; k < n; k++) {
							if (map[j][k] >= 1 || map[j][k] == -1)
								continue;
							if (map[i][k] == -1) {
								map[i][k] = map[i][j] * map[j][k];
								map[k][i] = 1 / map[i][k];
							}
						}
					}
				}
			}
			int biggest = -1;
			for (int i=0;i<n;i++) {
				boolean found = true;
				for (int j=0;j<n;j++) {
					found = found && (map[i][j] >= 1);
				}
				if (found) biggest = i;
			}
			res.append("1"+names[biggest]);
			ArrayList<Weight> w = new ArrayList<>();
			for (int j=0;j<n;j++) {
				if (j != biggest) {
					w.add(new Weight(names[j], (int)Math.round(map[biggest][j])));
				}
			}
			w.sort((a,b)->a.conversion-b.conversion);
			for (Weight i : w) {
				res.append(" = "+i.conversion+i.name);
			}
			res.append("\n");
		}
		System.out.println(res);
	}

	static int find(String[] names, String name) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(name))
				return i;
		}
		return -1;
	}
	static class Weight{
		public String name;
		public int conversion;
		public Weight(String name, int conversion) {
			this.name = name;
			this.conversion = conversion;
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