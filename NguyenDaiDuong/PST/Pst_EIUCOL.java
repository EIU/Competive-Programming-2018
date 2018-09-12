import java.io.*;
import java.util.*;

class EIUCOL_SInh_Hoat {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int amountOfMoney = reader.nextInt();
		int[] money = { reader.nextInt(), reader.nextInt(), reader.nextInt() };
		int[] arr = new int[amountOfMoney + 1];
		boolean[] arr2 = new boolean[amountOfMoney + 1];
		arr2[0] = true;
		for (int i = 0; i < arr.length; i++)
			if (arr2[i])
				for (int j : money)
					if (i + j <= amountOfMoney) {
						arr[i + j] = Math.max(arr[i + j], arr[i] + 1);
						arr2[i + j] = true;
					}
		System.out.print(arr[amountOfMoney]);
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
