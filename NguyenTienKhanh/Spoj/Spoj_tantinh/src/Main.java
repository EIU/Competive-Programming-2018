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
    public static HashMap<String, Integer> list;public static boolean res;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        input = new InputReader();
        int N = input.nextInt();
        int M=input.nextInt();
        int Q = input.nextInt();
        Vertex[] listRoad = readGraph(N,M);
        for(int i=0;i<listRoad.length;i++){
            if(!listRoad[i].visited)
                dfs(listRoad[i],i);
        }
        HashSet<Integer> listName;
        for (int i = 0; i < Q; i++) {
            listName=new HashSet<>();
            int test=input.nextInt();
            if(test==0|| test==1){
                sb.append("Yes"+"\n");
                continue;
            }
            for(int j=0;j<test;j++){
                String T=input.next();
                if(!listName.contains(listRoad[list.get(T)].level))
                    listName.add(listRoad[list.get(T)].level);
                else{
                    sb.append("No"+"\n");
                    break;
                }
                if(j==test-1)
                sb.append("Yes"+"\n");        
            }
        }
        System.out.println(sb);

    }
public static void dfs(Vertex u, int i){
u.visited= true;
u.level=i;
for(Vertex v : u.neighbors){
    if(!v.visited){
   
        dfs(v,i);
    }
}
  }
  
    public static Vertex[] readGraph(int nVertices,int nE) {
        Vertex[] vertices = new Vertex[nVertices];
        list = new HashMap<String, Integer>();
        for (int i = 0; i < nVertices; ++i) {
            String M=input.next();
                list.put(M, i);
                vertices[i] = new Vertex(i,M);
            }	
        for (int i = 0; i < nE; ++i) {
            int u = list.get(input.next());
            int v = list.get(input.next());
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }
        return vertices;
    }

    static class Vertex {

        public int id;
        public boolean visited;
        public int level;
        public String name;
        public List<Vertex> neighbors = new ArrayList<Vertex>();

        public Vertex(int id, String name) {
            this.id = id;
            this.name = name;
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
