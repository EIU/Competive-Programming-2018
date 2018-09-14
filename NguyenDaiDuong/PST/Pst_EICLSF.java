import java.io.*;
import java.util.*;

class EICLSF_Tan_Tinh {
	static InputReader reader = new InputReader(System.in);
	static HashMap<String, Integer> list =new HashMap<>();

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		int numOfVers = reader.nextInt();
		int numOfEdges = reader.nextInt();
		int numOfRequests = reader.nextInt();
		Vertex[] vertices = readGraph(numOfVers, numOfEdges);
		for (Vertex i : vertices)
			if (!i.visited)
				dfs(i);
		for (int i = 0; i < numOfRequests; i++) {
			int numOfGirls = reader.nextInt();
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < numOfGirls; j++)
				set.add(vertices[list.get(reader.next())].component);
			builder.append(set.size() == numOfGirls ? "Yes\n" : "No\n");
		}
		System.out.print(builder);
	}

	public static void dfs(Vertex u) {
		u.visited = true;
		for (Vertex v : u.neighbors)
			if (!v.visited) {
				v.component = u.component;
				dfs(v);
			}
	}

	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(reader.next(), i);
			list.put(vertices[i].id,i);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = list.get(reader.next());
			int v = list.get(reader.next());
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		return vertices;
	}

	static class Vertex {
		public String id;
		public int component = 0;
		boolean visited = false;
		public List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(String id, int index) {
			this.id = id;
			this.component = index;
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
