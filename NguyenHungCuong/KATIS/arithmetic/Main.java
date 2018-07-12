
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		StringBuilder result = new StringBuilder();

		String octa = scan.next();
		StringBuilder hexa = new StringBuilder();
		for (int i = 0; i < octa.length(); i++) {
			String binary = Integer.toBinaryString(octa.charAt(i) - 48);
			hexa.append((binary.length() == 1) ? "00" + binary : (binary.length() == 2) ? "0" + binary : binary);
		}
		int index = hexa.length() - 1;
		while (index > 3) {
			result.append(Integer.toString(Integer.parseInt(hexa.substring(index - 3, index + 1), 2), 16));
			index -= 4;
		}
		;
		result = result.append(Integer.toString(Integer.parseInt(hexa.substring(0, index + 1), 2), 16)).reverse();
		index = 0;
		while (index < result.length() && result.charAt(index) == '0') {
			index++;
		}
		if (result.length() == 1) {
			System.out.println(result);
			return;
		}
		System.out.println(result.substring(index, result.length()).toString().toUpperCase());
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

		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for (int i = 0; i < n; i++) {
				res[i] = Integer.parseInt(next());
			}
			return res;
		}

		public int[][] nextIntMatrix(int n, int m) {
			int[][] res = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					res[i][j] = Integer.parseInt(next());
				}
			}
			return res;
		}
	}

//	static class InputReader {
//
//		InputStream is = System.in;
//		byte[] inbuf = new byte[1 << 23];
//		int lenbuf = 0, ptrbuf = 0;
//
//		public InputReader() throws IOException {
//			lenbuf = is.read(inbuf);
//		}
//
//		public int readByte() {
//
//			if (ptrbuf >= lenbuf) {
//				return -1;
//			}
//
//			return inbuf[ptrbuf++];
//		}
//
//		public boolean hasNext() {
//			int t = skip();
//
//			if (t == -1) {
//				return false;
//			}
//			ptrbuf--;
//			return true;
//		}
//
//		public boolean isSpaceChar(int c) {
//			return !(c >= 33 && c <= 126);
//		}
//
//		public int skip() {
//			int b;
//			while ((b = readByte()) != -1 && isSpaceChar(b))
//				;
//			return b;
//		}
//
//		public double nextDouble() {
//			return Double.parseDouble(next());
//		}
//
//		public char nextChar() {
//			return (char) skip();
//		}
//
//		public String next() {
//			int b = skip();
//			StringBuilder sb = new StringBuilder();
//			while (!(isSpaceChar(b))) {
//				sb.appendCodePoint(b);
//				b = readByte();
//			}
//			return sb.toString();
//		}
//
//		public char[] ns(int n) {
//			char[] buf = new char[n];
//			int b = skip(), p = 0;
//			while (p < n && !(isSpaceChar(b))) {
//				buf[p++] = (char) b;
//				b = readByte();
//			}
//			return n == p ? buf : Arrays.copyOf(buf, p);
//		}
//
//		public char[][] nm(int n, int m) {
//			char[][] map = new char[n][];
//			for (int i = 0; i < n; i++) {
//				map[i] = ns(m);
//			}
//			return map;
//		}
//
//		public int[] na(int n) {
//			int[] a = new int[n];
//			for (int i = 0; i < n; i++) {
//				a[i] = nextInt();
//			}
//			return a;
//		}
//
//		public int nextInt() {
//			int num = 0, b;
//			boolean minus = false;
//			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//				;
//			if (b == '-') {
//				minus = true;
//				b = readByte();
//			}
//
//			while (true) {
//				if (b >= '0' && b <= '9') {
//					num = num * 10 + (b - '0');
//				} else {
//					return minus ? -num : num;
//				}
//				b = readByte();
//			}
//		}
//
//		public long nextLong() {
//			long num = 0;
//			int b;
//			boolean minus = false;
//			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//				;
//			if (b == '-') {
//				minus = true;
//				b = readByte();
//			}
//
//			while (true) {
//				if (b >= '0' && b <= '9') {
//					num = num * 10 + (b - '0');
//				} else {
//					return minus ? -num : num;
//				}
//				b = readByte();
//			}
//		}
//
//		public int[] nextIntArray(int n) {
//			int[] res = new int[n];
//			for (int i = 0; i < n; i++) {
//				res[i] = Integer.parseInt(next());
//			}
//			return res;
//		}
//
//		public int[][] nextIntMatrix(int n, int m) {
//			int[][] res = new int[n][m];
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					res[i][j] = Integer.parseInt(next());
//				}
//			}
//			return res;
//		}
//
//	}
}
