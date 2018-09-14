import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
    public static InputReader ip;    
    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        ip = new InputReader();
        int T = ip.nextInt();
		for (int t = 0; t < T; ++t) {
			int n = ip.nextInt();
			int k = ip.nextInt();
			long[] salary = new long[n];
			for (int i = 0; i < n; ++i) {
				salary[i] = ip.nextLong();
			}
			
			//solve here
			long[] dpNewSum = new long[n];
			for(int i = 0; i < n; ++i) {
				dpNewSum[i] = salary[i];
				if(i - 1 >= 0) {
					dpNewSum[i] += dpNewSum[ i - 1];
				}
				if(i - k >= 0) {
					dpNewSum[i] -= salary[i - k];
				}
			}
			long[] dp = new long[n];
			int mark = 0;
			for (int i = 0; i < n; ++i) {
				//calculate maximum sum for current index
				long currentSum = salary[i];
				if (i - k - 1 >= 0)
					currentSum += dp[i - k - 1];
				long sum = dpNewSum[i] > currentSum ? dpNewSum[i] : currentSum;
				dp[i] = sum > dp[i] ? sum : dp[i];
				//mark the index that has the maximum value in array
				mark = dp[i] >= dp[mark] ? i : mark;
				//calculate maximum sum for the next k elements from current index (current index -> k breaks -> next k elements)
				int startPoint = i + k + 1;
				int finishPoint = (i + 2 * k);
				if (startPoint < n) {
					long nextSum = dp[mark];
					for (int j = startPoint; j <= finishPoint && j < n; ++j) {
						nextSum += salary[j];
						dp[j] = nextSum > dp[j] ? nextSum : dp[j];
					}
				}		
			}
			if (n > 0 && k > 0) {
				builder.append(dp[mark]+"\n");
			} else {
				builder.append(0+"\n");
			}
        }
		System.out.print(builder);
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