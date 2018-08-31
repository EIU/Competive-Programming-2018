
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		int n = scan.nextInt();
		long sum = 0;
		Vertex[] vertices = new Vertex[n];
		for (int i = 0; i < n; ++i) {
			long w = scan.nextLong();
			sum += w;
			vertices[i] = new Vertex(i + 1, w);
		}
		for (int i = 0; i < n - 1; ++i) {
			int u = scan.nextInt() - 1;
			int v = scan.nextInt() - 1;
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		dfs(vertices[0]);
		Vertex u = null;
		long a = 0, b = 0;
		boolean first = true;
		for (Vertex v : vertices) {
			if (v.neighbors.size() == 2) {
				if (first) {
					first = false;
					u = v;
				} else {
					a = Math.abs(Math.min(v.neighbors.get(0).total, v.neighbors.get(1).total) * 2 - sum + v.w);
					b = Math.abs(Math.min(u.neighbors.get(0).total, u.neighbors.get(1).total) * 2 - sum + u.w);
					u = (a == b) ? ((u.id > v.id) ? v : u) : ((a < b) ? v : u);
				}
			}
		}
		if (u == null) {
			System.out.println(-1);
			return;
		}
		a = Math.min(u.neighbors.get(0).total, u.neighbors.get(1).total);
		System.out.println(u.id + " " + Math.min(a, sum - u.w - a) + " " + Math.max(a, sum - u.w - a));
	}

	static long dfs(Vertex u) {
		u.visited = true;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				u.total += dfs(v);
			}
		}
		return u.total;
	}

	static class Vertex {

		public int id;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public long w;
		public long total = 0;

		public Vertex(int id, long w) {
			this.id = id;
			this.w = w;
			this.total += w;
		}

		public int getDeg() {
			return this.neighbors.size();
		}

		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}
	}

	static class InputReader {

		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}

				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
