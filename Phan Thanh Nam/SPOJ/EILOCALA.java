import java.io.*;
import java.util.*;
 
class GreenCity {
	static InputReader sc;
	static HashMap<String, Integer> hs ;
	static long[] deg;
 
	static class Vertex {
		public int id = -1;
		public List<Vertex> neighbors = new ArrayList<Vertex>();
		private boolean visited = false;
 
		public Vertex(int id) {
			this.id = id;
		}
 
		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}
 
	}
 
	public static int bfs(Vertex v, int n) {
		deg = new long[n];
		Arrays.fill(deg, -1);
		Queue<Vertex> queue = new LinkedList();
		queue.add(v);
		deg[v.id] = 0;
		while (!queue.isEmpty()) {
			Vertex currentVertex = queue.poll();
			for (Vertex neighbor : currentVertex.neighbors) {
				if (deg[neighbor.id] == -1) {
					String a = String.valueOf(currentVertex.id);
					String b = String.valueOf(neighbor.id);
					queue.add(neighbor);
					if (hs.get(a + b) != null) {
						deg[neighbor.id] = deg[currentVertex.id] + hs.get(a + b);
					} else {
						deg[neighbor.id] = deg[currentVertex.id] + hs.get(b + a);
					}
					
				}
			}
		}
		long max = 0;
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (max < deg[i]) {
				max = deg[i];
				k = i;
			}
		}
		return k;
	}
 
	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			String a = String.valueOf(u);
			String b = String.valueOf(v);
			if (u != v && !vertices[u].neighbors.contains(vertices[v])) {
				hs.put(a + b, sc.nextInt());
				vertices[u].addNeighbor(vertices[v]);
				vertices[v].addNeighbor(vertices[u]);
				
			}
		}
		return vertices;
	}
 
	public static void main(String[] args) throws IOException {
		sc=new InputReader(); 
		int n = sc.nextInt();
		hs=new HashMap<>();
		Vertex[] vertices = readGraph(n, n - 1);
		int m = bfs(vertices[0], n);
		int k = bfs(vertices[m], n);
		if (m > k) {
			System.out.println(k + " " + deg[k]);
		} else {
			System.out.println(m + " " + deg[k]);
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