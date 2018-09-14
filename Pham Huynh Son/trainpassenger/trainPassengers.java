import java.io.*;
import java.util.*;

public class trainPassengers {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);

		int n = reader.nextInt();
		int m = reader.nextInt();
		int left, enter, stay;
		boolean f = true;
		int[][] train = new int[m][3];
		for (int i = 0; i < m; i++) {
			train[i][0] = reader.nextInt();
			train[i][1] = reader.nextInt();
			train[i][2] = reader.nextInt();
		}
		long pItTrain = 0;
		for (int i = 0; i < m; i++) {
			pItTrain += train[i][1];
			pItTrain -= train[i][0];
			if(pItTrain>n||pItTrain<0) {
				f=false;
				break;
			}else if(train[i][2]>0&&pItTrain<n) {
				f=false;
				break;
			}
		}

		if (train[m - 1][1] != 0 || train[m - 1][2] != 0 || (train[m - 2][1] != 0 && train[m - 1][0] == 0))
			f = false;
		else {
			for (int i = 1; i < m - 1; i++) {
				if ((train[i - 1][1] == 1 && train[i][0] == 0) || (train[i - 1][1] == 0 && train[i][0] == 1)) {
					f = false;
					break;
				} else if ((train[i - 1][1] == 0 && train[i][2] == 1) && train[i][1] == 0) {
					f = false;
					break;
				}
			}
		}

		if (f)
			System.out.println("possible");
		else
			System.out.println("impossible");
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
