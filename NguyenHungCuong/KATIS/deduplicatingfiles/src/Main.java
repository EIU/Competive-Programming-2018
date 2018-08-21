import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder result = new StringBuilder();
		InputReader scan = new InputReader(System.in);
		int testcases;
		while ((testcases = scan.nextInt()) != 0) {
			Set<String> uniqueFiles = new HashSet<String>();
			List<String> files = new ArrayList<String>();
			for (int i = 0; i < testcases; i++) {
				String filecontent = scan.nextLine();
				uniqueFiles.add(filecontent);
				files.add(filecontent);
			}
			int collision = 0;
			for (int i = 0; i < testcases; i++) {
				String file1 = files.get(i);
				int hash1 = hash(file1);
				for (int j = i + 1; j < testcases; j++) {
					String file2 = files.get(j);
					int hash2 = hash(file2);
					if (hash1 == hash2 && !file1.equals(file2))
						collision++;
				}
			}
			result.append(uniqueFiles.size() + " " + collision + "\n");
		}
		System.out.println(result);
	}

	public static int hash(String file) {
		int hash = 0;
		for (int i = 0; i < file.length(); i++) {
			hash ^= (int) file.charAt(i);
		}
		return hash;
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
