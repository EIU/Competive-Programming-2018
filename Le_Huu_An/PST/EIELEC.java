import java.io.*;
import java.util.*;

public class QUATAIDIEN {
	static InputReader reader;
	static HashMap<Node, Long> hm = new HashMap<Node, Long>();

	public static void main(String[] args) throws IOException {
		reader = new InputReader();
		StringBuilder builder = new StringBuilder();
		int nNumber = reader.nextInt();
		int R = reader.nextInt();
		Node[] nodes = ReadTree(nNumber);
		while (reader.hasNext()) {
			int u = reader.nextInt();
			long q = reader.nextLong();
			nodes[u].wNode = q;
		}
		List<Integer> list = new ArrayList<>();
		dfs(nodes[R]);
		for (int i = 0; i < nNumber; i++) {
			nodes[i].visited = false;
		}
		for (int i = 0; i < nNumber; i++) {
			if (nodes[i].neighbors.size() == 1) {
				list = dfs2(nodes[R], list);
			}
		}

	}

	public static void dfs(Node u) {
		u.visited = true;
		for (Node v : u.neighbors.keySet()) {
			if (!v.visited) {
				dfs(v);
				u.wNode += v.wNode;                           
			}
		}
	}

	public static List<Integer> dfs2(Node u, List<Integer> list) {
		u.visited = true;
		for (Node v : u.neighbors.keySet()) {
			if (!v.visited) {
				if (hm.get(u.neighbors.get(v)) >= v.wNode + (v.wNode * 0.1)) {
					list.add(v.id);
				}
				dfs(v);
			}
		}
		return list;
	}

	public static Node[] ReadTree(int nNode) {
		Node[] nodes = new Node[nNode];
		for (int i = 0; i < nNode; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < nNode - 1; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			long w = reader.nextLong();
			nodes[u].AddNeighbors(nodes[v], w);
			nodes[v].AddNeighbors(nodes[u], w);
		}
		return nodes;
	}

	static class Node {
		public int id;
		public long wNode;
		public boolean visited = false;
		private HashMap<Node, Long> neighbors = new HashMap<Node, Long>();

		public Node(int id) {
			this.id = id;
		}

		public void AddNeighbors(Node child, long w) {
			neighbors.put(child, w);
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
