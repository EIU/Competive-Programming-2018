import java.util.*;
import java.io.*;

public class knapsack {
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        
        while (reader.hasNext()) {
            int c = (int) reader.nextDouble();
            int weight = reader.nextInt();
            int value[] = new int[weight];
            int W[] = new int[weight];
            for (int i = 0; i < weight; i++) {
                value[i] = reader.nextInt();
                W[i] = reader.nextInt();
            }
             int dp[][] = new int[2001][2001];
            for (int i = 1; i <= weight; i++) {
                int v = value[i - 1];
                int w = W[i - 1];
                for (int j = 1; j <= c; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= w && dp[i - 1][j - w] + v > dp[i][j]) {
                        dp[i][j] = dp[i - 1][j - w] + v;
                    }
                }
            }
            int i = c;
            ArrayList<Integer> arr = new ArrayList<>();
            for (int k = weight; k > 0; k--) {
                if (dp[k][i] != dp[k - 1][i]) {
                    int a = k - 1;
                    arr.add(a);
                    i -= W[a];
                }
            }
            System.out.println(arr.size());
            for (Integer b : arr) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
    static class InputReader {

        InputStream is = System.in;
        byte[] inbuf = new byte[1 << 25];
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

        public int[][] nmInt(int n, int m) {
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = nextInt();
                }
            }
            return map;
        }

        public long[][] nmLong(int n, int m) {
            long[][] map = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = nextLong();
                }
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