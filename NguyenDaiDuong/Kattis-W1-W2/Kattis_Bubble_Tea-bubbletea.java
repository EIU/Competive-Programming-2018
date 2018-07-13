import java.io.*;
import java.util.*;

class Tea {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int numberOfTea = reader.nextInt();
		int[] arrNumberOfTea = new int[numberOfTea];
		int i = 0;
		for (; i < numberOfTea; i++) {
			arrNumberOfTea[i] = reader.nextInt();
		}
		int numberOfTopping = reader.nextInt();
		int[] arrNumberOfTopping = new int[numberOfTopping];
		for (i = 0; i < numberOfTopping; i++) {
			arrNumberOfTopping[i] = reader.nextInt();
		}
		int smallestPrice = 0;
		for (i = 0; i < numberOfTea; i++) {
			int suitableTopping = reader.nextInt();
			for (int j = 0; j < suitableTopping; j++) {
				int price = reader.nextInt();
				smallestPrice = i == 0 && j == 0 ? arrNumberOfTopping[price - 1] + arrNumberOfTea[i]
						: arrNumberOfTopping[price - 1] + arrNumberOfTea[i] < smallestPrice
								? arrNumberOfTopping[price - 1] + arrNumberOfTea[i]
								:smallestPrice;
			}
		}
		int amountOfMoney = reader.nextInt();
		System.out.println(amountOfMoney / smallestPrice - 1 < 0 ? 0 : amountOfMoney / smallestPrice - 1);
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
