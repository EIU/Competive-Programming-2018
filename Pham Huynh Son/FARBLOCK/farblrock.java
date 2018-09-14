import java.io.*;
import java.util.*;



public class Main {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int n = reader.nextInt();		
		Vertex[] k = readGraph(n, n-1, reader);
		int m = reader.nextInt();
		for (int i = 0; i < m; i++) {
			
			strBuilder.append(k[reader.nextInt()].getNeighbors() + "\n");
		}
		System.out.println(strBuilder);
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
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
		}
		return vertices;
	}

	static class Vertex {
		public int id;
		public List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(int id) {
			this.id = id;
		}

		public int getNeighbors() {
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