
import java.io.*;
import java.util.*;

public class Main {

    public static InputReader input;
    public static boolean[] listEdges;
    public static int count = 0;
    public static long total = 0;
    public static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {
        input = new InputReader();
        int N = input.nextInt();
        int M = input.nextInt();
        listEdges = new boolean[N + 1];
        long[] max = new long[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            Edge ed = new Edge(u, v, w);
            list.add(ed);
        }
        sortNeighbor(list);
        int[] p = createSets(N + 1);
        for (Edge ed : list) {
           unite(p, ed.edge1,max, ed.edge2,ed);
        }
        System.out.println(total);
    }

    public static void sortNeighbor(ArrayList<Edge> list) {
        list.sort((a, b) -> {
            return a.weight - b.weight;
        });
    }

    public static int[] createSets(int size) {
        int[] p = new int[size];
        for (int i = 1; i < size; i++) {
            p[i] = i;
        }
        return p;
    }

    public static int root(int[] p, int x) {
        return x == p[x] ? x : (p[x] = root(p, p[x]));
    }

    public static void unite(int[] p, int a,long[] max , int b,Edge ed) {
        a = root(p, a);
        b = root(p, b);
        if (a != b) {
            p[a] = b;
            max[b] += (ed.weight + max[a]);
                if (max[b] > total) {
                    total = max[b];
                }
        }
    }
    static class Edge {

        public int edge1;
        public int edge2;
        public int weight;

        public Edge(int edge1, int edge2, int weight) {
            this.edge1 = edge1;
            this.edge2 = edge2;
            this.weight = weight;
        }
    }

    static class Vertex {

        public int id;
        public boolean visited = false;
        public List<Edge> edges = new ArrayList<Edge>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbor(Edge child) {
            edges.add(child);
        }
    }

    public static Vertex[] readGraph(int nVertices, int nEdges) {
        Vertex[] vertices = new Vertex[nVertices + 1];
        for (int i = 1; i <= nVertices; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < nEdges; ++i) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            Edge ed = new Edge(u, v, w);
            vertices[u].addNeighbor(ed);
            vertices[v].addNeighbor(ed);

        }
        return vertices;
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
