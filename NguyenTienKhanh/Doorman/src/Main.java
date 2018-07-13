
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader();
        int N = input.nextInt();
        StringBuilder wait = new StringBuilder(input.next());
        StringBuilder sb = new StringBuilder();
        int M = 0, W = 0;
        for (int i = 0; i < wait.length(); i++) {
            if(Math.abs(M-W)<N){
            if (wait.charAt(i) == 'M') {
                M++;
            } else {
                W++;
            }
            continue;
            }
            if (Math.abs(M - W) >= N) {
                if (M > W) {
                   if(wait.charAt(i)!='W'){
                       if(i+1<wait.length()-1 && wait.charAt(i+1)=='W'){
                           W++;
                           wait.deleteCharAt(i+1);
                           i--;
                     }else
                           break;
                   } else
                       W++;
                }else {
                   if(wait.charAt(i)!='M'){
                       if(i+1<wait.length()-1 && wait.charAt(i+1)=='M'){
                           M++;
                           wait.deleteCharAt(i+1);
                           i--;
                     }else
                           break;
                   } else
                       M++;
                }  
                
            }

        }
        sb.append(M + W);
        System.out.println(sb);

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
