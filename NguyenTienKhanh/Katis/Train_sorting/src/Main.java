
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader();
        int N=input.nextInt();
        int[] listCars = new int[N]; 
        for(int i=0;i<N;i++){
            listCars[i]= input.nextInt();
        }
    int[] inCre=new int[N];
    int[] deCre= new int[N];
    for(int i = N - 1; i >= 0; i--) {
            inCre[i] = 1;
            for(int j = i + 1; j < N; j++) {
                if(listCars[i] < listCars[j]) {
                    inCre[i] = Math.max(inCre[j] + 1, inCre[i]);
                }
            }
        }
        for(int i = N - 1; i >= 0; i--) {
            deCre[i] = 1;
            for(int j = i + 1; j < N; j++) {
                if(listCars[i] > listCars[j]) {
                    deCre[i] = Math.max(deCre[j] + 1, deCre[i]);
                }
            }
        }
        int reSult = 0;
        for(int i = 0; i < N; i++) {
            reSult = Math.max(reSult, inCre[i] + deCre[i] - 1);
        }
        System.out.println(reSult);
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
            for (int i = 0; i < n; i++)
                map[i] = ns(m);
            return map;
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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
