import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		StringBuilder result = new StringBuilder();
		int testcases = scan.nextInt();
		while (testcases-- > 0) {
			int n = scan.nextInt();
			long budget = scan.nextLong();
			Robot[] robots = new Robot[n];
			for (int i = 0; i < n; i++) {
				robots[i] = new Robot(scan.nextLong(), scan.nextLong());
			}
			long low = 1, high = 1000000000000l, middle = 0, ans = -1;
			while (low <= high) {
				middle = (low + high) >> 1;
				if (calc(robots, middle, budget)) {
					ans = middle;
					low = middle + 1;
				} else {
					high = middle - 1;
				}
			}
			result.append(ans + "\n");
		}
		System.out.println(result);
	}

	static boolean calc(Robot[] robots, long productivity, long budget) {
		for (Robot rb : robots) {
			if (rb.productivity <= productivity) {
				if ((budget / rb.cost) < (productivity - rb.productivity))
					return false;
				budget -= (productivity - rb.productivity) * rb.cost;
			}
		}
		return (budget >= 0);
	}

	static class Robot {
		public long productivity;
		public long cost;

		public Robot(long products, long money) {
			this.productivity = products;
			this.cost = money;
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
