import java.io.*;
import java.util.*;

class Main {
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		System.out.println(readGraph(scan.nextInt(), scan));
	}
	
	static int dfs(String father,String keyWord, HashMap<String, ArrayList<String>> map,StringBuilder result) {
		if (map.get(father).isEmpty()) {
			return father.contains(keyWord)?1:0;
		}
		int contains = 0;
		for (String son : map.get(father)) {
			map.get(son).remove(father);
			contains += dfs(son,keyWord,map,result);	
		}
		if (contains != 0) {
			result.append(father + " " + contains+"\n");
		}
		return contains;
	}
	
	static StringBuilder readGraph(int n, InputReader scan){
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
		StringBuilder result = new StringBuilder();
		String father = scan.next();
		String keyWord = scan.next();
		dfs(father,keyWord,map,result);
		
		return result;
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
