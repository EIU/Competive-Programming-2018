
import java.util.*;
import java.io.*;
class V{
    boolean visited = false;
    ArrayList<Integer> adj = new ArrayList<>();
}
class G{
    V[] vertices;
    public G(int n) {
        vertices = new V[n];
        for(int i = 0; i < n; ++i){
            vertices[i] = new V();
        }
    }
    public void add(int u, int v){
        vertices[u].adj.add(v);
        vertices[v].adj.add(u);
    }
    public int dfs(){
        int count = -1;
        for(int i = 0; i < vertices.length; ++i){
            if(!vertices[i].visited){
                count++;
                dfs(i);
            }
        }
        return count;
    }
    public void dfs(int v){
        vertices[v].visited = true;
        for(int n : vertices[v].adj){
            if(!vertices[n].visited){
                dfs(n);
            }
        }
    }
}
public class Main {
    static boolean readFile = false;
   
    public static void main(String[] args) throws IOException {
        InputReader ip = new InputReader();
        StringBuilder sb = new StringBuilder();
        int T = ip.nextInt();
        for(int t = 0; t < T; ++t){
            int n = ip.nextInt();
            int m = ip.nextInt();
            G g= new G(n);
            for(int i = 0; i < m ; ++i){
                g.add(ip.nextInt(), ip.nextInt());
            }
            sb.append(g.dfs() + "\n");
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
