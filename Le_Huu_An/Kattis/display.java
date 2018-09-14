package Week2_3;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Digital_display {
	public static String[] displayTime(String key) {
		String[] zero = { "+---+", "|   |", "|   |", "+   +", "|   |", "|   |", "+---+" };
		String[] one = { "    +", "    |", "    |", "    +", "    |", "    |", "    +" };
		String[] two = { "+---+", "    |", "    |", "+---+", "|    ", "|    ", "+---+" };
		String[] three = { "+---+", "    |", "    |", "+---+", "    |", "    |", "+---+" };
		String[] four = { "+   +", "|   |", "|   |", "+---+", "    |", "    |", "    +" };
		String[] five = { "+---+", "|    ", "|    ", "+---+", "    |", "    |", "+---+" };
		String[] six = { "+---+", "|    ", "|    ", "+---+", "|   |", "|   |", "+---+" };
		String[] seven = { "+---+", "    |", "    |", "    +", "    |", "    |", "    +" };
		String[] eight = { "+---+", "|   |", "|   |", "+---+", "|   |", "|   |", "+---+" };
		String[] nine = { "+---+", "|   |", "|   |", "+---+", "    |", "    |", "+---+" };
		String[] o = { " ", " ", "o", " ", "o", " ", " " };
		switch (key) {
		case "1":
			return one;
		case "2":
			return two;
		case "3":
			return three;
		case "4":
			return four;
		case "5":
			return five;
		case "6":
			return six;
		case "7":
			return seven;
		case "8":
			return eight;
		case "9":
			return nine;
		case "0":
			return zero;
		}
		return o;
	}

	public static void main(String[] args) throws Exception {
		InputReader reader = new InputReader(System.in);
		while (reader.hasNext()) {
			String line = reader.next();
			if (line.equals("end")) {
				System.out.println("end");
				break;
			}
			String[] s = line.split("");
			for (int j = 0; j < 7; j++) {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < s.length - 1; ++i) {
					builder.append(displayTime(s[i])[j] + "  ");
				}
				builder.append(displayTime(s[s.length - 1])[j]);
				System.out.println(builder);
			}
			System.out.println();
			System.out.println();
		}
	}

	static class InputReader {
		private byte[] inbuf = new byte[2 << 23];
		public int lenbuf = 0, ptrbuf = 0;
		public InputStream is;

		public InputReader(InputStream stream) throws IOException {

			inbuf = new byte[2 << 23];
			lenbuf = 0;
			ptrbuf = 0;
			is = System.in;
			lenbuf = is.read(inbuf);
		}

		public InputReader(FileInputStream stream) throws IOException {
			inbuf = new byte[2 << 23];
			lenbuf = 0;
			ptrbuf = 0;
			is = stream;
			lenbuf = is.read(inbuf);
		}

		public boolean hasNext() throws IOException {
			if (skip() >= 0) {
				ptrbuf--;
				return true;
			}
			return false;
		}

		public String nextLine() throws IOException {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!isSpaceChar(b) && b != ' ') {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
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

		private int readByte() {
			if (lenbuf == -1)
				throw new InputMismatchException();
			if (ptrbuf >= lenbuf) {
				return -1;
			}
			return inbuf[ptrbuf++];
		}

		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		private double nextDouble() {
			return Double.parseDouble(next());
		}

		public Character nextChar() {
			return skip() >= 0 ? (char) skip() : null;
		}

		private int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b)) {
				;
			}
			return b;
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
