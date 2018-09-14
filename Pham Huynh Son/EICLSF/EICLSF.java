import java.io.*;
import java.util.*;

public class EICLSF {
	static HashMap<String, Integer> hmap = new HashMap<>();

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int n = reader.nextInt();
		int m = reader.nextInt();
		int u = reader.nextInt();
		Vertex[] k = readGraph(n, m, reader);
		for (int i = 0; i < n; i++) {
			if (!k[i].visited) {
				bfs(k[i], i);
			}
		}
		for (int i = 0; i < u; i++) {
			boolean f = true;
			int num = reader.nextInt();
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < num; j++) {
				String name = reader.next();
				if (!f)
					continue;
				int temp = hmap.get(name);
				if (list.contains(k[temp].member)) {
					f = false;
				}
				list.add(k[temp].member);
			}
			strBuilder.append(f ? "Yes\n" : "No\n");
		}
		System.out.println(strBuilder);
	}

	public static void bfs(Vertex v, int n) {
		if (!v.visited) {
			v.visited = true;
			v.member = n;
			Queue<Vertex> queue = new LinkedList<>();
			queue.add(v);
			while (!queue.isEmpty()) {
				Vertex currentVertex = queue.poll();
				for (Vertex neighbor : currentVertex.neighbors) {
					if (!neighbor.visited) {
						neighbor.visited = true;
						queue.add(neighbor);
						neighbor.member = n;
					}
				}
			}
		}
	}

	public static Vertex[] readGraph(int nVertices, int nEdges, InputReader reader) {

		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; ++i) {
			vertices[i] = new Vertex(reader.next());
			hmap.put(vertices[i].id, i);
		}

		String u, v;
		for (int i = 0; i < nEdges; ++i) {
			u = reader.next();
			v = reader.next();
			if (!vertices[hmap.get(u)].neighbors.contains(vertices[hmap.get(v)])) {
				vertices[hmap.get(u)].addNeighbor(vertices[hmap.get(v)]);
				vertices[hmap.get(v)].addNeighbor(vertices[hmap.get(u)]);
			}
		}
		return vertices;
	}

	static class Vertex {
		public boolean visited = false;
		public String id;
		public int member;
		public List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(String id) {
			this.id = id;
		}

		public int getDeg() {
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
