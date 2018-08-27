
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

class Main {
    public static long maximum;

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader();
        StringBuilder sb = new StringBuilder();
        int test = input.nextInt();
        for (int i = 0; i < test; i++) {
            int N = input.nextInt();
            int K = input.nextInt();
            long[] price = new long[N + 1];
            long[] moneyOnTime = new long[N + 1];
            long[] max = new long[N + 1];
            maximum = 0;
            long T = input.nextLong();
            long[] Count = new long[N + 1];
            price[1] = maximum = Count[1] = max[1] = T;
            for (int j = 2; j <= N; j++) {
                T = input.nextLong();
                price[j] = T;
                Count[j] = Count[j - 1] + T;
                if (j > K) {
                    Count[j] -= price[j - K];
                }
                if (j - 1 >= K * 2) {
                    Count[j] += ((max[j - (K * 2)] - max[j - (K * 2 + 1)]));
                }
                if (Count[j] > maximum) {
                    maximum = Count[j];
                }
                max[j] = maximum;

            }
            int index=0;
            for (int j = 0; j <= N; j++) {
                
		moneyOnTime[j] = max[j] > moneyOnTime[j] ? max[j] : moneyOnTime[j];
		index = moneyOnTime[j] >= moneyOnTime[index] ? j : index;
                long nextSum = moneyOnTime[index];
                if (j + K + 1 < N) {
                for (int k = 1; k <= K && j + K + k <= N ; k++) {
                 
                    nextSum += price[j + K + k];
                  moneyOnTime[j + K + k] = nextSum > moneyOnTime[j + K + k] ? nextSum : moneyOnTime[j + K + k];
                }
                  if (nextSum > maximum) {
                    maximum = nextSum;
                }
                }
            }
                sb.append(maximum + "\n");

        }
        System.out.println(sb);
    }

    static class InputReader {

        InputStream is = System.in;
        byte[] inbuf = new byte[1 << 20];
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
