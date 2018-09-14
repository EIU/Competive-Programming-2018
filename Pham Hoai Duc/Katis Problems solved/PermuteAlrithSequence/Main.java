
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
public class Main {
     private static boolean permute(int[] arr, int index) {
        Arrays.sort(arr);
        int temp = arr[1] - arr[0];
            boolean isAri = true;
            for(int i = 2; i < arr.length; ++i){
                if(arr[i] - arr[i - 1] != temp){
                    isAri = false;
                    break;
                }
            }
            if(isAri)
                return true;
        return false;
    }
    public static void main(String args[]) throws IOException {
        InputReader ip = new InputReader();
        StringBuilder sb = new StringBuilder();
        int n = ip.nextInt();
        for(int t = 0; t < n; ++t){
            int m = ip.nextInt();
            int[] arr = new int[m];
            for(int i = 0; i < m; ++i){
                arr[i] = ip.nextInt();
            }
            int temp = arr[1] - arr[0];
            boolean isAri = true;
            for(int i = 2; i < m; ++i){
                if(arr[i] - arr[i - 1] != temp){
                    isAri = false;
                    break;
                }
            }
            if(isAri){
                sb.append("arithmetic\n");
            }else{
                isAri = permute(arr, 0);
                if(isAri){
                    sb.append("permuted arithmetic\n");
                }else{
                    sb.append("non-arithmetic\n");
                }
            }
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
