import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		InputReader scan = new InputReader();
		int n = scan.nextInt();
		int start = scan.nextInt();
		Vertex[] list = readGraph(n, scan);
		StringBuilder res = new StringBuilder();
		dfs(list[start], new Stack<>());
		for (Vertex u : list) {
			if (u.isLeave && u.isOverLoad) {
				res.append(u.id + " ");
			}
		}
		System.out.println(res);
	}

	static long dfs(Vertex u, Stack<Vertex> stack) {
		u.visited = true;
		stack.add(u);
		if (u.isLeave) {
			return u.consumption;
		}
		for (Edge e : u.neighbors) {
			if (!e.ep.visited) {
				long res = dfs(e.ep, stack);
				u.sum += res;
				if (e.weight >= res * 1.1)
					continue;
				Vertex t;
				do {
					t = stack.pop();
					t.isOverLoad = true;
				} while (t != e.ep);
			}
		}
		return u.sum;		
	}

	public static Vertex[] readGraph(int nVertices, InputReader scan) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nVertices - 1; ++i) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			int w = scan.nextInt();
			vertices[u].addNeighbor(new Edge(vertices[v], w));
			vertices[v].addNeighbor(new Edge(vertices[u], w));
		}
		while (scan.hasNext()) {
			int index = scan.nextInt();
			vertices[index].consumption = scan.nextLong();
			vertices[index].isLeave = true;
		}
		return vertices;
	}

	static class Edge {
		public Vertex ep = null;
		public int weight = 0;

		public Edge(Vertex ep, int weight) {
			this.ep = ep;
			this.weight = weight;
		}
	}

	static class Vertex {

		public int id;
		public List<Edge> neighbors = new ArrayList<>();
		public boolean visited = false;
		public long consumption = 0;
		public boolean isLeave = false;
		public boolean isOverLoad = false;
		public long sum = 0;

		public Vertex(int id) {
			this.id = id;
		}

		public int getDeg() {
			return this.neighbors.size();
		}

		public void addNeighbor(Edge child) {
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
