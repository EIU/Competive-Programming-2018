
import java.io.*;
import java.util.*;

class Main {
	static HashMap<String,Integer> hm = new HashMap<>();
	static Vertex path = new Vertex(Integer.MAX_VALUE,0);
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int n = scan.nextInt();
		Vertex[] list = readGraph(n,scan,hm);
		Vertex res = dfs(list[0], null);
		if (res.current > path.current) {
			path.current = res.current;
			path.id = 0;
		} else if (res.current == path.current) {
			path.id = 0;
		}
		System.out.println(path.id +" "+path.current);
	}
	
	static Vertex dfs(Vertex son, Vertex father) {
		son.visited = true;
		if (son.neighbors.size() == 1 && father != null && son.neighbors.get(0).id == father.id) {// this is a leave	
			return son;
		} else {// this is a node with more than one leave
			ArrayList<Vertex> leaves = new ArrayList<>();
			for (Vertex v : son.neighbors) {
				if (!v.visited) {
					v.current = son.current + hm.get(son.id+""+v.id);
					leaves.add(dfs(v, son));
				}
			}
			if (leaves.size() == 1) {// this node has one leave, return it
				return leaves.get(0);
			}
			// find two leaves with largest k and smallest id
			leaves.sort((a, b) ->{
				int res = Long.compare(a.current, b.current);
				if (res == 0) return a.id-b.id;
				return -res;
			});
			long length = leaves.get(1).current + leaves.get(0).current - 2 * son.current;
			int id = Math.min(leaves.get(1).id, leaves.get(0).id);
			if (length > path.current) {// found new longest path
				path.current = length;
				path.id = id;
			} else if (length == path.current) {// found path that has equal length to the longest path, update id
				path.id = Math.min(path.id, id);
			}
			return leaves.get(0);
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
		public ArrayList<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public long current = 0;
		public Vertex(int id) {
			this.id = id;
		}
		public Vertex(int id,long current) {
			this.id = id;
			this.current = current;
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
