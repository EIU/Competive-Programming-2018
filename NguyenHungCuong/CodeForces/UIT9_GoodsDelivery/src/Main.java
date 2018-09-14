
import java.util.*;
import java.io.*;

public class Main {

    static boolean readFile = false;

    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();

        int n = scan.nextInt();
        int k = scan.nextInt();

        ArrayList<store> stores = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            int index = scan.nextInt();
            int amount = scan.nextInt();

            stores.add(new store(index, amount));
        }

        stores.sort((a, b) -> {
            return a.index - b.index;
        });

        int right = 0;
        int i = 1;
        for (; i < stores.size(); i++) {
            right += stores.get(i).amount;
        }
        //right = (right+k-1)/k;
        //System.out.println(right);
        int left = 0;
        for (i = 1; i < stores.size(); i++) {

            //int l = (left + stores.get(i - 1).amount + k - 1) / k;
            //int r = (right - stores.get(i).amount + k - 1) / k;
            if ((left + stores.get(i - 1).amount + k - 1) / k >= (right - stores.get(i).amount + k - 1) / k) {
                break;
            } else {
                right -= stores.get(i).amount;

                left += stores.get(i - 1).amount;
            }
        }
        //i--;
        //System.out.println(i);
        //System.out.println(left);
        //System.out.println(right);

        int length = 0;
        int mod = 0;
        int temp;
        for (int a = stores.size() - 1; a > i; a--) {

            stores.get(a).amount -= mod;
            
            temp = ((stores.get(a).amount + k - 1) / k);
            
            length += (temp * (stores.get(a).index - stores.get(i).index));

            mod = Math.max(temp*k - k*(temp-1),0);
        }

        mod = 0;
        for (int a = 0; a < i; a++) {

            stores.get(a).amount -= mod;

            temp = ((stores.get(a).amount + k - 1) / k);
            
            length += (temp * (stores.get(i).index - stores.get(a).index));

            mod = Math.max(temp*k - k*(temp-1),0);
        }

        System.out.println(length);
    }

    static class store {

        int index;
        int amount;

        public store(int index, int amount) {
            this.index = index;
            this.amount = amount;
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
