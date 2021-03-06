
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {

    public static InputReader input;
    public static int[] level;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        input = new InputReader();
        int N = input.nextInt();

        Vertex[] listRoad = readGraph(N);
        for (int i = 0; i < N; i++) {
            listRoad[i].sortNeighbor(listRoad[i]);
        }
        String T = input.next();
        String check = input.next();
        int K = input.nextInt();
        level = new int[N];
        ArrayList<String> Rs = new ArrayList<>();
        for (int i = 0; i < listRoad.length; i++) {
            if (listRoad[i].name.equals(T)) {
                level[listRoad[i].id]=0;
                dfs(listRoad[i], check,K);
                break;
            }
        }
        System.out.print(sb);

    }

    public static void dfs(Vertex u, String T,int K) {
        u.visited = true;
        for (Vertex v : u.neighbors) {
            v.neighbors.remove(u);
            if (!v.visited) {
                level[v.id]=level[u.id]+1;
                if(level[v.id]>K)
                    continue;
                if (v.neighbors.size()==0&&v.name.contains(T)) {
                    sb.append(v.name+"\n");
                }
                
                dfs(v, T,K);
            }   
        }
        
    }

//    public static void dfss(Vertex u) {
//        u.visited = false;
//        for (Vertex v : u.neighbors) {
//            if (v.visited) {
//                dfss(v);
//            }
//        }
//        if (u.neighbors.size()!=0&&u.contains >= 1) {
//            sb.append(u.name + " " + u.contains + "\n");
//        }
//
//    }

    public static Vertex[] readGraph(int nVertices) {
        Vertex[] vertices = new Vertex[nVertices];

        HashMap<String, Integer> list = new HashMap<String, Integer>();
        ArrayList<String> listFiles = new ArrayList<>();
        int t = 0;
        while (listFiles.size() != (nVertices - 1) * 2) {
            String M = input.next();
            listFiles.add(M);
            if (!list.containsKey(M)) {
                list.put(M, t);
                vertices[t] = new Vertex(t, M);
                t++;
            }
        }

        for (int j = 0; j < listFiles.size() - 1; j += 2) {
            int u = list.get(listFiles.get(j));
            int v = list.get(listFiles.get(j + 1));
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }
        return vertices;
    }

    static class Vertex {

        public int id;
        public String name;
        public int contains = 0;
        public boolean visited;
        public List<Vertex> neighbors = new ArrayList<Vertex>();

        public Vertex(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void sortNeighbor(Vertex u) {
            u.neighbors.sort((a, b) -> {
                return a.name.compareTo(b.name);
            });
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
