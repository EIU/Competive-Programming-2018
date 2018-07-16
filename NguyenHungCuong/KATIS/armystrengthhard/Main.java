
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);

		StringBuilder result = new StringBuilder();
		int testcases = scan.nextInt();
		while (testcases-- > 0) {
			int numGod = scan.nextInt();
			int numMecha = scan.nextInt();
			int maxStrengthGodzilla = maxArray(numGod, scan);
			int maxStrengthMecha = maxArray(numMecha, scan);

			result.append((maxStrengthGodzilla >= maxStrengthMecha) ? "Godzilla\n" : "MechaGodzilla\n");
		}

		System.out.println(result);
	}

	static int maxArray(int n, InputReader scan) {
		int max = -1;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, scan.nextInt());
		}
		return max;
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
