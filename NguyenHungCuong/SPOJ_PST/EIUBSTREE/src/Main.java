import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputReader scan = new InputReader(System.in);
		StringBuilder res = new StringBuilder();
		int n = scan.nextInt();
		long counter = 0;
		TreeSet<Node> nodes = new TreeSet<>();
		nodes.add(new Node(scan.nextInt()));
		res.append(counter + "\n");
		while (n-- > 1) {
			Node node = new Node(scan.nextInt());
			Node floor = nodes.floor(node);
			Node ceil = nodes.ceiling(node);
			if (floor != null && ceil != null) {
				if (!floor.right) {
					floor.right = true;
					node.level = floor.level + 1;
				}
				if (!ceil.left) {
					ceil.left = true;
					node.level = ceil.level + 1;
				}
			} else if (floor == null) {
				node.level = ceil.level + 1;
				ceil.left = true;
			} else {
				node.level = floor.level + 1;
				floor.right = true;
			}
			nodes.add(node);
			counter += node.level;
			res.append(counter + "\n");
		}
		System.out.println(res);
	}

	static class Node implements Comparable<Node> {
		public int value;
		public int level = 0;
		public boolean left = false;
		public boolean right = false;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public int compareTo(Node other) {
			return this.value - other.value;
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
