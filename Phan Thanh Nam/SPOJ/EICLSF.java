import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
 
class EILOCAL2 {
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
 
	public static Vertex[] readGraph(int nVertices, int nEdges, HashMap<String, Integer> hs) {
		Vertex[] vertices = new Vertex[nVertices];
		for (int i = 0; i < nVertices; i++) {
			hs.put(sc.next(), i);
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < nEdges; ++i) {
			int u = hs.get(sc.next());
			int v = hs.get(sc.next());
			if (u != v) {
				vertices[u].addNeighbor(vertices[v]);
				vertices[v].addNeighbor(vertices[u]);
			}
		}
		return vertices;
	}
 
	public static void dfs(Vertex u, int count) {
		u.visited = true;
		u.deg = count;
		for (Vertex v : u.neighbors) {
			if (!v.visited) {
				dfs(v, count);
			}
 
		}
	}
 
	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		HashMap<String, Integer> hs = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		Vertex[] vertices = readGraph(n, k, hs);
		int count = 0;
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].visited == false && vertices[i].neighbors.size() != 0) {
				count++;
				dfs(vertices[i], count);
			}
		}
		for (int i = 0; i < q; i++) {
			int m = sc.nextInt();
			String[] name = new String[m];
			for (int j = 0; j < m; j++) {
				name[j] = sc.next();
			}
			int check = 0;
			for (int j = 0; j < m - 1; j++) {
				if (vertices[hs.get(name[j])].neighbors.size() != 0) {
					for (int x = j + 1; x < m; x++) {
						if (vertices[hs.get(name[j])].deg == vertices[hs.get(name[x])].deg) {
							check++;
							sb.append("No" + "\n");
							break;
						}
					}
				}
				if (check > 0) {
					break;
				}
			}
			if (check == 0) {
				sb.append("Yes" + "\n");
			}
		}
		System.out.println(sb);
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
 