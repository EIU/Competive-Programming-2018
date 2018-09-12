import java.io.*;
import java.util.*;

class EIULOGGING3_So_Cach_Chat_Cay {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int number = reader.nextInt();
		long a = 0, b = 0, countA = 1, countB = 1, acc = 0, temp = 0, tempCount = 0;
		for (int i = 0; i < number; i++) {
			temp = b;
			tempCount = countB;
			if (a + (acc = reader.nextLong()) > b) {
				b = a + acc;
				countB = countA;
			} else
				countB = a + acc == b ? (countB + countA) % 1000000007 : countB;
			a = temp;
			countA = tempCount;
		}
		System.out.print(b + " " + countB);

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
