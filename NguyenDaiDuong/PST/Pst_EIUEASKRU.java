import java.io.*;
import java.util.*;

class Minimum_Spanning_Tree {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int nVer = reader.nextInt(), nEdge = reader.nextInt();
		int[] p = createSets(nVer + 1);
		long[] result = new long[nVer + 1];
		Edge temp;
		Edge[] vertexs = readGraph(nVer, nEdge);
		for (int i = 0; i < vertexs.length; i++) {
			temp = vertexs[i];
			unite(p, temp.endpoint1, temp.endpoint2, temp.weight, result);
		}
		for (int i = 1; i < result.length; i++)
			result[0] = Math.max(result[0], result[i]);
		System.out.println(result[0]);
	}

	public static Edge[] readGraph(int nVertices, int nEdges) {
		Edge[] vertices = new Edge[nEdges];
		for (int i = 0; i < nEdges; ++i)
			vertices[i] = new Edge(reader.nextInt(), reader.nextInt(), reader.nextInt());
		Arrays.sort(vertices);
		return vertices;
	}

	public static class Edge implements Comparable<Edge> {
		public int endpoint1;
		public int endpoint2;
		public int weight;

		public Edge(int endpoint1, int endpoint2, int weight) {
			super();
			this.endpoint1 = endpoint1;
			this.endpoint2 = endpoint2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static int[] createSets(int size) {
		int[] p = new int[size];
		for (int i = 0; i < size; i++)
			p[i] = i;
		return p;
	}

	public static int root(int[] p, int x) {
		return x == p[x] ? x : (p[x] = root(p, p[x]));
	}

	public static void unite(int[] p, int a, int b, int c, long[] result) {

		a = root(p, a);
		b = root(p, b);
		if (a != b) {
			p[a] = b;
			result[b] += (result[a] + c);
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