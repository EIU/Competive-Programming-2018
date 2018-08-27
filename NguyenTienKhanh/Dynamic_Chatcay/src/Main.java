
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

class Main {

    public static InputReader input;

    public static void main(String[] args) throws IOException {
        input = new InputReader();
        int N = input.nextInt();
        long[] price = new long[N];
        int[] count = new int[N];
        Arrays.fill(count, 1);
        for (int i = 0; i < N; i++) {
            long T = input.nextLong();
            price[i] = T;
        }
        if (N > 2) {
            long pri = price[2];
            price[2] = Math.max(price[0], Math.max(price[2], price[2] + price[0]));
             if (pri + price[0] == pri || price[0] == Math.max(pri, pri + price[0]) ) {
                count[2] += count[0]+1;
            }else{
            if (pri + price[0] == pri || price[0] == Math.max(pri, pri + price[0]) ) {
                count[2] += count[0];
            }
             }
                
        }
        int i;
        for(i = 3;i<N;i++){
            long pri=price[i];
                 price[i]=Math.max(price[i-3], Math.max(price[i], Math.max(price[i]+price[i-2], price[i]+price[i-3])));
                 price[i]=Math.max(price[i], price[i-2]);
                 if(price[i]==pri){
                     count[i]= pri==pri+price[i-2]&&pri==pri+price[i-3]?count[i]+count[i-2]+count[i-3]: pri==pri+price[i-2]?count[i]+count[i-2]: pri==pri+price[i-3]?count[i]+count[i-3]:count[i]; 
                 }else if(price[i]==price[i-2]){
                     count[i]= price[i-2]==price[i-3]&& price[i-2]==price[i-2]+pri?count[i]+count[i-2]+count[i-3]:price[i-2]==price[i-3]?count[i-3]+count[i-2]:price[i-2]==price[i-2]+pri?count[i]+count[i-2]:count[i-2];
                     }else if(price[i]==price[i-3]){
                     count[i]=price[i-3]==price[i-3]+pri?count[i]+count[i-3]:count[i-3];
                 }else if(price[i]==pri+price[i-2]){
                     count[i]=  price[i-2]==price[i-3]?count[i-2]+count[i-3]:count[i-2];
                     
                 }else
                     count[i]=count[i-3];
                 count[i]%=1000000007;
                 
        }

        long max = Long.MIN_VALUE;
        long Count = 0;
        for (i = price.length - 1; i > price.length - 3; i--) {
            if (price[i] > max) {
                max = price[i];
                Count = count[i];
            } else if (price[i] == max) {
                Count += count[i];
            }
        }
        if (max < 0) {
            Count = 1;
            max = 0;
        }

        System.out.println(max + " " + Count);
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
