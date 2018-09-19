import java.io.*;
import java.util.*;

public class prom2 {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);

		int n = reader.nextInt();
		int k = reader.nextInt();
		int[] list = new int[n];
		boolean f = true;
		for (int i = n, j = 0; i > 0; i--, j++) {
			list[j] = i;
		}
		Vertex[] ki = readG(n, k, reader);
		List<Vertex> lt = new ArrayList<>();
		for (int i = 0; i < n / 2; i++) {
			if (!ki[i].visited) {
				dfs(ki[i], i);
			}
		}
		for (int i = 0; i < n / 2; i++) {
			int temp = n - i - 1;
			if (ki[i].lt != ki[temp].lt) {
				f = false;
				break;
			}
		}
		if (f)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	public static Vertex[] readG(int n, int m, InputReader reader) throws IOException {
		Vertex[] vert = new Vertex[n];
		for (int i = 0; i < n; i++) {
			vert[i] = new Vertex(i);
		}
		for (int i = 0; i < m; i++) {
			int u = reader.nextInt() - 1;
			int v = reader.nextInt() - 1;
			vert[u].addNei(vert[v]);
			vert[v].addNei(vert[u]);
		}
		return vert;
	}

	static class Vertex {
		public int id;
		public boolean visited = false;
		public int lt;
		public List<Vertex> nei = new ArrayList<Vertex>();

		public Vertex(int id) {
			super();
			this.id = id;
		}

		public int getDeg() {
			return nei.size();
		}

		public void setNei(List<Vertex> nei) {
			this.nei = nei;
		}

		public void addNei(Vertex child) {
			nei.add(child);
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

	static void dfs(Vertex u, int n) {
		u.visited = true;
		u.lt = n;
		for (Vertex v : u.nei) {
			if (!v.visited) {
				dfs(v, n);
			}
		}
	}
}