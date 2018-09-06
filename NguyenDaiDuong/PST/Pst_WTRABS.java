import java.io.*;
import java.util.*;

class WTRABS_Nuoc_Tran {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder buider = new StringBuilder();
		List<Vertex> vertices = readGraph(reader.nextInt());
		for (Vertex v : vertices) {
			if (v.check == true) {
				dfs(v);
				break;
			}
		}
		for (Vertex v : vertices) {
			buider.append(v.water != 0 ? v.id + " " + Math.round((v.water * 10000)) / 10000.0 + "\n" : "");
		}
		System.out.print(buider);
	}

	public static void dfs(Vertex u) {
		u.visited = true;
		if (u.neighbors.size() != 0) {
			u.waterForEach = u.water / u.neighbors.size();
			u.water = 0;
		}
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				v.water += u.waterForEach;
				dfs(v);
			}
		}
	}

	public static List<Vertex> readGraph(int nVertices) {

		List<Vertex> vertices = new ArrayList<>();
		for (int i = 0; i < nVertices; ++i) {
			vertices.add(new Vertex(i));
			vertices.get(i).water = reader.nextDouble();
		}
		for (int i = 0; i < nVertices - 1; ++i) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			vertices.get(v).addNeighbor(vertices.get(u));
			vertices.get(u).check = false;
		}
		return vertices;
	}

	static class Vertex {
		public int id;
		public boolean visited = false;
		public boolean check = true;
		public double water = 0;
		public double waterForEach = 0;
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
