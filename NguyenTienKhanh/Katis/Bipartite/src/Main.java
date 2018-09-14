
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Main {

    public static InputReader input;
    public static HashMap<Integer, String> mapGender;
    public static boolean res;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        input = new InputReader();
        int test=input.nextInt();
        for(int i=0;i<test;i++){
            res=true;
            int N = input.nextInt();
        int M = input.nextInt();
         Vertex[] listRoad = readGraph(N, M);
          for (int j = 1; j < listRoad.length; j++) {
            if (!listRoad[j].visited) {
                dfs(listRoad[j]);        
            }
        }
          if(res)
              sb.append("Yes"+"\n");
          else
              sb.append("No"+"\n");
        }
        System.out.println(sb);

    }

    public static Vertex[] readGraph(int nVertices, int nEdges) {
        Vertex[] vertices = new Vertex[nVertices ];
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
        public boolean visited=false;
        public int part=0;
        public List<Vertex> neighbors = new ArrayList<Vertex>();

        public Vertex(int id) {
            this.id = id;
        }

        public void sortNeighbor(Vertex u) {
            u.neighbors.sort((a, b) -> {
                return a.id - b.id;
            });
        }

        public void addNeighbor(Vertex child) {
            neighbors.add(child);
        }
    }

    public static void dfs(Vertex u) {
        u.visited = true;
       if(u.part==0)
           u.part=1;
        for (Vertex v : u.neighbors) {
            if (!v.visited) {
                if(u.part==1)
                    v.part=2;
                else
                    v.part=1;
                dfs(v);
            }else
                if(v.part==u.part){
                    res=false;
                    return;
                }
                    

        }
    }

//    public static void bfs(Vertex u) {
//        u.visited = true;
//        Queue<Vertex> queue = new LinkedList<>();
//        queue.add(u);
//        while (!queue.isEmpty()) {
//            Vertex currentVertex = queue.poll();
//            for (Vertex neighbor : currentVertex.neighbors) {
//                if (!neighbor.visited) {
//                    neighbor.visited = true;
//                    String s = String.valueOf(currentVertex.id);
//                    String t = String.valueOf(neighbor.id);
//                    if (count.get(s + t) != null) {
//                        level[neighbor.id] = level[currentVertex.id] + count.get(s + t);
//                    } else {
//                        level[neighbor.id] = level[currentVertex.id] + count.get(t + s);
//                    }
//
//                    queue.add(neighbor);
//                }
//
//            }
//        }
//    }

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
