import java.io.*;
import java.util.*;

class Main {
	static HashMap<String, Pair> hm;
	static String destination;
	static ArrayList<String> res = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		hm = new HashMap<>();
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			String[] nodes = scan.nextLine().split(" ");
			String father = nodes[0];
			Pair p = hm.containsKey(father) ? hm.get(father) : new Pair(father);
			for (int j = 1; j < nodes.length; j++) {
				p.add(nodes[j]);
				if (!hm.containsKey(nodes[j]))
					hm.put(nodes[j], new Pair(nodes[j]));
				hm.get(nodes[j]).add(father);
			}
			hm.put(father, p);
		}
		String start = scan.next();
		destination = scan.next();
		if (hm.get(start) != null && dfs(hm.get(start))) {
			for (int i = res.size() - 1; i >= 0; i--) {
				System.out.print(res.get(i) + " ");
			}
		} else {
			System.out.println("no route found");
		}
	}

	static boolean dfs(Pair current) {
		current.visited = true;
		if (current.id.equals(destination)) {
			res.add(current.id);
			return true;
		}
		boolean found = false;
		for (String i : current.list) {
			Pair next = hm.get(i);
			if (next != null && !next.visited) {
				found |= dfs(next);
			}
		}
		if (found)
			res.add(current.id);
		return found;
	}

	static class Pair {
		String id;
		boolean visited = false;
		ArrayList<String> list = new ArrayList<>();

		public Pair(String id) {
			this.id = id;
		}

		public void add(String child) {
			this.list.add(child);
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
