import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		ArrayList<Move> list = new ArrayList<>();
		int startX = 0, startY = 0;
		int x = 0, y = 0;
		int bottom = 0, top = 0, left = 0, right = 0;
		while (scan.hasNext()) {
			String step = scan.next();
			x += (step.equals("down")?1:step.equals("up")?-1:0);
			y += (step.equals("right")?1:step.equals("left")?-1:0);
			bottom = Math.max(bottom, x);
			right = Math.max(right, y);
			top = Math.min(top, x);
			left = Math.min(left, y);
			startX += ((x < 0 && step.equals("up")) ? 1 : 0);
			startY += ((y < 0 && step.equals("left")) ? 1 : 0);
			list.add(new Move(x, y));
		}
		startX++;
		startY++;
		int row = bottom - top + 3, col = right - left + 3;
		char[][] out = new char[row][col];
		for (char[] i : out) {
			Arrays.fill(i, ' ');
		}
		for (Move i : list) {
			out[i.x + startX][i.y + startY] = '*';
		}
		out[startX][startY] = 'S';
		out[x + startX][y + startY] = 'E';
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
					res.append("#");
				} else {
					res.append(out[i][j]);
				}
			}
			res.append("\n");
		}
		System.out.print(res);
	}

	static class Move {
		int x;
		int y;

		public Move(int x, int y) {
			this.x = x;
			this.y = y;
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
