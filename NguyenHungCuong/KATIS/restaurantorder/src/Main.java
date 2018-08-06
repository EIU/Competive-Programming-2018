
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader scanner = new InputReader();
        int n = scanner.nextInt();

        int c[] = new int[n];
        int prev[] = new int[30001];
        Arrays.fill(prev, -1);
        prev[0] = 0;
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
            for (int j = 0; j + c[i] < 30001; j++) {
                if (prev[j] != -1) {
                    if (prev[j] == n || prev[j + c[i]] != -1) {
                        prev[j + c[i]] = n;
                    } else {
                        prev[j + c[i]] = i;
                    }
                }
            }
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int d = scanner.nextInt();
            if (prev[d] == n) {
                System.out.println("Ambiguous");
            } else if (prev[d] == -1) {
                System.out.println("Impossible");
            } else {
                Vector<Integer> res = new Vector<>();
                while (d > 0) {
                    res.add(prev[d] + 1);
                    d = d - c[prev[d]];
                }

                Collections.reverse(res);
                for (int j = 0; j < res.size(); j++) {
                    System.out.print(res.elementAt(j));
                    if (j + 1 < res.size()) {
                        System.out.print(" ");
                    } else {
                        System.out.println("");
                    }
                }
            }
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
