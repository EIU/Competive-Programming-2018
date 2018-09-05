import java.io.*;
import java.util.*;

class EIMAKEFRIE_Ket_Ban {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		int numberOfVer = reader.nextInt();
		int numberOfEdge = reader.nextInt();
		int test = reader.nextInt();
		Vertex[] vertices = readGraph(numberOfVer, numberOfEdge);
		bfs(vertices[0]);
		for (int i = 0; i < test; i++) {
			int index = reader.nextInt();
			builder.append(vertices[index].level >= 0 ? vertices[index].level +"\n": "-1" + "\n");
		}
		System.out.print(builder);
	}

	public static void bfs(Vertex node) {
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(node);
		node.visited = true;
		while (!queue.isEmpty()) {
			Vertex element = queue.remove();
			for (Vertex n : element.neighbors) {
				if (!n.visited) {
					queue.add(n);
					n.level = element.level + 1;
					n.visited = true;
				}
			}
		}
	}

	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		return vertices;
	}

	static class Vertex {
		public int id;
		boolean visited = false;
		int level = -1;
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
