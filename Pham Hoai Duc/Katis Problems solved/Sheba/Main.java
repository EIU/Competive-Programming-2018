
import java.util.*;
import java.io.*;

public class Main {
    static boolean readFile = false;
    public static int solve(boolean[][] pic, int n, int m){
        int count = 0;
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j){
                if(pic[i][j] == true){
                    count++;
                    dfs(pic, i, j);
                }
            }
        }
        return count;
    }
    public static void dfs(boolean[][] pic, int i, int j){
        pic[i][j] = false;
        if(pic[i][j + 1]){
            dfs(pic, i, j + 1);
        }
        if(pic[i][j - 1]){
            dfs(pic, i, j - 1);
        }
        if(pic[i + 1][j]){
            dfs(pic, i + 1, j);
        }
        if(pic[i + 1][j + 1]){
            dfs(pic, i + 1, j + 1);
        }
        if(pic[i + 1][j - 1]){
            dfs(pic, i + 1, j - 1);
        }
        if(pic[i - 1][j]){
            dfs(pic, i - 1, j);
        }
        if(pic[i - 1][j + 1]){
            dfs(pic, i - 1, j + 1);
        }
        if(pic[i - 1][j - 1]){
            dfs(pic, i - 1, j - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        InputReader ip = new InputReader();
        StringBuilder sb = new StringBuilder();
        int n = ip.nextInt();
        int m = ip.nextInt();
        boolean[][] pic = new boolean[n + 2][m + 2];
        for(int i = 1; i <= n; ++i){
            String s = ip.next();
            for(int j = 1; j <= m; ++j){
                if(s.charAt(j - 1) == '#'){
                    pic[i][j] = true;
                }
            }
        }
        System.out.println(solve(pic, n, m));
        
       
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
