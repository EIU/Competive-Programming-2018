
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Main {

    public static int posIndex;
    public static InputReader input;
    public static Vertex[] listRoad;


    public static void main(String args[]) throws IOException {
        input= new InputReader();
         StringBuilder Rs= new StringBuilder();
        int[] listNum= new int[80000];
        int N = input.nextInt();
        int[] pre = new int[N];
        int[] in = new int[N];
        for(int i=0;i<N;i++)
            pre[i]=input.nextInt();
        for(int i =0 ;i <N;i++){
            int c=input.nextInt();
            in[i]=c;listNum[c]= i;
        }
         listRoad = readGraph(N);
         findSource(pre, in,listNum,0, N-1, 0,0);
        for(int i=0;i<listRoad.length;i++){
            Rs.append(listRoad[i].neighbors.size()+" ");
        }
        System.out.println(Rs);
    }    public static void findSource(int[] pre, int[] in,int[] list,int low,int hight, int preIndex,int last) {
        if(low>hight){
            return ;
        }
        int index=list[pre[preIndex]];
        if(last!= preIndex-1 && preIndex<listRoad.length&&last!=preIndex){
        listRoad[pre[preIndex]].addNeighbor(listRoad[pre[last]]);
        listRoad[pre[last]].addNeighbor( listRoad[pre[preIndex]]);
        }
        else{
            if(preIndex<listRoad.length&& last!=preIndex){
            listRoad[pre[preIndex]].addNeighbor(listRoad[pre[last]]);
        listRoad[pre[last]].addNeighbor( listRoad[pre[preIndex]]);
            }
        }
        findSource( pre, in,list, index+1, hight, preIndex+(index-low)+1 ,preIndex);
        findSource( pre, in, list, low, index-1, preIndex+1,preIndex );
        
        
    }
    public static Vertex[] readGraph(int nVertices) {
        Vertex[] vertices = new Vertex[nVertices];
        for (int i = 0; i < nVertices; ++i) {
            vertices[i] = new Vertex(i);
        }
        return vertices;
    }
    static class Vertex {

        public int id;
        public int visited = 0;
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
