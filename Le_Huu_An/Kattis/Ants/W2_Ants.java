import java.io.*;
import java.util.*;

public class W2_Ants {

	public static void main(String[] args) {

		InputReader reader = new InputReader(System.in);
		int nCase = reader.nextInt();
		for (int i = 0; i < nCase; i++) {
			int Earliest = 0;
			int Latest = 0;
			int rs = 0;
			int rs2 = 0;
			StringBuilder builder = new StringBuilder();
			int poleLenght = reader.nextInt();
			int nAnts = reader.nextInt();
			for (int j = 0; j < nAnts; j++) {
				int antPosition = reader.nextInt();
				rs = Math.max(antPosition, poleLenght - antPosition);
				if (rs > Latest) {
					Latest = rs;
				}
				rs2 = Math.min(antPosition, poleLenght - antPosition);
				if (rs2 > Earliest) {
					Earliest = rs2;
				}
			}
			builder.append(Earliest + " " + Latest);
			System.out.println(builder);
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