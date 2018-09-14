import java.io.*;
import java.util.*;

public class EIMAKEFRIE {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder strBuilder = new StringBuilder();
		HashMap<Integer, Integer> hmap = new HashMap<>();

		int n = reader.nextInt();
		int m = reader.nextInt();
		int q = reader.nextInt();

		Vertex[] k = readGraph(n, m, reader);
		for (int i = 0; i < n; i++) {
			Collections.sort(k[i].neighbors, (a, b) -> {
				if (a.id > b.id) {
					return 1;
				} else if (a.id < b.id) {
					return -1;
				}
				return 0;
			});
		}

		for (int i = 0; i < q; i++) {

		}
		System.out.println(strBuilder);
	}

	public static int dfs(Vertex u, Vertex key, int count) {
		u.visited = true;
		count++;
		int temp = -1;
		int max;
		List<Integer> list = new ArrayList<>();
		for (Vertex v : u.neighbors) {
			if (v.id == key.id) {
				list.add(count);
				break;
			}
			if (!v.visited) {
				temp = dfs(v, key, count);
				if (temp != -1)
					list.add(temp);
			}
		}
		Collections.sort(list);
		max = list.size() > 0 ? list.get(0) : 0;
		u.visited=false;
		return max;
	}

	public static Vertex[] readGraph(int nVertices, int nEdges, InputReader reader) {

		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i);
		}

		int u, v;
		for (int i = 0; i < nEdges; ++i) {
			u = reader.nextInt();
			v = reader.nextInt();
			if (!vertices[u].neighbors.contains(vertices[v]) && v != u) {
				vertices[u].addNeighbor(vertices[v]);
				vertices[v].addNeighbor(vertices[u]);
			}
		}
		return vertices;
	}

	static class Vertex {
		public int id;
		public boolean visited = false;
		public List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(int id) {
			this.id = id;
		}

		public int getDeg() {
			return neighbors.size();
		}

		public void setNeighbors(List<Vertex> neighbors) {
			this.neighbors = neighbors;
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