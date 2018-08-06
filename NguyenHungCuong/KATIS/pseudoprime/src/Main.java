import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder result = new StringBuilder();
		int p;
		int a;
		int[] primes = generatePrimes(33000);
		while ((p = scan.nextInt()) + (a = scan.nextInt()) != 0) {
			boolean isPrime = true;
			for (int i = 0; i < primes.length; i++) {
				if (primes[i] < p && p % primes[i] == 0) {
					isPrime = false;
					break;
				}
			}
			result.append((!isPrime && isPseudo(a, p)) ? "yes\n" : "no\n");
		}
		System.out.println(result);
	}

	static long powerMod(int x, int n, int k) {
		if (n == 0)
			return 1;
		long res = powerMod(x, n / 2, k);
		res = ((res * res) % k);
		if ((n & 1) == 1) {
			res = ((res * x) % k);
		}
		return res;
	}

	static boolean isPseudo(int a, int p) {
		long temp = a;
		long res = 1;
		int k = p;
		while (p > 0) {
			if ((p & 1) == 1) {
				res *= temp;
				res %= k;
			}
			p >>= 1;
			temp *= temp;
			temp %= k;
		}
		return res == a;
	}

	static int[] generatePrimes(int limit) {
		boolean[] check = new boolean[limit];
		int[] primes = new int[10000];
		int index = 0;
		for (int i = 2; i < limit; i++) {
			if (!check[i]) {
				primes[index++] = i;
				for (int j = i * i; j < limit; j += i) {
					check[j] = true;
				}
			}
		}
		return Arrays.copyOfRange(primes, 0, index);
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
