import java.io.*;
import java.util.*;

public class Main {
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int test = scan.nextInt();
		while (test-- > 0) {
			int milk = scan.nextInt();
			int n = scan.nextInt();
			int m = n * (n - 1) / 2;
			int[] parents = new int[n];
			for (int i = 0; i < n; i++)
				parents[i] = -1;
			Edge[] edges = new Edge[m];
			for (int i = 0; i < m; i++) {
				int u = scan.nextInt();
				int v = scan.nextInt();
				int w = scan.nextInt();
				edges[i] = new Edge(w, u, v);
			}
			Arrays.sort(edges);
			for (Edge e : edges) {
				unite(parents, e);
			}
			System.out.println(((milk - sum - n >= 0)?"yes":"no"));
		}
	}

	public static int root(int[] p, int x) {
		return p[x] == -1 ? x : (p[x] = root(p, p[x]));
	}

	public static void unite(int[] p, Edge e) {
		int a = root(p, e.a);
		int b = root(p, e.b);
		if (a != b) {
			p[a] = b;
			sum += e.weight;
		}
	}

	static class Edge implements Comparable<Edge> {
		int weight;
		int a;
		int b;

		public Edge(int weight, int a, int b) {
			this.weight = weight;
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
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
