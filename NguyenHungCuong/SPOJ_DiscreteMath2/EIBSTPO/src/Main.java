import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputReader scan = new InputReader(System.in);
		StringBuilder res = new StringBuilder();
		int n = scan.nextInt();
		TreeSet<Node> nodes = new TreeSet<>();
		Node start = new Node(scan.nextInt());
		nodes.add(start);
		while (n-- > 1) {
			Node node = new Node(scan.nextInt());
			Node floor = nodes.floor(node);
			if (floor != null && floor.right == null) {
				floor.right = node;
			} else {
				Node ceil = nodes.ceiling(node);
				if (ceil != null) {
					ceil.left = node;
				}
			}
			nodes.add(node);
		}
		post(start,res);
		System.out.println(res);
	}
	static void post(Node current,StringBuilder res) {
		if (current.left != null) {
			post(current.left,res);
		}
		if (current.right != null) {
			post(current.right,res);
		}
		res.append(current.value+" ");
	}

	static class Node implements Comparable<Node> {
		public int value;
		public Node left = null;
		public Node right = null;

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
