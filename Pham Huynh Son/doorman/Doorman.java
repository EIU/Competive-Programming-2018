import java.io.*;
import java.util.*;

public class Doorman {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);

		int t = reader.nextInt();
		// StringBuilder strBuilder = new StringBuilder();
		String queue = reader.next();
		String listP[] = queue.split("");
		int men = 0, women = 0;
		for (int i = 0; i < listP.length; i++) {
			if (Math.abs(men - women) > t && i != 0) {
				men--;
				break;
			}
			if(listP.length>2&&i==0&&!listP[0].equals(listP[i+1])&&listP[i+2].equals(listP[i+1])) {
				String j = listP[i];
				listP[i] = listP[i + 1];
				listP[i + 1] = j;
			}				
			if (listP[i].equals("M")) {
				if (i != 0 && i < listP.length - 1 && listP[i - 1].equals("M") && listP[i + 1].equals("W")) {
					String j = listP[i];
					listP[i] = listP[i + 1];
					listP[i + 1] = j;
					women++;

				} else
					men++;
			} else
				women++;
		}
		System.out.println(men + women);
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
