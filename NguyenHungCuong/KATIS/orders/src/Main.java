
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		int n = scan.nextInt();
		int[] prices = new int[n];
		int[] pre = new int[30001];
		Arrays.fill(pre, -1);
		pre[0] = 0;
		for (int i = 0; i < n; i++) {
			prices[i] = scan.nextInt();
			for (int j = 0; j + prices[i] < 30001; j++) {
				if (pre[j] != -1) {
					if (pre[j] == n || pre[j + prices[i]] != -1) {
						pre[j + prices[i]] = n;
					} else {
						pre[j+prices[i]] = i;
					}
				}
			}
		}
		int m = scan.nextInt();
		StringBuilder res = new StringBuilder();
		while (m-->0) {
			int money = scan.nextInt();
			if (pre[money] == n) {
				res.append("Ambiguous\n");
			} else if (pre[money] == -1) {
				res.append("Impossible\n");
			} else {
				ArrayList<Integer> order = new ArrayList<>();
				while (money > 0) {
					order.add(pre[money]+1);
					money -= prices[pre[money]];
				}
				for (int i=order.size()-1;i>=0;i--) {
					res.append(order.get(i)+" ");
				}
				res.append("\n");
			}
		}
		System.out.println(res);
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
