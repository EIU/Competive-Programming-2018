import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class army_Strength {
	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);
		StringBuilder strBuilder = new StringBuilder();
		int t = input.nextInt();

		while (t > 0) {
			t--;
			List<Long> godz = new ArrayList<Long>();
			List<Long> mega = new ArrayList<Long>();
			int g = input.nextInt();
			int m = input.nextInt();
			boolean f = true;
			for (int i = 0; i < g; i++) {
				godz.add(input.nextLong());
			}
			for (int i = 0; i < m; i++) {
				mega.add(input.nextLong());
			}
			
			long maxG = Collections.max(godz);
			long maxM = Collections.max(mega);
			strBuilder.append((maxG>=maxM)?"Godzilla":"MechaGodzilla").append("\n");
		}
		System.out.println(strBuilder);
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
