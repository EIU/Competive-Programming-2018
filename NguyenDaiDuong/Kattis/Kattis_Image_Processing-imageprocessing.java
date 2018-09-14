import java.io.*;
import java.util.*;

class Radio {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int H = reader.nextInt(), W = reader.nextInt(), N = reader.nextInt(), M = reader.nextInt();
		int[][] arr = new int[H][W];
		int[] arr2 = new int[N * M];
		int[] arr3 = new int[(H - N + 1) * (W - M + 1)];
		for (int j = 0; j < H; j++)
			for (int i = 0; i < W; i++)
				arr[j][i] = reader.nextInt();
		for (int j = 0; j < N * M; j++)
			arr2[j] = reader.nextInt();
		int o = 0;
		for (int j = 0; j < H - N + 1; j++)
			for (int i = 0; i < W - M + 1; i++)
				arr3[o++] = calculate(arr, arr2, i, j, N, M);
		o = 0;
		for (int j = 0; j < H - N + 1; j++)
			for (int i = 0; i < W - M + 1; i++)
				System.out.print(arr3[o++] + " ");
		System.out.println();
	}

	static int calculate(int[][] arr, int[] arr2, int row, int colum, int N, int M) {
		int result = 0;
		int k = arr2.length - 1;
		for (int i = colum; i < colum + N; i++)
			for (int j = row; j < row + M; j++)
				result += arr[i][j] * arr2[k--];
		return result;
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