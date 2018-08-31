
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
    public static StringBuilder sb;
    public static long total;
    public static long count;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        input = new InputReader();
        int N = input.nextInt();
        Vertex[] listRoad = readGraph(N, N - 1);
        dfs(listRoad[1],listRoad[1]);
            long max = Long.MAX_VALUE;
            int Rs = Integer.MAX_VALUE;
            long tw1 = 0, tw2 = 0;
        for (int i = 1; i < listRoad.length; i++) {
           long TW1 = 0,TW2=0,amount;
            if (findRoot(listRoad[i])) {
                if(listRoad[i].neighbors.get(0).countWeight>listRoad[i].countWeight)
                    TW1 =total-listRoad[i].countWeight ;
                else
                    TW1=listRoad[i].neighbors.get(0).countWeight;
                
                    TW2 = total - TW1 - listRoad[i].w;
                    amount=Math.abs(TW1-TW2);
                    if (amount < max) {
                    max = amount;
                    Rs = listRoad[i].id;
                    tw1 = TW1;
                    tw2 = TW2;
                } else if (amount == max) {
   
                    if (listRoad[i].id < Rs) {
                        Rs = listRoad[i].id;tw1 = TW1;
                         tw2 = TW2;
                    }
                    
                }
            }
        }
        if (Rs==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else 
            System.out.println(Rs + " " + Math.min(tw2, tw1) + " " + Math.max(tw2, tw1));
            
            

    }

    public static boolean findRoot(Vertex u) {
        if (u.neighbors.size() != 2) {
            return false;
        } else {
            return true;
        }
    }

    public static void dfs(Vertex u,Vertex root) {
        u.visited=true;
        for (Vertex v : u.neighbors) {
            if (!v.visited) {
                dfs(v,u);
            }
              
        }
        if(root!=u)
             root.countWeight+=u.countWeight;  
           
    }

    public static Vertex[] readGraph(int nVertices, int nEdges) {
        Vertex[] vertices = new Vertex[nVertices + 1];
        for (int i = 1; i <= nVertices; ++i) {
            long W = input.nextLong();
            total += W;
            vertices[i] = new Vertex(i, W,W);
        }
        for (int j = 0; j < nEdges; j++) {
            int u = input.nextInt();
            int v = input.nextInt();
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }
        return vertices;
    }

    static class Vertex {

        public int id;
        public long w;
        public long countWeight;
        public boolean visited;
        public List<Vertex> neighbors = new ArrayList<Vertex>();

        public Vertex(int id, long name,long countWeight) {
            this.id = id;
            this.w = name;
            this.countWeight=countWeight;
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
