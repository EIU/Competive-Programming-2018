import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);

		String s="konichiwa";
		char []sub=s.toCharArray();
		String input=reader.next();
		int j=0;
		for(int i=0;i<input.length();i++) {
			if(sub[j]==(input.charAt(i))) {
				j++;
				if(j==sub.length) break;
			}
		}
		if(j==sub.length)System.out.println("YES");
		else System.out.println("NO");

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
