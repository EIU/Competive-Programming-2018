
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

//    public static long money;
//    public static ArrayList<Robot> listRobots;
    public static void main(String args[]) throws IOException {
        InputReader input = new InputReader();
        int N = input.nextInt();
        StringBuilder sb = new StringBuilder();
        int i, j;
        long first, last, mid, count;
        long[] products;
        long[] money;
        for (i = 0; i < N; i++) {
            //listRobots = new ArrayList<>();
            int numOfRobots = input.nextInt();
            products = new long[numOfRobots];
            money = new long[numOfRobots];
            long budget = input.nextLong();
            for (j = 0; j < numOfRobots; j++) {
                products[j] = input.nextLong();
                money[j] = input.nextLong();
//                Robot rb = new Robot(i, input.nextLong());
//                listRobots.add(rb);
            }
            first = 1;
            last = 1000000000000l;
            while (first < last) {
                mid = (first + last) >> 1;
                count = budget;
                for (j = 0; j < numOfRobots && count >= 0; j++) {
                    if (products[j] < mid) {
                        count -= money[j] * (mid - products[j]);
                    }
                }
//              for (int j = 0; j < numOfRobots && count >= 0; j++) {
//            count += ((mid - products[j]) * money[j]);
//        }
                if (count < 0) {
                    last = mid;
                } else {
                    first = mid+1;
                }
            }

            sb.append(first + "\n");
        }
        System.out.println(sb);
    }

//    public static class Robot {
//
//        public long products;
//        public long money;
//
//        public Robot(long products, long money) {
//            this.products = products;
//            this.money = money;
//        }
//
//    }
//    public static void compareTo(ArrayList<Robot> t) {
//        t.sort((a, b) -> {
//            if (Long.compare(a.products, b.products) != 0) {
//                return Long.compare(a.products, b.products);
//            } else {
//                return Long.compare(a.money, b.money);
//            }
//        });
//    }
//    
    static class InputReader {

        InputStream is = System.in;
        byte[] inbuf = new byte[1 << 24];
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
