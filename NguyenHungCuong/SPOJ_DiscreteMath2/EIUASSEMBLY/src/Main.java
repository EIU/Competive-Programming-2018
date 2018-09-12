
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
			Arrays.sort(robots);
			long low = 0, high = 1000000000000l, middle = high / 2;
			long[] cost;
			while (low <= high) {
				middle = low + (high - low) / 2;
				cost = calc(robots, middle, middle + 1);
				if (cost[0] <= budget && cost[1] > budget)
					break;
				if (cost[0] < budget)
					low = middle + 1;
				else
					high = middle - 1;
			}
			result.append(middle + "\n");
		}
		System.out.println(result);
	}

	static long[] calc(Robot[] robots, long productivity, long other) {
		long res1 = 0, res2 = 0;
		for (Robot rb : robots) {
			if (rb.productivity > other)
				break;
			res1 += Math.max(0, (productivity - rb.productivity) * rb.cost);
			res2 += Math.max(0, (other - rb.productivity) * rb.cost);
		}
		return new long[] { res1, res2 };
	}

	static class Robot implements Comparable<Robot> {
		public long productivity;
		public long cost;

		public Robot(long products, long money) {
			this.productivity = products;
			this.cost = money;
		}

		@Override
		public int compareTo(Robot other) {
			return Long.compare(this.productivity, other.productivity);
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
