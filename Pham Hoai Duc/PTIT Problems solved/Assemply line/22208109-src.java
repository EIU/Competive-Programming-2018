
import java.util.*;
import java.io.*;
class Robot{
    long p;
    long m;

    public Robot(long p, long m) {
        this.p = p;
        this.m = m;
    }
}
public class Main {
    static boolean readFile = false;

        public static long binarySearch(Robot[] arr, long start, long end, long result, long budget){
            if(start < end){
                long mid = (start + end) / 2;
                if (solve(arr, budget, mid)) {
                    result = Math.max(mid, result);
                    return binarySearch(arr, mid + 1, end, result, budget);
                } else {
                    return binarySearch(arr, start, mid, result, budget);
                }
            }
            return result;
        }
        public static boolean solve(Robot[] arr, long budget, long mid){
            long cost = 0;
            for(int i = 0 ; i < arr.length; ++i){
                long p = mid - arr[i].p;
                if(p > 0)
                    cost += p*arr[i].m;
                if(cost > budget)
                    return false;
            }
            return true;
        }
	public static void main(String[] args) throws IOException {
	    InputReader ip = new InputReader();
            StringBuilder builder = new StringBuilder();
            int T = ip.nextInt();
            for(int t = 0; t < T; ++t){
                int n = ip.nextInt();
                long budget = ip.nextLong();
                Robot[] arr = new Robot[n];
                for(int i = 0; i < n; ++i){
                    arr[i] = new Robot(ip.nextLong(), ip.nextLong());
                }
                builder.append(binarySearch(arr, 0, 1000000000000L, -1, budget)+"\n");
            }
            System.out.print(builder);
    }
	static class InputReader {
		InputStream is = System.in;
		byte[] inbuf = new byte[1 << 24];
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
			while ((b = readByte()) != -1 && isSpaceChar(b));
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
			for (int i = 0; i < n; i++)
				map[i] = ns(m);
			return map;
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
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
