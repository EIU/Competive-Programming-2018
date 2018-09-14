import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
 
class Main {
 
    public static InputReader input;
    public static int[] level;
    public static int[] pre;
 
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input = new InputReader();
        int N = input.nextInt();
        long[] price = new long[N];
        for(int i=0;i<N;i++){
            long T=input.nextLong();
            price[i]=T;
        }
        if(N>3)
            price[3]=Math.max(price[0], Math.max(price[3], price[3]+price[0]));
        if(N>4){
            price[4]=Math.max(price[1], Math.max(price[4], Math.max(price[4]+price[1], price[4]+price[0])));
        price[4]=Math.max(price[4], price[0]);
        }
        
        for(int i = 5;i<N;i++){
                 long pri= price[i];
                 price[i]=Math.max(price[i], Math.max(pri+price[i-3], pri+price[i-4]));
                 price[i]=Math.max(price[i-3], Math.max(price[i], pri+price[i-5]));
                 price[i]=Math.max(price[i-4], price[i]);
                 price[i]=Math.max(price[i-5], price[i]);
        }
        long max=0;
        for(int i=0;i<price.length;i++){
            if(price[i]>max)
                max=price[i];
        }
 
        System.out.println(max);
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
 