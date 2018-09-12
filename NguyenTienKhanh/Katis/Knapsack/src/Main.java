
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        InputReader input = new InputReader();

        StringBuilder res = new StringBuilder();
        while(input.hasNext()){
            int S = input.nextInt();
        int N = input.nextInt();
        int[] value = new int[N];

        int[] size = new int[N];

        for (int i = 0; i < N; i++) {
            size[i] = input.nextInt();
            value[i] = input.nextInt();
        }

        knapSack( size, value,S, N);
        }
        

    }

public static void knapSack(int[] wt, int[] val, int W, int N)
    {
        int[][] m = new int[N+1][W+1];
        int[][] sol = new int[N+1][W+1];
 
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j <= W; j++)
            {
                int m1 = m[i][j];
                int m2 = Integer.MIN_VALUE; 
                if (j >= wt[i])
                    m2 = m[i][j - wt[i]] + val[i];
                m[i][j] = Math.max(m1, m2);
                sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }        
        int[] selected = new int[N + 1];
        for (int n = N-1, w = W; n >= 0; n--)
        {
            if (sol[n][w] != 0)
            {
                selected[n] = 1;
                w = w - wt[n];
            }
            else
                selected[n] = 0;
        }
        for (int i = 0; i < N; i++)
            if (selected[i] == 1)
                System.out.print(i +" ");
        System.out.println();
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
