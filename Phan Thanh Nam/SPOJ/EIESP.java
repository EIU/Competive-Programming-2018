import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
	static InputReader sc = new InputReader(System.in);
	static class Vertex {
		public int id = -1;
		public List<Vertex> neighbors = new ArrayList<Vertex>();
		private boolean discover = false;
		private boolean color = false;
		private int level = 0;
 
		public Vertex(int id) {
			this.id = id;
		}
 
		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}
 
	}
	public static boolean bfs(Vertex v) {
		v.discover = true;
		v.level = 0;
		Queue<Vertex> q = new ArrayDeque<>();
		q.add(v);
		while (!q.isEmpty()) {
			 v = q.poll();
			for (Vertex u : v.neighbors) {
				if (!u.discover) {
					u.discover = true;
					u.level = v.level + 1;
					q.add(u);
				} else {
					if (v.level == u.level) {
						return false;
					}
				}
			}
		}
		return true;
	}
 
	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; i++) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			vertices[u].addNeighbor(vertices[v]);
			vertices[v].addNeighbor(vertices[u]);
 
		}
		return vertices;
	}
 
	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Vertex[] vertice = readGraph(n, m);
			if (bfs(vertice[1])) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
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
 