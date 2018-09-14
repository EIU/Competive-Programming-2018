import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
 
class File {
	static InputReader sc = new InputReader(System.in);
 
	static class Vertex {
		public int id = -1;
		public String name;
		public ArrayList<Vertex> neighbors = new ArrayList<>();
		private boolean visited = false;
 
		public int level = 0;
 
		public Vertex(String name) {
			this.name = name;
		}
 
		public void addNeighbor(Vertex child) {
			neighbors.add(child);
		}
	}
 
	public static void dfs(Vertex u, Vertex v, StringBuilder sb, boolean[] check) {
		ArrayList<Vertex> arr = u.neighbors;
		for (int i = 0; i < arr.size(); i++) {
			Vertex a = arr.get(i);
			if (!a.equals(v)) {
				Vertex neighbor = a;
				neighbor.level = u.level + 1;
				for (int j = 1; j < neighbor.level; j++) {
					if (check[j]) {
						sb.append("â??   ");
					} else {
						sb.append("    ");
					}
				}
				if (i == arr.size() - 2 && v.equals(arr.get(arr.size() - 1)) || i == arr.size() - 1) {
					sb.append("â??â??â??â??" + a.name + "\n");
					dfs(a, u, sb, check);
				} else {
					sb.append("â??â??â??â??"+a.name+"\n");
					check[neighbor.level]=true;
					dfs(a, u, sb, check);
					check[neighbor.level]=false;
				}
			}
		}
 
	}
 
	public static HashMap<String, Vertex> readGraph(int nVertices) {
		HashMap<String, Vertex> hs = new HashMap<>();
		for (int j = 0; j < nVertices - 1; j++) {
			String u = sc.next();
			if (!hs.containsKey(u)) {
				hs.put(u, new Vertex(u));
			}
			String v = sc.next();
			if (!hs.containsKey(v)) {
				hs.put(v, new Vertex(v));
			}
			hs.get(u).addNeighbor(hs.get(v));
			hs.get(v).addNeighbor(hs.get(u));
		}
		return hs;
	}
 
	public static void main(String[] args) {
		int n = sc.nextInt();
		HashMap<String, Vertex> vertice = readGraph(n);
		boolean[] check = new boolean[n];
		StringBuilder sb = new StringBuilder();
		for (String s : vertice.keySet()) {
			Collections.sort(vertice.get(s).neighbors, (a, b) -> {
				return a.name.compareToIgnoreCase(b.name);
			});
		}
		String s = sc.next();
		dfs(vertice.get(s), vertice.get(s), sb,check);
		System.out.println(s);
		System.out.println(sb.toString().trim());
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
 