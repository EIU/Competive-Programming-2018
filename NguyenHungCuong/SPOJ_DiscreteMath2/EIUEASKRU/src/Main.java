import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int n = scan.nextInt();
		int m = scan.nextInt();
		PriorityQueue<Edge> p = new PriorityQueue<>();
		Vertex[] vertices = new Vertex[n];
		for (int i = 0; i < n; i++) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < m; i++) {
			int u = scan.nextInt() - 1;
			int v = scan.nextInt() - 1;
			int w = scan.nextInt();
			vertices[u].addEdge(new Edge(w, vertices[v]));
			vertices[v].addEdge(new Edge(w, vertices[u]));
		}
		long max = 0;
		for (int i = 0; i < n; i++) {
			if (!vertices[i].visited) {
				vertices[i].visited = true;
				long sum = 0;
				int numVertice = 1;
				p.addAll(vertices[i].edgeList);
				List<Edge> used = new ArrayList<Edge>();
				while (!p.isEmpty()) {
					Edge maxEdge = p.poll();
					if (!vertices[maxEdge.ep.id].visited) {
						used.add(maxEdge);
						sum += maxEdge.weight;
						p.addAll(vertices[maxEdge.ep.id].edgeList);
						vertices[maxEdge.ep.id].visited = true;
						numVertice++;
					}
				}
				if (used.size() == numVertice - 1) {
					max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
	}

	static class Vertex {
		public int id;
		public boolean visited = false;
		ArrayList<Edge> edgeList = new ArrayList<>();

		public Vertex(int id) {
			this.id = id;
		}

		public void addEdge(Edge child) {
			this.edgeList.add(child);
		}
	}

	static class Edge implements Comparable<Edge> {
		int weight;
		Vertex ep;

		public Edge(int weight, Vertex ep) {
			this.weight = weight;
			this.ep = ep;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
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
