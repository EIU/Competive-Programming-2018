
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        String M = new String();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    M = "4" + operations(i) + "4" + operations(j) + "4" + operations(k) + "4";
                    map.put(Check(M), M);
                }
            }
        }
        int test = input.nextInt();
        for (int i = 0; i < test; i++) {
            int num = input.nextInt();
            sb.append(map.containsKey(num) ? map.get(num) + " = " + num + "\n" : "no solution" + "\n");
        }
        System.out.println(sb);
    }

    public static int Check(String N) {

        while (N.contains(" * ") || N.contains(" / ")) {
            int mul = N.indexOf("*");
            int divi = N.indexOf("/");
            int sub = mul - 2;
            int sub2 = mul + 2;
            if ((divi < mul && divi != -1) || mul == -1) {
                sub = divi - 2;
                sub2 = divi + 2;
            }
            while (sub != 0 && !N.substring(sub, sub + 1).equals(" ")) {
                sub--;
            }
            sub = sub != 0 ? sub + 1 : sub;
            while (sub2 != N.length() && !N.substring(sub2, sub2 + 1).equals(" ")) {
                sub2++;
            }
            N = N.substring(0, sub) + count(N.substring(sub, sub2)) + N.substring(sub2);
        }
        while (N.contains(" + ") || N.contains(" - ")) {
            int add = N.indexOf(" + ");
            int sub = N.indexOf(" - ");
            int sub1 = add - 1;
            int sub2 = add + 3;
            if ((sub < add && sub != -1) || add == -1) {
                sub1 = sub - 1;
                sub2 = sub + 3;
            }
            while (sub1 != 0 && !N.substring(sub1, sub1 + 1).equals(" ")) {
                sub1--;
            }
            sub1 = sub1 != 0 ? sub1 + 1 : sub1;

            while (sub2 != N.length() && !N.substring(sub2, sub2 + 1).equals(" ")) {
                sub2++;
            }
            N = N.substring(0, sub1) + count(N.substring(sub1, sub2)) + N.substring(sub2);
        }
        return Integer.parseInt(N);
    }

    public static String operations(int in) {

        String T = in == 0 ? " + " : in == 1 ? " - " : in == 2 ? " * " : " / ";
        return T;
    }

    public static int count(String Count) {
        int num1 = Integer.parseInt(Count.substring(0, Count.indexOf(" ")));
        int num2 = Integer.parseInt(Count.substring(Count.lastIndexOf(" ") + 1));
        int Rs = Count.contains(" + ") ? (num1 + num2) : Count.contains(" - ") ? (num1 - num2) : Count.contains(" * ") ? (num1 * num2) : (num1 / num2);
        return Rs;
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
