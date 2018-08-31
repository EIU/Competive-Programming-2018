import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static int[] level;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputReader input = new InputReader();
        while (true) {
            int N = input.nextInt();
            int M = input.nextInt();
            int Q = input.nextInt();
            int S = input.nextInt();
            if (N == 0) {
                break;
            }
            level = new int[N];
            Arrays.fill(level, Integer.MAX_VALUE);
            
            Edge[] listRoad = new Edge[N];
            for(int i =0;i<N;++i)
            listRoad[i]=new Edge(i);
            for (int i = 0; i < M; ++i) {
         int u = input.nextInt();
             int v = input.nextInt();
            int fi = input.nextInt();
            int rq = input.nextInt();
            int dis = input.nextInt();
            Edge ed = new Edge(u, v, fi, rq, dis);
            listRoad[u].addNeighbor(ed);
}
            bfs(listRoad[S], listRoad);
            for (int i = 0; i < Q; i++) {
                int root = input.nextInt();
                if (level[root] != Integer.MAX_VALUE) {
                    sb.append(level[root] + "\n");
                } else {
                    sb.append("Impossible" + "\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void bfs(Edge u, Edge[] lisVertexs) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        PQ.add(u.edge1);
        level[u.edge1] = 0;
        while (!PQ.isEmpty()) {
            int index = PQ.poll();
            for (Edge ed2 : lisVertexs[index].edges) {
                int time = 0;
                int lv1 = level[ed2.edge1];
                if (lv1 <= ed2.firstTime && ed2.requestTime == 0) {
                    time = ed2.firstTime + ed2.distance;
                } else {
                    if (ed2.requestTime > 0) {
                        time = ed2.firstTime + Math.max(0, lv1 - ed2.firstTime) / ed2.requestTime * ed2.requestTime;
                        if (time < lv1) {
                            time += ed2.requestTime;
                        }
                        time += ed2.distance;
                    }
                }
                if (time < level[ed2.edge2]) {
                    level[ed2.edge2] = time;
                }
                PQ.add(ed2.edge2);
            }
        }

    }

    static class Edge {

        public int edge1;
        public int edge2;
        public int firstTime;
        public int requestTime;
        public int distance;
        public ArrayList<Edge> edges = new ArrayList<Edge>();
        public Edge(int edge1){
                this.edge1 = edge1;
        }
        public Edge(int edge1, int edge2, int firstTime, int requestTime, int distance) {
            this.edge1 = edge1;
            this.edge2 = edge2;
            this.firstTime = firstTime;
            this.requestTime = requestTime;
            this.distance = distance;
        }
        public void addNeighbor(Edge child) {
            edges.add(child);
        }
    }
    static class InputReader {

        InputStream is = System.in;
        byte[] inbuf = new byte[1 << 20];
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