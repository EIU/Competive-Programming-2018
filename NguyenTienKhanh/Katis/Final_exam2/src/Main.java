
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static long maximum;

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader();
        StringBuilder sb = new StringBuilder();
        int N = input.nextInt();
        ArrayList<Integer> listnum;
        for(int i=0;i<N;i++){
            int num=input.nextInt();
            int temp=0;
            listnum=new ArrayList<>();
            listnum.add(input.nextInt());
            listnum.add(input.nextInt());
            int test=(listnum.get(1)-listnum.get(0));
            for(int j=2;j<num;j++){
                listnum.add(input.nextInt());
                if(listnum.get(j)-listnum.get(j-1)!=test)
                    temp=1;
            }
            if(temp==0){
                sb.append("arithmetic"+"\n");
                continue;
            }else{
                Collections.sort(listnum);
                test=(listnum.get(1)-listnum.get(0));
                for(int j=2;j<listnum.size();j++){
                     if(listnum.get(j)-listnum.get(j-1)==test){
                         temp=2;
                     }else{
                         temp=1;
                         break;
                     }
                }
                if(temp==1){
                sb.append("non-arithmetic"+"\n");
            }else
                   sb.append("permuted arithmetic"+"\n");  
            }

        }
        System.out.println(sb);
    }

    static class InputReader {

        InputStream is = System.in;
        byte[] inbuf = new byte[1 << 20];
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
