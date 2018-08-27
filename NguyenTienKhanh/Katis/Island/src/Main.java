import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import sun.applet.AppletViewer;
public class Main {

    public static InputReader input ;
    public static StringBuilder sb= new StringBuilder();
    public static int count=0;
    public static void main(String[] args) throws IOException {
       input = new InputReader();
        int N = input.nextInt();
        int M = input.nextInt();
        Vertex[] listRoad=readGraph(N, M);
          for(int i=1;i<listRoad.length;i++){
            if(listRoad[i].id.equals('L')&& listRoad[i].visited==false){
                count++;
                dfs(listRoad[i]);
            }
        }
                 
          System.out.println(count);
        
    }
    	public static Vertex[] readGraph(int nVertices, int nEdges) {
		Vertex[] vertices = new Vertex[nVertices*nEdges+1];
                int t=1;
		for (int i = 0; i < nVertices; ++i) {
                    String S=input.next();
                    for(int j=0;j<nEdges;j++){
                    vertices[t] = new Vertex(S.charAt(j));
                    t++;
                }
			
	}
		for (int i = 1; i <nVertices*nEdges+1; ++i) {
                    if(i%nEdges!=0)
                        vertices[i].addNeighbor(vertices[i+1]);
	            if(i%nEdges!=1&& nEdges!=1)
                        vertices[i].addNeighbor(vertices[i-1]);
                    if(i>nEdges)
                        vertices[i].addNeighbor(vertices[i-nEdges]);
                    if(i<nVertices*nEdges+1-nEdges)
                        vertices[i].addNeighbor(vertices[i+nEdges]);
		}
		return vertices;
	}


static class Vertex {
	public Character id;
        public boolean visited=false;
	public List<Vertex> neighbors = new ArrayList<Vertex>();

        
	public Vertex(Character id) {
		this.id = id;
	}

	public void addNeighbor(Vertex child) {
		neighbors.add(child);
	}
}
public static void dfs(Vertex u){
    u.visited=true;
for(Vertex v : u.neighbors){
    if(!v.visited&& v.id!='W'){
        dfs(v);
    }
    
}
}
public static void bfs(Vertex u){
    u.visited= true;
    Queue<Vertex> queue = new LinkedList<>();
    queue.add(u);
    while(!queue.isEmpty()){
        Vertex currentVertex = queue.poll();
        sb.append(currentVertex.id +"\n");
        for(Vertex neighbor : currentVertex.neighbors){
            if(!neighbor.visited){
                neighbor.visited=true;
                queue.add(neighbor);
            }
        }
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
            for (int i = 0; i < n; i++)
                map[i] = ns(m);
            return map;
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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
