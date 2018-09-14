import java.io.*;
import java.util.*;

public class B3 {
	static InputReader reader;

	public static void main(String[] args) throws IOException {
		reader = new InputReader();
		while (reader.hasNext()) {
			int n = reader.nextInt();
			int[] input = new int[n];
			int[] output = new int[n];
			int count = 0;
			for (int i = 0; i < n; i++) {
				int in = reader.nextInt();
				input[i] = in;
				int out = reader.nextInt();
				output[i] = out;
			}
			String s = "impossible";
			if (checkStack(input, output) == true) {
				count++;
				s = "stack";
			}
			if (checkQueue(input, output)) {
				count++;
				s = "queue";
			}
			if (checkPQ(input, output)) {
				count++;
				s = "priority queue";
			}
			if (count > 1) {
				System.out.println("not sure");
			} else {
				System.out.println(s);
			}
		}

	}

	static boolean checkStack(int[] a, int[] b) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				list.add(b[i]);
			} else {
				if (list.size() == 0 || list.remove(list.size() - 1) != b[i]) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean checkPQ(int[] a, int[] b) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				list.add(b[i]);
			} else {
				Collections.sort(list);
				if (list.isEmpty() || list.remove(list.size() - 1) != b[i]) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean checkQueue(int[] a, int[] b) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				list.add(b[i]);
			} else {
				if (list.isEmpty() || list.remove(0) != b[i]) {
					return false;
				}
			}
		}
		return true;
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