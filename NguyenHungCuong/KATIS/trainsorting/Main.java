
import java.io.*;
import java.util.*;

class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();
        //StringBuilder result = new StringBuilder();

        int numCars = scan.nextInt();
        int[] cars = nextIntArray(scan, numCars);
        
        int[] LIS = new int[numCars];
        int[] LDS = new int[numCars];
        int ans = 0;
        for (int i=numCars-1;i>=0;i--) {
        	LIS[i] =1;
        	LDS[i] =1;
        	for (int j=i+1;j<numCars;j++) {
        		if (cars[i] < cars[j]) {
        			LIS[i] = Math.max(LIS[i],LIS[j]+1);
        		} else {
        			LDS[i] = Math.max(LDS[i],LDS[j]+1);
        		}
        	}
        	ans = Math.max(ans, LIS[i] + LDS[i] - 1);
        }
        System.out.println(ans);
    }

    static int[] nextIntArray(InputReader scan, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = scan.nextInt();
        }
        return res;
    }
    
//    static class InputReader {
//
//        StringTokenizer tokenizer;
//        BufferedReader reader;
//        String token;
//        String temp;
//
//        public InputReader(InputStream stream) {
//            tokenizer = null;
//            reader = new BufferedReader(new InputStreamReader(stream));
//        }
//
//        public InputReader(FileInputStream stream) {
//            tokenizer = null;
//            reader = new BufferedReader(new InputStreamReader(stream));
//        }
//
//        public String nextLine() throws IOException {
//            return reader.readLine();
//        }
//
//        public String next() {
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    if (temp != null) {
//                        tokenizer = new StringTokenizer(temp);
//                        temp = null;
//                    } else {
//                        tokenizer = new StringTokenizer(reader.readLine());
//                    }
//
//                } catch (IOException e) {
//                }
//            }
//            return tokenizer.nextToken();
//        }
//
//        public double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//    }

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
