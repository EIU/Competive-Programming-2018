
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int n = scan.nextInt();
		HashMap<String,Integer> hm = new HashMap<>();
		Vertex[] list = readGraph(n,scan,hm);
		dfs(list[0],hm);
		long max = 0;
		for (Vertex i : list) {
			max = Math.max(max, i.current);
		}
		System.out.println(max);
	}
	
	static void dfs(Vertex u,HashMap<String,Integer> hm) {
		u.visited = true;
		for (Vertex v : u.neighbor) {
			if (!v.visited) {
				v.current = u.current + hm.get(u.id+""+v.id);
				dfs(v,hm);
			}
		}
	}
	
	public static Vertex[] readGraph(int n, InputReader scan,HashMap<String,Integer> hm) {
		Vertex[] vertices = new Vertex[n];
		for (int i = 0; i < n; ++i) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < n-1; ++i) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			int w = scan.nextInt();
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
			hm.put(u+""+v, w);
			hm.put(v+""+u, w);
		}
		return vertices;
	}

	static class Vertex {

		public int id;
		public ArrayList<Vertex> neighbor = new ArrayList<>();
		public boolean visited = false;
		public long current = 0;
		public Vertex(int id) {
			this.id = id;
		}

		public void addNeighbor(Vertex child) {
			neighbor.add(child);
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
