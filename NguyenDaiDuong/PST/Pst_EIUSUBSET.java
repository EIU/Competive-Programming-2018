import java.io.*;
import java.util.*;

class EIUSUBSET {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder builder = new StringBuilder();
		int numberOfN = reader.nextInt();
		int[] tempArr = new int[numberOfN];
		for (int i = 0; i < numberOfN; i++) {
			tempArr[i] = reader.nextInt();
		}
		int n = (1 << numberOfN) - 1;
		builder.append(n + "\n");
		for (int i = 1; i <= n; i++) {
			String acc = Integer.toBinaryString(i);
			while (acc.length() < numberOfN)
				acc = 0 + acc;
			char[] arr = acc.toCharArray();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '1')
					builder.append(tempArr[j] + " ");
			}
			builder.append("\n");
		}
		System.out.print(builder);
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
