
import java.io.*;
import java.util.*;

class Main {
	static int[] order;
	static int index = 0;

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		StringBuilder res = new StringBuilder();
		int n = scan.nextInt();
		order = new int[n];
		Vertex[] list = readGraph(n, scan);
		dfs(list[0]);
		for (int i = 1; i < index; i++) {
			Vertex u = list[order[i]];
			Vertex father = u.father;
			if (u.first + 1 == father.first) {
				if (father.first == father.second) {
					u.second = u.first;
					u.first = father.first + 1;
				} else if (u.first != father.second) {
					u.second = Math.max(u.second, father.second + 1);
				} else {
					u.second = u.first;
					u.first = father.first;
				}
			} else {
				u.second = u.first;
				u.first = father.first + 1;
			}
		}
		int q = scan.nextInt();
		while (q-- > 0) {
			res.append(list[scan.nextInt()].first + "\n");
		}
		System.out.println(res);
	}

	static int dfs(Vertex u) {
		u.visited = true;
		order[index++] = u.id;
		int max = u.level;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				v.level = u.level + 1;
				v.father = u;
				int leave = dfs(v);
				max = Math.max(max, leave);
				leave -= u.level;
				if (u.first < leave) {
					u.second = u.first;
					u.first = leave;
				} else {
					u.second = Math.max(u.second, leave);
				}
			}
		}
		return max;

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
		return vertices;
	}

	static class Vertex implements Comparable<Vertex> {

		public int id;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public int level = 0;
		public Vertex father = null;
		public int first = 0, second = 0;

		public Vertex(int id) {
			this.id = id;
		}

		public int getDeg() {
			return this.neighbors.size();
		}

		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}

		@Override
		public int compareTo(Vertex other) {
			return other.level - this.level;
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
