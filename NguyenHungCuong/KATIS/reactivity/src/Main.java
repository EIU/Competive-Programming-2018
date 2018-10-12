import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int n = scan.nextInt();
		int k = scan.nextInt();
		Graph g = new Graph(n);
		boolean[][] map = new boolean[n][n];
		for (int i = 0; i < k; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			g.addEdge(u,v);
			map[u][v] = map[v][u] = true;
		}
		Stack<Integer> st = g.topologicalSort();
		StringBuilder res = new StringBuilder();
		boolean valid = true;
		while (!st.isEmpty()) {
			Integer a = st.pop();
			res.append(a+" ");
			if (!st.isEmpty() && !(map[a][st.peek()] && map[st.peek()][a])) {
				valid = false;
				break;
			}
		}
		System.out.println(valid?res:"back to the lab");
	}

	static class Graph {
		public int V; // No. of vertices
		public LinkedList<Integer> adj[]; // Adjacency List

		// Constructor
		public Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList();
		}

		// Function to add an edge into the graph
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

		// A recursive function used by topologicalSort
		public void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
			// Mark the current node as visited.
			visited[v] = true;
			Integer i;

			// Recur for all the vertices adjacent to this
			// vertex
			Iterator<Integer> it = adj[v].iterator();
			while (it.hasNext()) {
				i = it.next();
				if (!visited[i])
					topologicalSortUtil(i, visited, stack);
			}
			// Push current vertex to stack which stores result
			stack.push(new Integer(v));
		}

		// The function to do Topological Sort. It uses
		// recursive topologicalSortUtil()
		public Stack<Integer> topologicalSort() {
			Stack<Integer> stack = new Stack<>();

			// Mark all the vertices as not visited
			boolean visited[] = new boolean[V];
			for (int i = 0; i < V; i++)
				visited[i] = false;

			// Call the recursive helper function to store
			// Topological Sort starting from all vertices
			// one by one
			for (int i = 0; i < V; i++)
				if (visited[i] == false)
					topologicalSortUtil(i, visited, stack);

			return stack;
		}
	}

	static class InputReader {

		InputStream is = System.in;
		byte[] inbuf = new byte[1 << 23];
		int lenbuf = 0, ptrbuf = 0;

		public InputReader() throws IOException {
			lenbuf = is.read(inbuf);
		}

		public int readByte() {

			if (ptrbuf >= lenbuf) {
				return -1;
			}

			return inbuf[ptrbuf++];
		}

		public boolean hasNext() {
			int t = skip();

			if (t == -1) {
				return false;
			}
			ptrbuf--;
			return true;
		}

		public StringBuilder printIntArr(int[] ar, int n) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < n; i++) {
				res.append(ar[i] + " ");
			}
			res.append("\n");
			return res;
		}

		public boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		public int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public char nextChar() {
			return (char) skip();
		}

		public String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public char[] ns(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		public char[][] nm(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++) {
				map[i] = ns(m);
			}
			return map;
		}

		public int[][] nmInt(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = nextInt();
				}
			}
			return map;
		}

		public long[][] nmLong(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = nextLong();
				}
			}
			return map;
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		public long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

	}
}
