import java.io.*;
import java.util.*;

public class PHANBO_CHIPHI {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		int nNode = reader.nextInt();
		long M = reader.nextLong();
		Node[] nodes = ReadTree(nNode, M);
		dfs(nodes[0]);
		for (int i = 0; i < nNode; i++) {
			System.out.println(Math.round(nodes[i].roseMoney));
		}
	}

	public static Node[] ReadTree(int nNode, long M) {
		Node[] nodes = new Node[nNode];
		for (int i = 0; i < nNode; i++) {
			nodes[i] = new Node(i);
			if (i == 0) {
				nodes[i].roseMoney = M;
			} else {
				nodes[i].roseMoney = reader.nextDouble();
			}
		}
		for (int i = 0; i < nNode - 1; i++) {
			int u = reader.nextInt();
			int v = reader.nextInt();
			nodes[u].AddNeighbors(nodes[v]);

		}
		return nodes;

	}

	public static void dfs(Node u) {
		u.visited = true;
		for (Node v : u.neighbors) {
			if (!v.visited) {
				v.roseMoney = (u.roseMoney / 100) * v.roseMoney;
				dfs(v);
			}
		}
	}

	static class Node {
		public int Id;
		public double percent;
		public double roseMoney;
		public boolean visited = false;
		private List<Node> neighbors = new ArrayList<Node>();

		public Node(int id) {
			Id = id;
		}

		public void AddNeighbors(Node child) {
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