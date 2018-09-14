package PST;

import java.io.*;
import java.util.*;

public class EIESP_EIU_ESPORTS {
	static InputReader reader;

	public static void main(String[] args) throws IOException {
		reader = new InputReader();
		StringBuilder builder = new StringBuilder();
		int T = reader.nextInt();
		for (int i = 0; i < T; ++i) {
			int nVertices = reader.nextInt();
			int mEdges = reader.nextInt();
			Vertex[] vertices = readGraph(nVertices, mEdges);
			if (bfs(vertices[1])) {
				builder.append("Yes" + "\n");
			} else {
				builder.append("No" + "\n");

			}
		}
		System.out.println(builder);
	}

	public static Vertex[] readGraph(int nVertices, int mEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < mEdges; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			if (!vertices[u].neighbors.contains(vertices[v]) && !vertices[v].neighbors.contains(vertices[u])) {
				vertices[v].AddNeighbors(vertices[u]);
				vertices[u].AddNeighbors(vertices[v]);
			}
		}
		return vertices;

	}

	public static boolean bfs(Vertex u) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(u);
		u.visited = true;
		u.color = true;
		while (!q.isEmpty()) {
			Vertex curVertex = q.poll();
			for (Vertex neighbor : curVertex.neighbors) {
				if (!neighbor.visited) {
					neighbor.color = !curVertex.color;
					neighbor.visited = true;
					q.add(neighbor);
				} else if (neighbor.color == curVertex.color) {
					return false;
				}
			}
		}
		return true;
	}

	static class Vertex {

		private int id;
		private boolean color;
		private boolean visited;
		private List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(int id) {
			this.id = id;
		}

		public void AddNeighbors(Vertex child) {
			neighbors.add(child);
		}

		public int getSize(List neighbors) {
			return neighbors.size();
		}

		public void sortNeighbor() {
			neighbors.sort((p1, p2) -> p1.id - p2.id);
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