import java.io.*;
import java.util.*;

public class EIULOGGING2 {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);
		HashMap<Integer, Long> hmap = new HashMap<>();
		int n = reader.nextInt();
		if (n == 0)
			System.out.println("0");
		else {
			long[] list = new long[n];
			long[] list2 = new long[n];
			for (int i = 0; i < n; i++) {
				long m = reader.nextLong();
				list[i] = m >= 0 ? m : 0;
				if (i == 0) {
					list2[0] = list[0];
					hmap.put(0, 1L);
					hmap.put(1, 1L);
				} else {
					long temp = list[i] != 0 ? ((i - 2) >= 0 ? list[i] + list2[i - 2] : Math.max(list[i], list2[i - 1]))
							: list2[i - 1];
					list2[i] = temp > list2[i - 1] ? temp : list2[i - 1];
					if (i - 2 > 0) {
						if (list2[i - 2] == list2[i - 3]) {
							hmap.put(i, hmap.get(i - 2) + hmap.get(i - 3));
						} else
							hmap.put(i, hmap.get(i - 2));
					} else if (i - 2 == 0)
						hmap.put(i, hmap.get(i - 2));

				}
			}
			long t = hmap.get(n - 1) % 1000000007;
			System.out.println(list2[n - 1] + " " + t);
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
