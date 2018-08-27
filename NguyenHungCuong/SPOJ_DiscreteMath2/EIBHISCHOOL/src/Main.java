import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		System.out.println(readGraph(scan.nextInt(), scan.nextInt(), scan));
	}

	static Vertex bfs(Vertex u) {
		Vertex minIndex = new Vertex(Integer.MAX_VALUE, 0);
		u.visited = true;
		minIndex.id = Math.min(minIndex.id, u.id);
		minIndex.avg += u.score;
		minIndex.numStu++;
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(u);
		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			for (Vertex v :current.neighbors) {
				if (!v.visited) {
					v.visited=true;
					minIndex.id = Math.min(minIndex.id, v.id);
					minIndex.avg += v.score;
					minIndex.numStu++;
					queue.add(v);
				}
			}
		}
		minIndex.avg /= minIndex.numStu;
		return minIndex;
	}

	public static StringBuilder readGraph(int nVertices, int nEdges, InputReader scan) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i, scan.nextDouble());
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		ArrayList<Vertex> res = new ArrayList<>();
		for (Vertex i : vertices) {
			if (!i.visited) {
				res.add(bfs(i));
			}
		}
		res.sort((a, b) -> {
			int temp = b.avg.compareTo(a.avg);
			if (temp == 0) {
				temp = a.id - b.id;
			}
			return temp;
		});
		StringBuilder out = new StringBuilder();
		for (Vertex i : res) {
			out.append(i.id).append(" ").append(((double)Math.round(i.avg * 10) / 10)).append("\n");
		}
		return out;
	}

	static class Vertex {

		public int id;
		public Double avg = 0.0;
		public double score;
		public int numStu = 0;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;

		public Vertex(int id, double score) {
			this.id = id;
			this.score = score;
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
