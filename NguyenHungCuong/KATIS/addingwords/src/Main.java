import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		HashMap<String, Integer> wordNumber = new HashMap<>();
		StringBuilder res = new StringBuilder();
		HashMap<Integer,String> numberWord = new HashMap<>();
		while (scan.hasNext()) {
			String cmd = scan.next();
			if (cmd.equals("def")) {
				String key = scan.next();
				int value = scan.nextInt();
				if (numberWord.containsKey(wordNumber.get(key))){
					numberWord.remove(wordNumber.get(key));
				}
				wordNumber.put(key, value);
				numberWord.put(value, key);
			} else if (cmd.equals("calc")) {
				boolean valid = true;
				int val = 0;
				
				String cur = scan.next();
				res.append(cur + " ");
				
				Integer num = wordNumber.get(cur);
				if (num == null) {
					valid = false;
				}
				if (valid)
					val = num;
				
				while (!(cur = scan.next()).equals("=")) {
					res.append(cur + " ");
					if (cur.equals("+")) {
						String next = scan.next();
						res.append(next + " ");
						num = wordNumber.get(next);
						if (num == null) valid = false;
						if (valid)
							val += num;
					} else if (cur.equals("-")) {
						String next = scan.next();
						res.append(next + " ");
						num = wordNumber.get(next);
						if (num == null) valid = false;
						if (valid)
							val -= num;
					}
				} // end while
				res.append(cur + " ");
				String ans = numberWord.get(val);
				if (valid && ans != null) {
					res.append(ans + "\n");
				} else {
					res.append("unknown\n");
				}
			} else {
				wordNumber.clear();
				numberWord.clear();
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
