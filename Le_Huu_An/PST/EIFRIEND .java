import java.io.*;
import java.util.*;

class EIFRIEND {

	public static void main(String[] args) throws IOException {

		InputReader reader = new InputReader(System.in);
		boolean check = false;
		List<Character> listCharOfPhrase = new ArrayList<Character>();
		List<Character> listCharOfGreeting = new ArrayList<Character>();
		StringBuilder builder = new StringBuilder();
		String greeting = "konichiwa";
		String phrase = reader.nextLine().toLowerCase();
		for (int i = 0; i < phrase.length(); i++) {
			listCharOfPhrase.add(phrase.charAt(i));
		}
		for (int i = 0; i < greeting.length(); i++) {
			listCharOfGreeting.add(greeting.charAt(i));
			if (listCharOfPhrase.contains(greeting.charAt(i))) {
				check = true;
				listCharOfPhrase.remove(listCharOfGreeting.get(i));
			} else {
				check = false;
				break;
			}
		}
		builder.append(check == true ? "YES" : "NO");
		System.out.println(builder);
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