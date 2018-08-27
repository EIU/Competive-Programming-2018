
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		StringBuilder result = new StringBuilder();
		int vertices = scan.nextInt();

		Vertex[] list = readGraph(vertices, scan);

		for (Vertex i : list) {
			result.append(((i.importPrice == -1) ? 0 : i.children) + " ");
		}
		System.out.println(result);
	}

	static int findChildren(Vertex u) {
		u.visited = true;
		int count = 1;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				count += findChildren(v);
			}
		}
		u.children = count;
		return count;
	}

	static void dfs(Vertex u) {
		u.visited = true;
		for (Vertex v : u.neighbors) {
			if (!v.visited && u.importPrice != -1) {
				long price = u.importPrice * 110 / 100;
				if (price <= v.max) {
					v.importPrice = price;
					u.children -= v.children;
				}
				dfs(v);
			}
		}
	}

	public static Vertex[] readGraph(int nVertices, InputReader scan) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nVertices - 1; ++i) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		for (int i = 0; i < nVertices; ++i) {
			vertices[i].max = scan.nextLong();
		}
		vertices[0].importPrice = scan.nextLong();
		if (vertices[0].importPrice <= vertices[0].max) {
			findChildren(vertices[0]);
			for (Vertex i : vertices) {
				i.visited = false;
			}
			dfs(vertices[0]);
		}
		return vertices;
	}

	static class Vertex {

		public int id;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public long importPrice = -1;
		public long max = 0;
		public int children = 0;

		public Vertex(int id) {
			this.id = id;
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
