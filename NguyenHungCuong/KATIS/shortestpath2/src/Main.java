import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder result = new StringBuilder();
		int n, m, queries, sNode;
		while ((n = scan.nextInt()) + (m = scan.nextInt()) + (queries = scan.nextInt())
				+ (sNode = scan.nextInt()) != 0) {
			Node[] nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(i);
			}
			for (int i = 0; i < m; i++) {
				int u = scan.nextInt();
				int v = scan.nextInt();
				nodes[u].addEdge(new Edge(nodes[v], scan.nextInt(), scan.nextInt(), scan.nextInt()));
			}
			PriorityQueue<Node> queue = new PriorityQueue<>();
			nodes[sNode].distance = 0;
			queue.add(nodes[sNode]);
			while (!queue.isEmpty()) {
				Node current = queue.poll();
				for (Edge edge : current.edges) {
					int distance = edge.t0 + edge.d;

					if (current.distance > edge.t0) {
						if (edge.P == 0) {
							distance = Integer.MAX_VALUE;
						} else {
							int steps = (current.distance - edge.t0 - 1) / edge.P + 1;
							distance = steps * edge.P + edge.t0 + edge.d;
						}
					}
					Node target = edge.target;
					if (distance < target.distance) {
						queue.remove(target);
						target.distance = distance;
						queue.add(target);
					}
				}
			}
			while (queries-- > 0) {
				int time = nodes[scan.nextInt()].distance;
				result.append((time != Integer.MAX_VALUE) ? time + "\n" : "Impossible\n");
			}
			result.append("\n");
		}
		System.out.println(result);
	}

	static class Node implements Comparable<Node> {
		public int id;
		public ArrayList<Edge> edges = new ArrayList<>();
		public int distance = Integer.MAX_VALUE;

		public Node(int id) {
			this.id = id;
		}

		public void addEdge(Edge e) {
			this.edges.add(e);
		}

		@Override
		public int compareTo(Node other) {
			return this.distance - other.distance;
		}
	}

	static class Edge {
		public Node target = null;
		public int t0;
		public int P;
		public int d;

		public Edge(Node to, int beginTime, int P, int cost) {
			this.target = to;
			this.t0 = beginTime;
			this.P = P;
			this.d = cost;
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
