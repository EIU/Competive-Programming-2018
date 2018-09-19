import java.io.*;
import java.util.*;

class Main {
	static int time = 0;
	static int count = 0;
	static boolean[][] bridge;
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int n = scan.nextInt();
		int m = scan.nextInt();
		bridge = new boolean[n][n];
		Vertex[] list = readGraph(n, m, scan);
		bridge(list[0]);
		dfs(list[0]);
		System.out.println(count);
	}
	static void dfs(Vertex u) {
		u.vis = true;
		count++;
		for (Vertex v : u.neighbors) {
			if (!v.vis && !bridge[u.id][v.id]) {
				dfs(v);
			}
		}
	}
	
	static void bridge(Vertex u) {
		u.visited = true;
		u.low = u.disc = ++time;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				v.father = u;
				bridge(v);
				u.low = Math.min(u.low, v.low);
				if (v.low > u.disc) {
					bridge[u.id][v.id] = true;
				}
			} else if (v != u.father) {
				u.low = Math.min(u.low, v.disc);
			}
		}
	}

	public static Vertex[] readGraph(int nVertices, int nEdges, InputReader scan) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		return vertices;
	}

	static class Vertex {

		public int id;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public boolean vis = false;
		public Vertex father = null;
		public int low;
		public int disc;

		public Vertex(int id) {
			this.id = id;
		}

		public int getDeg() {
			return this.neighbors.size();
		}

		public void addNeighbor(Vertex child) {
			neighbors.add(child);
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