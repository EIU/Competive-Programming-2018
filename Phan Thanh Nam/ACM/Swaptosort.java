import java.io.*;
import java.util.*;

public class Swaptosort {
	static InputReader sc = new InputReader(System.in);

	static class Vertex {
		public int id = -1;
		public List<Vertex> neighbors = new ArrayList<Vertex>();
		private boolean visited = false;
		public int deg = 0;

		public Vertex(int id) {
			this.id = id;
		}

		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}

	}

	static boolean check = false;

	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(nVertices - i);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			if (u != v) {
				vertices[u].addNeighbor(vertices[v]);
				vertices[v].addNeighbor(vertices[u]);
			}
		}
		return vertices;
	}

	public static void dfs(Vertex u, List<Integer> arr) {
		u.visited = true;
		arr.add(u.id);
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				dfs(v, arr);
			}
		}
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		Vertex[] vertices = readGraph(n, k);
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = n - i;
		}
		boolean result = true;
		for (int i = 0; i < vertices.length; i++) {
			List<Integer> arr = new ArrayList<>();
			if (vertices[i].visited == false) {
				dfs(vertices[i], arr);
				int sum = 0, sum2 = 0;
				for (int j = 0; j < arr.size(); j++) {
					sum2 += arr.get(j);
					sum += array[arr.get(j) - 1];
				}
				if (sum != sum2) {
					result = false;
					break;
				}
			}
		}
		System.out.println(result ? "Yes" : "No");
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
