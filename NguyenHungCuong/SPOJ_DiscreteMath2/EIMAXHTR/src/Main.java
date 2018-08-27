
import java.io.*;
import java.util.*;

class Main {
	static Vertex path = new Vertex(Integer.MAX_VALUE, 0);

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		System.out.println(readGraph(scan.nextInt(), scan));
	}

	static Vertex dfs(Vertex u, Vertex father) {
		u.visited = true;
		if (u.neighbors.size() == 1 && father != null && u.neighbors.get(0).id == father.id) {// this is a leave
			return u;
		} else {// this is a node with more than one leave
			ArrayList<Vertex> leaves = new ArrayList<>();
			for (Vertex v : u.neighbors) {
				if (!v.visited) {
					v.k = u.k + 1;
					leaves.add(dfs(v, u));
				}
			}
			if (leaves.size() == 1) {// this node has one leave, return it
				return leaves.get(0);
			}
			// find two leaves with largest k and smallest id
			leaves.sort((a, b) -> (a.k == b.k) ? a.id - b.id : b.k - a.k);
			int k = leaves.get(1).k + leaves.get(0).k - 2 * u.k;
			int id = Math.min(leaves.get(1).id, leaves.get(0).id);
			if (k > path.k) {// found new longest path
				path.k = k;
				path.id = id;
			} else if (k == path.k) {// found path that has equal length to the longest path, update id
				path.id = Math.min(path.id, id);
			}
			return leaves.get(0);
		}
	}

	static Vertex bfs(Vertex u, boolean[] visited) {
		u.k = 0;
		visited[u.id] = true;
		Vertex res = new Vertex(u.id);
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(u);
		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			for (Vertex v : current.neighbors) {
				if (!visited[v.id]) {
					visited[v.id] = true;
					v.k = current.k + 1;
					queue.add(v);
					if (v.neighbors.size() == 1 && v.neighbors.get(0).id == current.id && v.k >= res.k) {
						if (v.k > res.k) {
							res.id = v.id;
							res.k = v.k;
						} else {
							res.id = Math.min(res.id, v.id);
						}
					}
				}
			}
		}
		return res;
	}

	public static String readGraph(int nVertices, InputReader scan) {
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
//		boolean[] visited = new boolean[nVertices];          //using 2 BFS
//		Vertex start = bfs(vertices[0],visited);
//		Arrays.fill(visited, false);
//		Vertex end = bfs(vertices[start.id],visited);
//		return Math.min(start.id, end.id)+" "+Math.max(start.k, end.k);

		// using one dfs
		Vertex res = dfs(vertices[0], null);
		if (res.k > path.k) {
			path.k = res.k;
			path.id = 0;
		} else if (res.k == path.k) {
			path.id = 0;
		}
		return path.id + " " + path.k;
	}

	static class Vertex implements Comparable<Vertex> {

		public int id;
		public List<Vertex> neighbors = new ArrayList<>();
		public boolean visited = false;
		public int k = 0;

		public Vertex(int id) {
			this.id = id;
		}

		public Vertex(int id, int k) {
			this.id = id;
			this.k = k;
		}

		public int getDeg() {
			return this.neighbors.size();
		}

		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}

		@Override
		public int compareTo(Vertex other) {
			return other.k - this.k;
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
