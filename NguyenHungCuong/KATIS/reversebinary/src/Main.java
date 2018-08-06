
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);

		StringBuilder result = new StringBuilder();
		int testcases = scan.nextInt();
		while (testcases-->0) {
			int n1 = scan.nextInt();
			int n2 = scan.nextInt();
			int[] cs = new int[n1];
			int[] e = new int[n2];
			for (int i=0;i<n1;i++) {
				cs[i] = scan.nextInt();
			}
			for (int i=0;i<n2;i++) {
				e[i] = scan.nextInt();
			}
			double avg1 = sumArray(cs, scan) / n1;
			double avg2 = sumArray(e, scan) / n2;
			int count = 0;
			for (int i : cs) {
				if (i > avg2 && i < avg1) {
					count++;
				}
			}
			result.append(count).append("\n");
		}
		System.out.println(result);
	}

	static double sumArray(int[] n, InputReader scan) {
		double sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
		}
		return sum;
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
