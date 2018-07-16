import java.io.*;
import java.util.*;

class Birds {

	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);
		int wireLength = reader.nextInt();
		int distance = reader.nextInt();
		int numberOfBirds = reader.nextInt() + 2;
		int sumOfBirds = 0;
		int[] location = new int[numberOfBirds];
		for (int i = 0; i < numberOfBirds; i++) {
			location[i] = i == 0 ? 6 : i == numberOfBirds - 1 ? wireLength - 6 : reader.nextInt();
		}
		Arrays.sort(location);
		for (int i = 0; i < numberOfBirds; i++)
			sumOfBirds = numberOfBirds == 2 ? ((wireLength - 12) / distance) + 1
					: i == 1 || i == numberOfBirds - 1 ? sumOfBirds + ((location[i] - location[i - 1]) / distance)
							: i > 0 ? sumOfBirds + ((location[i] - location[i - 1]) / distance) - 1 : sumOfBirds;
		System.out.print(sumOfBirds);
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