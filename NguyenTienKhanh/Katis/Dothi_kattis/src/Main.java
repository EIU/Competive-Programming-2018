
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jdk.nashorn.internal.ir.ContinueNode;

public class Main {
    public static int count =0;
    public static int[] need,have;
    public static Vertex[] vertices ;
    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader();
        ArrayList<Integer> Vertex = new ArrayList<Integer>();
        int N = input.nextInt();
        while(N!=0){
            need = new int[N+1];
            have = new int[N+1];
             Vertex[] listRoad=readGraph(N);
            for(int i=1;i<=N;i++){
                Vertex.add(input.nextInt());
                have[i]=input.nextInt();
                need[i]= input.nextInt()+1;
                for(int j=0;j<need[i]-1;j++){
                    int u = input.nextInt()  ;
			listRoad[i].addNeighbor(listRoad[u]);
                }
            }
            for( int i=N;i>0;i--){
                dfs(listRoad[i]);
            }
            System.out.println(count);
            N=input.nextInt();
        }
    }
    public static Vertex[] readGraph(int nVertices) {
		Vertex[] vertices = new Vertex[nVertices+1];
		for (int i = 1; i <= nVertices; ++i) {
			vertices[i] = new Vertex(i);
	}
		return vertices;
	}
    public static void dfs(Vertex u){
        if(u.id==1)
            return;
        if(u.neighbors.size()==0){
     count+=Math.abs(have[u.id]-need[u.id]);
     return;
        }
 u.visited=true;
 
for(Vertex v : u.neighbors){
        have[u.id]+=Math.abs(have[v.id]-need[v.id]);
}
count+=Math.abs(have[u.id]-need[u.id]);
}
static class Vertex {
	public int id;
        public boolean visited=false;
	public List<Vertex> neighbors = new ArrayList<Vertex>();

        
	public Vertex(int id) {
		this.id = id;
	}

        public void sortNeighbor(Vertex u ){
            u.neighbors.sort((a,b)->{ return a.id-b.id;})  ;
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
