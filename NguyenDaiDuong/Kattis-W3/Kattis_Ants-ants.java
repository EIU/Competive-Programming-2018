import java.io.*;
import java.util.*;

class Ants {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int numberOfTest = reader.nextInt();
		for (int i = 0; i < numberOfTest; i++) {
			int lengthOfPole = reader.nextInt();
			int numberOfAnts = reader.nextInt();
			int latestTime = 0, earliestTime = 0;
			for (int j = 0; j < numberOfAnts; j++) {
				int left = reader.nextInt();
				int right = lengthOfPole - left;
				earliestTime=Math.max(Math.min(left, right), earliestTime);
				latestTime=Math.max(Math.max(left, right), latestTime);
			}
			System.out.println(earliestTime + " " + latestTime);
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