
import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader(System.in);
		StringBuilder result = new StringBuilder();
		int testcases = scan.nextInt();
		String input;
		while (testcases-- > 0) {
			input = scan.next() + scan.next() + scan.next();// concatenate strings into one single string for comparing
			for (int i = 0; i < 512; i++) {
				if (input.toString().equals(bitToString(i))) {
					result.append(Integer.bitCount(i)).append("\n");
					break;
				}
			}
		}

		System.out.println(result);
	}

	static String bitToString(int n) {
		char[] puzzle = new char[9];// all white puzzle
		int[] bitsTurn = new int[5];
		Arrays.fill(puzzle, '.');
		for (int i = 0; i < 9; i++) {
			if (((n >> i) & 1) == 1) {// if bit i-th is 1 meaning the i-th block is clicked
				int row = i / 3;// get the row and column to find the 4 blocks around
				int col = i % 3;
				bitsTurn[0] = i;
				bitsTurn[1] = ((row - 1) >= 0) ? (row - 1) * 3 + col : -1;// find the other 4 blocks if exist
				bitsTurn[2] = (col + 1 <= 2) ? row * 3 + col + 1 : -1;
				bitsTurn[3] = ((row + 1) <= 2) ? (row + 1) * 3 + col : -1;
				bitsTurn[4] = (col - 1 >= 0) ? row * 3 + col - 1 : -1;
				for (int k = 0; k < 5; k++) {
					if (bitsTurn[k] != -1) {
						puzzle[bitsTurn[k]] = (puzzle[bitsTurn[k]] == '.') ? '*' : '.';
					}
				}
			}
		}
		return new String(puzzle);
	}

	static int[] nextIntArray(InputReader scan, int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = scan.nextInt();
		}
		return res;
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
