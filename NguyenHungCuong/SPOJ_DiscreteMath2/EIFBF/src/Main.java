
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder result = new StringBuilder();

		int vertices = scan.nextInt();
		int edges = scan.nextInt();

		Vertex[] list = readGraph(vertices, edges, scan);
		Component component;
		List<Component> components = new ArrayList<>();
		for (Vertex i : list) {
			if (!i.visited) {
				component = new Component();
				dfsConnected(i,component,components.size());
				components.add(component);
			}
		}
		for (Vertex i : list) {
			result.append(i.id).append(components.get(i.groupNumber));
		}
		System.out.println(result);
	}

	static void dfsConnected(Vertex u, Component component,int groupNumber) {
		u.visited = true;
		u.groupNumber = groupNumber;
		if (u.gender == 1) {
			component.male++;
		} else {
			component.female++;
		}
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				dfsConnected(v, component,groupNumber);
			}
		}
	}

	static class Component{
		int male = 0;
		int female = 0;
		public Component() {
			super();
		}
		public String toString() {
			return " "+this.male+" "+this.female+" \n";
		}
	}
	public static Vertex[] readGraph(int nVertices, int nEdges, InputReader scan) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i + 1);
			vertices[i].gender = (scan.next().equals("Nam") ? 1 : 0);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = scan.nextInt() - 1;
			int v = scan.nextInt() - 1;
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		return vertices;
	}

	static class Vertex {

		public int id;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public int gender = -1;
		public int groupNumber = -1;
		public Vertex(int id) {
			this.id = id;
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
