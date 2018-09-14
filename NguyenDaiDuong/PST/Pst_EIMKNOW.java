import java.io.*;
import java.util.*;

class Hw_Ket_ban {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		List<Vertex> vertices = readGraph(reader.nextInt(), reader.nextInt());
		dfs(vertices);
		vertices.sort((v1, v2) -> v1.id - v2.id);
		for (int i = 0; i < vertices.size(); i++) {
			builder.append(vertices.get(i).id + " " + vertices.get(i).mayBeFriends.size() + "\n");
		}
		System.out.print(builder);
	}

	public static void dfs(List<Vertex> u) {
		Vertex temp, acc;
		for (Vertex v : u) {
			for (int i = 0; i < v.neighbors.size(); i++) {
				temp = v.neighbors.get(i);
				for (int j = 0; j < v.neighbors.size(); j++) {
					acc = v.neighbors.get(j);
					if (temp.id != acc.id && temp.address == acc.address && !acc.neighbors.contains(temp))
						acc.mayBeFriends.add(temp.id);
				}
			}

		}
	}

	public static List<Vertex> readGraph(int nVertices, int nEdges) {
		List<Vertex> vertices = new ArrayList<>();
		for (int i = 0; i < nVertices; ++i) {
			vertices.add(new Vertex(i, reader.nextInt()));
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			vertices.get(u).addNeighbor(vertices.get(v));
			vertices.get(v).addNeighbor(vertices.get(u));
		}
		return vertices;
	}

	static class Vertex {
		public int id;
		public boolean visited = false;
		public int address = 0;
		public List<Vertex> neighbors = new ArrayList<Vertex>();
		public HashSet<Integer> mayBeFriends = new HashSet<>();

		public Vertex(int id, int address) {
			super();
			this.id = id;
			this.address = address;
		}

		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}

		public void sortNb() {
			this.neighbors.sort((nb1, nb2) -> nb1.id - nb2.id);
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
