import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {

    public static InputReader input;
    public static int[] level;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input = new InputReader();
        int N = input.nextInt();
        Vertex[] listRoad = readGraph(N, N - 1);
        int find = bfs(listRoad[0], N);
        int hight = bfs(listRoad[find], N);
        if(find>hight)
            sb.append(hight+ " " + level[hight] + "\n");
        else
            sb.append(find+ " " + level[hight] + "\n");
        
        System.out.println(sb);

    }

    public static Vertex[] readGraph(int nVertices, int nEdges) {
        Vertex[] vertices = new Vertex[nVertices];
        for (int i = 0; i < nVertices; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < nEdges; ++i) {
            int u = input.nextInt();
            int v = input.nextInt();
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }
        return vertices;
    }

    static class Vertex {

        public int id;
        public List<Vertex> neighbors = new ArrayList<Vertex>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbor(Vertex child) {
            neighbors.add(child);
        }
    }

    public static int bfs(Vertex u, int N) {
        level = new int[N];
        Arrays.fill(level, -1);
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(u);
        level[u.id] = 0;
         int n=0,max=0;
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            for (Vertex neighbor : currentVertex.neighbors) {
                if (level[neighbor.id] == -1) {
                    queue.add(neighbor);
                    level[neighbor.id] = level[currentVertex.id] + 1;
                }
            }
        }
        for (int i = 0; i < level.length; i++) {
            if (level[i] > max) {
                max=level[i];
                n =i;
            }
        }
        return n;
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
