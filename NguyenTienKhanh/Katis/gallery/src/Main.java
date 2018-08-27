
import java.io.*;
import java.util.*;

public class Main {

    public static InputReader input;
    public static void main(String[] args) throws IOException {
        input = new InputReader();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Edge> PQ;
        while (input.hasNext()) {
            PQ = new PriorityQueue<>();
            ArrayList<Edge> listEdge = new ArrayList<>();
            int C = 0;
            int N = input.nextInt();
            int M = input.nextInt();
            boolean[] listEdges = new boolean[N];
            if (N == 0 && M == 0) {
                break;
            }
            Vertex[] listRoad = readGraph(N, M);
            listEdges[listRoad[0].id] = true;
            for (Edge edge : listRoad[0].edges) {
                PQ.add(edge);
            }

            while (!PQ.isEmpty()) {
                Edge ed2 = PQ.poll();
                if (!listEdges[ed2.edge2]) {
                    listEdge.add(ed2);
                    C += ed2.weight;
                    listEdges[ed2.edge2] = true;
                    for (Edge ed : listRoad[ed2.edge2].edges) {
                            PQ.add(ed);
                    }
                } else if (!listEdges[ed2.edge1]) {
                    listEdge.add(ed2);
                    C += ed2.weight;
                    listEdges[ed2.edge1] = true;
                    for (Edge ed : listRoad[ed2.edge1].edges) {
                            PQ.add(ed);
                        
                    }
                }
            }
            sortList(listEdge);
            if (listEdge.size() != N - 1 ) {
                sb.append("Impossible"+"\n");
            } else {
                sb.append(C + "\n");
                for (int i = 0; i < listEdge.size(); i++) {
                        sb.append(listEdge.get(i).edge1 + " " + listEdge.get(i).edge2 + "\n");
                }
            }
        }
        System.out.println(sb);
    }
    public static void sortList(ArrayList<Edge> u) {
            u.sort((a, b) -> {
                if(a.edge1 < b.edge1)
                    return -1;
                else if(a.edge1 > b.edge1){
                          return 1;
                      }
                      else{
                          if(a.edge2 > b.edge2){
                              return 1;
                          }else
                              return -1;
                      }
                
                    
            });
        }
    static class Edge implements Comparable<Edge> {

        public int edge1;
        public int edge2;
        public int weight;

        public Edge(int edge1, int edge2, int weight) {
            this.edge1 = edge1;
            this.edge2 = edge2;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge t) {        
            return (weight - t.weight);
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
        Vertex[] vertices = new Vertex[nVertices];
        for (int i = 0; i < nVertices; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < nEdges; ++i) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            if(u<v){
                Edge ed = new Edge(u, v,w);
                vertices[u].addNeighbor(ed);
               vertices[v].addNeighbor(ed);
            }else{
                Edge ed = new Edge(v, u,w);
                vertices[u].addNeighbor(ed);
                vertices[v].addNeighbor(ed);
            }
            
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
