import java.io.*;
import java.util.*;

public class Main {
	static int[] array;

	static int RSQ(int ind) {
		int sum = 0;
		while (ind > 0) {
			sum += array[ind];
			ind -= ind & (-ind);
		}
		return sum;
	}

	static int rsq(int a, int b) {
		return RSQ(b) - RSQ(a - 1);
	}

	static void update(int ind, int value) {
		while (ind < array.length) {
			array[ind] += value;
			ind += ind & (-ind);
		}
	}

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder res = new StringBuilder();
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n+1];
		array = new int[n + 1];
		for (int i = 0; i < m; i++) {
			char cmd = scan.nextChar();
			if (cmd == 'F') {
				int index = scan.nextInt();
				if (arr[index] == 0) {
					arr[index] = 1;
					update(index, 1);
				} else {
					arr[index] = 0;
					update(index, -1);
				}
			} else {
				res.append(rsq(scan.nextInt(), scan.nextInt()) + "\n");
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