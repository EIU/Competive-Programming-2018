

import java.util.*;
import java.io.*;

public class Main {

    static boolean readFile = false;
    public static long GCD(long x, long y){
        if(y == 0)
            return x;
        else
            return GCD(y, x % y);
    }
    public static void solve(long x1, long y1, String sign, long x2, long y2, StringBuilder builder){
        long gcd1 = GCD(x1, y1);
        long gcd2 = GCD(x2, y2);
        x1 /= gcd1;
        y1 /= gcd1;
        x2 /= gcd2;
        y2 /= gcd2;
        long x = 0;
        long y = y1 * y2;
        if (sign.equals("*")) {
            x = x1 * x2;
        }else if(sign.equals("/")){
            x = x1 * y2;
            y = y1 * x2;
        }else if(sign.equals("-")){
            x = x1*y2 - x2*y1;
        }else{
            x = x1*y2 + x2*y1;
        }
        long gcd = GCD(x, y);
        x /= gcd;
        y /= gcd;
        if(y < 0){
            x *= -1;
            y *= -1;
        }
        builder.append(x+" / "+y+"\n");
    }

    public static void main(String[] args) throws IOException {
        InputReader ip = new InputReader();
        StringBuilder builder = new StringBuilder();
        int T = ip.nextInt();
        for(int t = 0; t < T; ++t){
            solve(ip.nextLong(), ip.nextLong(), ip.next(), ip.nextLong(), ip.nextLong(), builder);
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
