package PST;

import java.io.*;
import java.util.*;

public class EICLSF_TANTINH {
	static InputReader reader;

	public static void main(String[] args) throws IOException {
		StringBuilder builder = new StringBuilder();
		reader = new InputReader();
		int n = reader.nextInt();
		int k = reader.nextInt();
		int q = reader.nextInt();
		int count = 0;
		HashMap<String, Vertex> hm = readGraph(n, k);
		for (String a : hm.keySet()) {
			if (!hm.get(a).visited) {
				count++;
				dfs(hm.get(a), count);
			}
		}
		for (int i = 0; i < q; i++) {
			HashSet<Integer> hs = new HashSet<Integer>();
			int girls = reader.nextInt();
			for (int j = 0; j < girls; j++) {
				String girlname = reader.next();
				hs.add(hm.get(girlname).step);
			}
			if (hs.size() == girls) {
				builder.append("Yes\n");
			} else {
				builder.append("No\n");
			}
		}
		System.out.print(builder);
	}

	public static HashMap<String, Vertex> readGraph(int n, int k) {
		HashMap<String, Vertex> hm = new HashMap<String, Vertex>();
		for (int i = 0; i < n; i++) {
			String name = reader.next();
			hm.put(name, new Vertex(name));
		}
		for (int i = 0; i < k; ++i) {
			String u = reader.next();
			String v = reader.next();
			hm.get(u).AddNeighbors(hm.get(v));
			hm.get(v).AddNeighbors(hm.get(u));
		}
		return hm;
	}

	public static void dfs(Vertex u, int count) {
		u.visited = true;
		u.step = count;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				dfs(v, count);
			}
		}

	}

	static class Vertex {

		private String id;
		private int step;
		private boolean visited = false;
		List<Vertex> neighbors = new ArrayList<>();

		public Vertex(String id) {
			this.id = id;
		}

		public void AddNeighbors(Vertex child) {
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