
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

class Main {

    public static InputReader input;
    public static int posIndex;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input = new InputReader();
        int N = input.nextInt();
        int Root = input.nextInt();
        int[] pos = new int[N];
        int[] next = new int[N];
        int[] pre = new int[N];
        posIndex = N - 1;
        Arrays.fill(next, -1);
        Arrays.fill(pre, -1);
        TreeSet<Integer> treeSetInteger = new TreeSet<>();
        treeSetInteger.add(Root);
        for (int i = 0; i < N - 1; i++) {
            int T = input.nextInt();
            int smaller = treeSetInteger.floor(T) != null ? treeSetInteger.floor(T) : Integer.MIN_VALUE;
            int bigger = treeSetInteger.ceiling(T) != null ? treeSetInteger.ceiling(T) : Integer.MAX_VALUE;
            treeSetInteger.add(T);
            if (T < Root) {
                if (pre[bigger] == -1) {
                    pre[bigger] = T;
                } else {
                    pre[smaller] = T;
                }
            } else {
                if (next[smaller] == -1) {
                    next[smaller] = T;
                } else {
                    next[bigger] = T;
                }
            }
        }
        pos[posIndex--] = Root;

        findSource(Root, pos, next);
        findSource(Root, pos, pre);
        for (int i = 0;i < N; i++) {
            sb.append(pos[i] + " ");
        }
        System.out.println(sb);

    }

    public static void findSource(int Root, int[] pos, int[] next) {
        if (next[Root] != -1) {
            pos[posIndex--] = next[Root];
            findSource(next[Root], pos, next);
        } else {
            return;
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
