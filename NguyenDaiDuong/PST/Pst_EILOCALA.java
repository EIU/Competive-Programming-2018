import java.util.*;
import java.io.*;

class Local_Area_Network {
	static boolean readFile = false;

	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		int numberOfVer = reader.nextInt();
		Vertex[] vertices = readGraph(numberOfVer, reader);
		if (vertices[0].neighbors.size() < 2)
			vertices[0].left = vertices[0].right = vertices[0].sNode = vertices[0].id;
		dfs(vertices[0]);
		Arrays.sort(vertices);
		System.out.println(vertices[0].sNode + " " + vertices[0].length);
	}

	public static int dfs(Vertex u) {
		u.visited = true;
		int max1 = 0, max2 = 0, distance = 0;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				v.left = v.neighbors.size() < 2 ? (v.left = v.right = v.sNode = v.id) : v.left;
				if ((distance = dfs(v) + u.map.get(v.id)) >= max1) {
					u.right = u.left;
					u.left = distance > (max2 = max1) ? v.left : Math.min(v.left, u.left);
					max1 = distance;
				} else {
					if (distance >= max2) {
						u.right = distance > max2 ? v.left : Math.min(v.left, u.right);
						max2 = Math.max(max2, distance);
					}
				}
			}
		}
		u.sNode = Math.min(u.left, u.right);
		u.length = max1 + max2;
		return max1;
	}

	public static Vertex[] readGraph(int nVertices, InputReader reader) {
		Vertex[] vertices = new Vertex[nVertices];
		int u, v, length;
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nVertices - 1; ++i) {
			vertices[(u = reader.nextInt())].map.put((v = reader.nextInt()), (length = reader.nextInt()));
			vertices[v].map.put(u, length);
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		return vertices;
	}

	static class Vertex implements Comparable<Vertex> {
		public int id;
		boolean visited = false;
		public int left = Integer.MAX_VALUE;
		public int right = Integer.MAX_VALUE;
		public int sNode = Integer.MAX_VALUE;
		public long length = 0;
		public HashMap<Integer, Integer> map = new HashMap<>();
		public List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(int id) {
			this.id = id;
		}

		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(o.length, this.length);
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
			for (int i = 0; i < n; i++)
				map[i] = ns(m);
			return map;
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
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
