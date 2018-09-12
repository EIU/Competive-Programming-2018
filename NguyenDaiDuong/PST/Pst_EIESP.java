import java.io.*;
import java.util.*;

class DFS {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		int test = reader.nextInt();
		for (int h = 0; h < test; h++) {
			Vertex[] vertices = readGraph(reader.nextInt(), reader.nextInt());
			boolean result = false;
			for (Vertex i : vertices) {
				List<Vertex> list = new ArrayList<>();
				if (i.visited == false) {
					i.check = 1;
					if (dfs(i, list,i)==false) {
						result = true;
						break;
					}
				}else {
					for (Vertex m : i.neighbors) {
						if (m.check == i.check) {
							result = true;
							break;
						}
					}
				}
			}
			if (result == true) {
				builder.append("No\n");
			} else {
				builder.append("Yes\n");
			}
		}
		System.out.println(builder);
	}

	public static boolean dfs(Vertex u, List<Vertex> list,Vertex tem) {
		u.visited = true;
		list.add(u);
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				v.check = u.check == 1 ? 2 : 1;
				dfs(v, list,tem);
			}
		}
		if(list.get(list.size()-1).neighbors.contains(tem)&&list.size()%2!=0)
			return false;
		else {
			return true;
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
		for (Vertex i : vertices) {
			i.sortNb();
		}

		return vertices;
	}

	static class Vertex {
		public int id;
		int check = 0;
		boolean visited = false;
		public List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(int id) {
			this.id = id;
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
