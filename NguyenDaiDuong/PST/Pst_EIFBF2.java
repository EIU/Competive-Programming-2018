import java.io.*;
import java.util.*;

class EIFBF2_Fabook_V2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		Vertex[] vertices = readGraph(reader.nextInt(), reader.nextInt());
		for (Vertex i : vertices)
			if (!i.visited) {
				i.component = i.id;
				dfs(i);
			}
		for (Vertex i : vertices) {
			Vertex acc = vertices[i.component - 1];
			builder.append(i.id + " " + acc.men + " " + acc.woment + "\n");
		}
		System.out.print(builder);
	}

	public static void dfs(Vertex u) {
		u.visited = true;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				v.component = u.component;
				dfs(v);
				u.men += v.men;
				u.woment += v.woment;
			}
		}
	}

	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i + 1);
			if (reader.next().equals("Nam"))
				vertices[i].men++;
			else
				vertices[i].woment++;
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = reader.nextInt() - 1;
			int v = reader.nextInt() - 1;
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}

		return vertices;
	}

	static class Vertex {
		public int id;
		boolean visited = false;
		public int component = 0;
		public int men = 0;
		public int woment = 0;
		public List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(int id) {
			this.id = id;
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
