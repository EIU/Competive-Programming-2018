

import java.util.*;
import java.io.*;

public class Main {

    static boolean readFile = false;

    public static void main(String[] args) throws IOException {
        InputReader ip = new InputReader();
        StringBuilder sb = new StringBuilder();
        int T = ip.nextInt();
        long dp[] = new long[9];
        dp[0] = 1;
        dp[1] = 60;
        for (int i = 2; i <= 8; ++i) {
            dp[i] = 60 * dp[i - 1];
        }
        for (int t = 0; t < T; ++t) {
            String s = ip.next();
            int l = s.length();
            int th = 0;
            long sum = 0;
            for (int i = l - 1; i >= 0; --i) {
                if (s.charAt(i) == ',') {
                    if (i + 1 >= l || s.charAt(i + 1) == ',') {
                        th++;
                        continue;
                    }
                    if (s.charAt(i + 1) != ',' && i + 2 < l && s.charAt(i + 2) != ',') {
                        sum += (Long.parseLong(String.valueOf(s.charAt(i + 1)) + String.valueOf(s.charAt(i + 2))) * dp[th]);
                    } else if (s.charAt(i + 1) != ',') {
                        sum += (Long.parseLong(String.valueOf(s.charAt(i + 1))) * dp[th]);
                    }
                    th++;
                } else {
                    if (i == 0) {
                        if (i + 1 < l && s.charAt(i + 1) != ',') {
                            sum += (Long.parseLong(String.valueOf(s.charAt(i) + String.valueOf(s.charAt(i + 1)))) * dp[th]);
                        } else {
                            sum += (Long.parseLong(String.valueOf(s.charAt(i))) * dp[th]);
                        }
                    }
                }
            }
            sb.append(sum+"\n");
        }
        System.out.print(sb);
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
