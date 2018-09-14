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
    public static String[] space;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input = new InputReader();
        int N = input.nextInt();
        Vertex[] listRoad = readGraph(N,N-1);
        String T = input.next();
        space = new String[N];
        int j=0;
        for (int i = 0; i < N; i++) {
            listRoad[i].sortNeighbor(listRoad[i]);
            if (listRoad[i].name.equals(T)) {
                j=i;
            }
            space[i]="";
        }
        sb.append(T + "\n");
         dfs(listRoad[j],listRoad[j],sb);
        System.out.print(sb);

    }

    public static void dfs(Vertex u,Vertex root,StringBuilder sb) {
        u.visited=true;
        for (int i = 0; i < u.neighbors.size(); i++) {
            if(!u.neighbors.get(i).visited){
                u.neighbors.get(i).visited=true;
                    if(space[u.id].contains("├───"))
                        space[u.neighbors.get(i).id]+="│   ";
                    else
                        if(space[u.id].contains("└───"))
                            space[u.neighbors.get(i).id]+="    ";
                        
                    if (i==u.neighbors.size() - 2&&root.equals(u.neighbors.get(u.neighbors.size()-1))||i == u.neighbors.size() - 1) {
                        sb.append(space[u.id]+space[u.neighbors.get(i).id]+"└───"+u.neighbors.get(i).name + "\n");
                         space[u.neighbors.get(i).id] +=space[u.id]+space[u.neighbors.get(i).id]+"    ";  
                            
                    } else {
                        sb.append(space[u.id]+space[u.neighbors.get(i).id]+"├───"+u.neighbors.get(i).name + "\n");
                         space[u.neighbors.get(i).id] +=space[u.id]+space[u.neighbors.get(i).id]+"│   ";   
                    }
                    dfs(u.neighbors.get(i),u,sb);
                }
        }
    }


    public static Vertex[] readGraph(int nVertices,int nE) {
        Vertex[] vertices = new Vertex[nVertices];
        int j=0;
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        for (int i = 0; i < nE; ++i) {
            String M=input.next();
            if(!list.containsKey(M)){
                list.put(M, j);
                vertices[j] = new Vertex(j,M);
                j++;
            }
            String N=input.next();
            
            if(!list.containsKey(N)){
                list.put(N, j);
                vertices[j] = new Vertex(j,N);
                j++;
            }
             int u = list.get(M);
            int v = list.get(N);
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);		
                }
        return vertices;
    }

    static class Vertex {

        public int id;
        public boolean visited;
        public String name;
        public List<Vertex> neighbors = new ArrayList<Vertex>();

        public Vertex(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void sortNeighbor(Vertex u) {
            u.neighbors.sort((a, b) -> {
                return a.name.toLowerCase().compareTo(b.name.toLowerCase());
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
