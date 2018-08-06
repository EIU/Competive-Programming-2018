
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder res = new StringBuilder();
		int test = scan.nextInt();
		while (test-- > 0) {
			int order = scan.nextInt();
			PriorityQueue<Share> sell = new PriorityQueue<>();
			PriorityQueue<Share> buy = new PriorityQueue<>();
			for (int i = 0; i < order; i++) {
				String type = scan.next();
				int amount = scan.nextInt();
				scan.next();
				scan.next();
				int price = scan.nextInt();
				if (type.equals("buy")) {
					buy.add(new Share(amount, price, i));
				} else {
					sell.add(new Share(amount, -price, i));
				}
				int deal = -1;
				while (!sell.isEmpty() && !buy.isEmpty()) {
					Share minSell = sell.peek();
					Share maxBuy = buy.peek();
					if (maxBuy.price >= Math.abs(minSell.price)) {
						deal = Math.abs(minSell.price);
						if (maxBuy.amount > minSell.amount) {
							maxBuy.amount -= minSell.amount;
							sell.remove();
						} else if (maxBuy.amount < minSell.amount) {
							minSell.amount -= maxBuy.amount;
							buy.remove();
						} else {
							sell.remove();
							buy.remove();
						}
					} else {
						break;
					}
				}
				res.append(sell.isEmpty() ? "-" : Math.abs(sell.peek().price)).append(" ")
						.append(buy.isEmpty() ? "-" : buy.peek().price).append(" ").append(deal == -1 ? "-" : deal)
						.append("\n");
			}
		}
		System.out.println(res);
	}

	public static class Share implements Comparable<Share> {
		int amount;
		int price;
		int time;

		public Share(int amount, int price, int time) {
			this.amount = amount;
			this.price = price;
			this.time = time;
		}

		@Override
		public int compareTo(Share other) {
			int res = this.price - other.price;
			if (res == 0) {
				res = this.time - other.time;
			}
			return res;
		}
	}

	static class InputReader {

		InputStream is = System.in;
		byte[] inbuf = new byte[1 << 23];
		int lenbuf = 0, ptrbuf = 0;

		public InputReader() throws IOException {
			lenbuf = is.read(inbuf);
		}

		public int readByte() {

			if (ptrbuf >= lenbuf) {
				return -1;
			}

			return inbuf[ptrbuf++];
		}

		public boolean hasNext() {
			int t = skip();

			if (t == -1) {
				return false;
			}
			ptrbuf--;
			return true;
		}

		public boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		public int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public char nextChar() {
			return (char) skip();
		}

		public String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public char[] ns(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		public char[][] nm(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++) {
				map[i] = ns(m);
			}
			return map;
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		public long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

	}
}
