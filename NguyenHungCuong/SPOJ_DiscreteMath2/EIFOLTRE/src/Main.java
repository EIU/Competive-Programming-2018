import java.io.*;
import java.util.*;

class Main {
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);

		int n = scan.nextInt();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			String first = scan.next();
			String second = scan.next();
			if (!map.containsKey(first)) {
				map.put(first, new ArrayList<>());
			}
			if (!map.containsKey(second)) {
				map.put(second, new ArrayList<>());
			} 
			map.get(first).add(second);
			map.get(second).add(first);
		}
		for (ArrayList<String> i : map.values()) {
			i.sort((a,b)->a.compareToIgnoreCase(b));
		}

		String father = scan.next();
		result.append("-").append(father).append("\n");
		dfs(father,"-",map,result);
		
		System.out.println(result);
	}
	
	static void dfs(String father,String deg, HashMap<String, ArrayList<String>> map,StringBuilder result) {
		for (String son : map.get(father)) {
			map.get(son).remove(father);
			result.append(deg).append("---").append(son).append("\n");
			dfs(son,deg+"---",map,result);
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
