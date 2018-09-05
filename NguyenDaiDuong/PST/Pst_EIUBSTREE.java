import java.io.*;
import java.util.*;

class EIUBSTREE_BST {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder builder = new StringBuilder();
		TreeSet<Node> set = new TreeSet<>((v1, v2) -> v1.key - v2.key);
		int number = reader.nextInt();
		Node tempNode, lower, highter = null, rootNode;
		set.add((rootNode = new Node(reader.nextInt(), 0)));
		builder.append(rootNode.counter + "\n");
		for (int i = 1; i < number; i++) {
			highter = (highter = set.higher(tempNode = new Node(reader.nextInt(), 0))) == null ? new Node(0, 0)
					: highter;
			lower = (lower = set.lower(tempNode)) == null ? new Node(0, 0) : lower;
			if(lower.level>highter.level)
				builder.append((rootNode.counter += (tempNode.level = lower.level + 1)) + "\n");
			else
				builder.append((rootNode.counter += (tempNode.level = highter.level + 1)) + "\n");
			set.add(tempNode);
		}
		System.out.print(builder);
	}

	static class Node {
		int key;
		int level = 0;
		long counter = 0;

		public Node(int key, int level) {
			this.key = key;
			this.level = level;
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
