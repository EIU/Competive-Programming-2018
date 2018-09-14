import java.io.*;
import java.util.*;

public class Coloring_Socks {

	public static void main(String[] args) {

		InputReader reader = new InputReader(System.in);
		int sSocks = reader.nextInt();
		int cLimitSocks = reader.nextInt();
		int kLimitColors = reader.nextInt();
		int nMachines = 0;
		int[] arrColors = new int[sSocks];
		for (int i = 0; i < sSocks; ++i) {
			arrColors[i] = reader.nextInt();
		}
		Arrays.sort(arrColors);
		for (int i = 0; i < sSocks; i++) {
			int firstSock = i;
			int count = i;
			for (; i < sSocks; i++) {
				if (i - firstSock < cLimitSocks && arrColors[i] - arrColors[firstSock] <= kLimitColors) {
					count++;
				} else {
					count--;
					break;
				}
			}
			nMachines++;
			i = count;
		}
		System.out.println(nMachines);
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