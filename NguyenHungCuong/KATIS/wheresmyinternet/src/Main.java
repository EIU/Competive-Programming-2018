
import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();
        int n = scan.nextInt();
        int m = scan.nextInt();
        Vertex[] list = readGraph(n, m, scan);
        bfs(list[0]);
        StringBuilder res = new StringBuilder();		
        for (int i=0;i<n;i++) {
        	if (!list[i].visited) {
        		res.append(list[i].id+"\n");
        	}
        }
        if (res.length() == 0) res.append("Connected");
        System.out.println(res);
    }
    static void bfs(Vertex u) {
    		u.visited = true;
    		Queue<Vertex> queue = new LinkedList<Vertex>();
    		queue.add(u);
    		while (!queue.isEmpty()) {
    			Vertex cur = queue.poll();
    			for (Vertex v : cur.neighbors) {
    				if (!v.visited) {
    					v.visited = true;
    					queue.add(v);
    				}
    			}
    		}
    }
    public static Vertex[] readGraph(int nVertices, int nEdges, InputReader scan) {
        Vertex[] vertices = new Vertex[nVertices];
        for (int i = 0; i < nVertices; ++i) {
            vertices[i] = new Vertex(i+1);
        }
        for (int i = 0; i < nEdges; ++i) {
            int u = scan.nextInt()-1;
            int v = scan.nextInt()-1;
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }
        return vertices;
    }

    static class Vertex {

        public int id;
        public List<Vertex> neighbors = new ArrayList<>();
        public boolean visited = false;
        
        public Vertex(int id) {
            this.id = id;
        }
        
        public int getDeg(){
            return this.neighbors.size();
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
