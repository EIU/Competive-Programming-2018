import java.io.*;
import java.util.*;

public class numbertree {
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		String sw = reader.nextLine();
		String[] subStr = sw.split("");
		long pivot = (long) Math.pow(2, n + 1) - 1;
		long bonus = 0 ,v=0;

		if (subStr.length > 1)
			for (int i = 1; i < subStr.length; i++) {
				if (subStr[i].equals("R")) {
					pivot = (long) (pivot - Math.pow(2, i)) + bonus;
					v++;
				} else if (subStr[i].equals("L")) {
					pivot = (long) (pivot - Math.pow(2, i)) + (long) Math.pow(2, bonus)-v;

				}
				bonus++;
				if (i == subStr.length - 1) {
					break;
				}
			}
		System.out.println(pivot);

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

	public static void bfs(Vertex v, StringBuilder sb) {
		if (!v.visited) {
			v.visited = true;
			Queue<Vertex> queue = new LinkedList<>();
			queue.add(v);

			while (!queue.isEmpty()) {
				sb.append(queue.peek().id + " ");
				Vertex currentVertex = queue.poll();
				for (Vertex neighbor : currentVertex.neighbors) {
					if (!neighbor.visited) {
						neighbor.visited = true;
						queue.add(neighbor);
					}
				}
			}
		}
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
			if (!vertices[u].neighbors.contains(vertices[v])) {
				vertices[u].addNeighbor(vertices[v]);
				vertices[v].addNeighbor(vertices[u]);
			}
		}
		return vertices;
	}

	static class Vertex {
		public boolean visited = false;
		public int id;
		public List<Vertex> neighbors = new ArrayList<Vertex>();

		public Vertex(int id) {
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
}
