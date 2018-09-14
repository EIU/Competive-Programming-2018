
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static char map[][];
    public static class Point{
        int x;
        int y;
    }
    public static void main(String[] args)throws Exception{
        InputReader input = new InputReader();
            int n = input.nextInt(), m = input.nextInt(), count = 0;
            char[][] listPoint=new char[n+2][m+2];
            for(int i=0;i<n+2;i++){
                for(int j=0;j<m+2;j++){
                    listPoint[i][j]='0';
                }
            }
            for(int i=0;i<n;i++){
                String M=input.next();
                for(int j=0;j<m;j++){
                    listPoint[i+1][j+1]=M.charAt(j);
                }
            }
            ArrayList<Point> q = new ArrayList<>();
            Point p = new Point(); p.x=0;p.y=0;
            q.add(p);
            listPoint[0][0]=' ';
            int dx[] = {0,1,0,-1};
            int dy[] = {1,0,-1,0};
            
            while(!q.isEmpty()){
                int x = q.get(0).x;
                int y = q.get(0).y;
                q.remove(0);
                for(int d =0;d<4;d++ ){
                    int currentX = x+dx[d];
                    int currentY = y+dy[d];
                    if(currentX>=0 && currentX<n+2 && currentY>=0 && currentY<m+2){
                        if(listPoint[currentX][currentY]=='1')count++;
                        if(listPoint[currentX][currentY]=='0'){
                            listPoint[currentX][currentY]=' ';
                            p=new Point(); p.x=currentX;p.y=currentY;
                            q.add(p);
                        }
                    }
                }
            }
            System.out.println(count);
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
