import java.io.*;
import java.util.*;

class Main {
    static char[] ar = { 'C', 'P', 'C', 'A', 'S', 'I', 'A', 'S', 'G' };

    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();
        int n = scan.nextInt();
        String str = scan.next();
        boolean found = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'I') {
                if (go(i, 0, str, n)) {
                    found = true;
                    break;
                }
            }
        }
        System.out.println(found ? "YES" : "NO");
    }

    static boolean go(int i, int index, String str, int n) {
        if (index == 9)
            return true;
        boolean found = false;
        if ((i + n - 2 < n * n) && str.charAt(i + n - 2) == ar[index])
            found = go(i + n - 2, index + 1, str, n);
        
        if (!found && (i + n + 2 < n * n) && str.charAt(i + n + 2) == ar[index])
            found = go(i + n + 2, index + 1, str, n);
        
        if (!found && (i + 2 * n - 1 < n * n) && str.charAt((i + 2 * n - 1)) == ar[index])
            found = go(i + 2 * n - 1, index + 1, str, n);
        
        if (!found && (i + 2 * n + 1 < n * n) && str.charAt((i + 2 * n + 1)) == ar[index])
            found = go(i + 2 * n + 1, index + 1, str, n);
        
        if (!found && (i - n - 2 >= 0) && str.charAt(i - n - 2) == ar[index])
            found = go(i - n - 2, index + 1, str, n);
        
        if (!found && (i - n + 2 >= 0) && str.charAt(i - n + 2) == ar[index])
            found = go(i - n + 2, index + 1, str, n);
        
        if (!found && (i - 2 * n - 1 >= 0) && str.charAt((i - 2 * n - 1)) == ar[index])
            found = go(i - 2 * n - 1, index + 1, str, n);
        
        if (!found && (i - 2 * n + 1 >= 0) && str.charAt((i - 2 * n + 1)) == ar[index])
            found = go(i - 2 * n + 1, index + 1, str, n);

        return found;

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

        public StringBuilder printIntArr(int[] ar, int n) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                res.append(ar[i] + " ");
            }
            res.append("\n");
            return res;
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

        public String nextLine() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (b != '\n' && b != '\r') {
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