
import java.io.*;
import java.util.*;

class Main {
	static boolean[] startBox;
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder result = new StringBuilder();
		int n;
		while ((n = scan.nextInt()) != 0) {
			startBox = new boolean[n];
			Vertex[] list = readGraph(n, scan);
			int start = 0;
			for (;start<n;start++) {
				if (!startBox[start]) {
					break;
				}
			}
			long[] res = dfs(list[start]);
			result.append(res[2]).append("\n");
		}
		System.out.print(result);
	}

	static long[] dfs(Vertex u) {
		long[] res = new long[3];
		res[0] = u.marble;
		res[1] = 1;

		for (Vertex v : u.neighbors) {
			long[] child = dfs(v);
			res[0] += child[0];
			res[1] += child[1];
			res[2] += child[2];
		}
		res[2] += Math.abs(res[0] - res[1]);

		return res;
	}



	public static Vertex[] readGraph(int nVertices, InputReader scan) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i + 1);
		}
		for (int i = 0; i < nVertices; i++) {
			scan.nextInt();
			vertices[i].marble = scan.nextInt();
			for (int j = scan.nextInt(); j > 0; j--) {
				int v = scan.nextInt();
				startBox[v-1] = true;
				vertices[i].addNeighbor(vertices[v - 1]);
			}
		}

		return vertices;
	}

	static class Vertex {

		public int id;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public int marble;

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
