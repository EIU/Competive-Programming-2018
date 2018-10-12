import java.io.*;
import java.util.*;

public class Main {

    public static InputReader scan;

    public static void main(String[] args) throws IOException {
        scan = new InputReader();
        int test = scan.nextInt();
        while (test-- > 0) {
            int stores = scan.nextInt();
            Vertex[] list = readGraph(stores);
            dfs(list[0]);
            if (list[stores+1].visited) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    public static void dfs(Vertex u) {
        u.visited = true;
        for (Vertex v : u.neighbors) {
            if (!v.visited) {
                dfs(v);
            }
        }
    }

    public static Vertex[] readGraph(int nVertices) {
        Vertex[] vertices = new Vertex[nVertices + 2];

        for (int i = 0; i < vertices.length; ++i) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            vertices[i] = new Vertex(i, x, y);
            for (int j = 0; j < i; j++) {
                if (Math.abs(vertices[i].x - vertices[j].x)+Math.abs(vertices[i].y-vertices[j].y) <= 1000) {
                    vertices[i].addNeighbor(vertices[j]);
                    vertices[j].addNeighbor(vertices[i]);
                }
            }
        }
        return vertices;
    }

    static class Vertex {

        public int id;
        public int x;
        public int y;
        public boolean visited = false;
        public List<Vertex> neighbors = new ArrayList<Vertex>();

        public Vertex(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public void addNeighbor(Vertex child) {
            neighbors.add(child);
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