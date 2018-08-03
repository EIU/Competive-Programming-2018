import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder result = new StringBuilder();
		int n;
		int m;
		while ((n = scan.nextInt()) + (m = scan.nextInt()) != 0) {
			PriorityQueue<Edge> p = new PriorityQueue<>();
			Vertex[] vertices = new Vertex[n];
			for (int i = 0; i < n; i++) {
				vertices[i] = new Vertex(i);
			}
			for (int i = 0; i < m; i++) {
				int u = scan.nextInt();
				int v = scan.nextInt();
				int w = scan.nextInt();
				vertices[u].addEdge(new Edge(w, vertices[u], vertices[v]));
				vertices[v].addEdge(new Edge(w, vertices[v], vertices[u]));
			}
			boolean[] added = new boolean[n];
			added[0] = true;
			long sum = 0;
			p.addAll(vertices[0].edgeList);
			List<Edge> used = new ArrayList<Edge>();
			while (!p.isEmpty()) {
				Edge minEdge = p.poll();
				if (!added[minEdge.ep1.id] || !added[minEdge.ep2.id]) {
					used.add(minEdge);
					sum += minEdge.weight;
					p.addAll((added[minEdge.ep1.id]) ? vertices[minEdge.ep2.id].edgeList
							: vertices[minEdge.ep1.id].edgeList);
					if (!added[minEdge.ep2.id]) {
						added[minEdge.ep2.id] = true;
					}
					added[minEdge.ep1.id] = true;
				}
			}
			if (used.size() != n - 1) {
				result.append("Impossible\n");
			} else {
				result.append(sum).append("\n");
				used.sort((a, b) -> {
					int res = Math.min(a.ep1.id, a.ep2.id) - Math.min(b.ep1.id, b.ep2.id);
					if (res == 0) {
						res = Math.max(a.ep1.id, a.ep2.id) - Math.max(b.ep1.id, b.ep2.id);
					}
					return res;
				});
				for (Edge i : used) {
					result.append(Math.min(i.ep1.id, i.ep2.id)).append(" ").append(Math.max(i.ep1.id, i.ep2.id))
							.append("\n");
				}
			}
		}
		System.out.println(result);
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
		Vertex ep1;
		Vertex ep2;

		public Edge(int weight, Vertex ep1, Vertex ep2) {
			this.weight = weight;
			this.ep1 = ep1;
			this.ep2 = ep2;
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
