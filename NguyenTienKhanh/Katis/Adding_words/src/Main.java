
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader();
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<Integer, String> count2 = new HashMap<>();

        while (input.hasNext()) {
            String M = input.next();

            if (M.equals("def")) {
                String word = input.next();
                int num = input.nextInt();
                if (count2.containsKey(count.get(word))) {
                    count2.remove(count.get(word));
                }
                count.put(word, num);
                count2.put(num, word);
            } else if (M.equals("calc")) {
                String firstVar = input.next();
                boolean res = false;
                int sum = 0;

                sb.append(firstVar + " ");

                if (count.containsKey(firstVar)) {
                    sum += count.get(firstVar);
                } else {
                    res = true;
                }

                while (true) {
                    String temp = input.next();
                    sb.append(temp + " ");
                    String var;

                    if (temp.equals("-")) {
                        var = input.next();
                        sb.append(var + " ");

                        if (count.containsKey(var)) {
                            sum -= count.get(var);
                        } else {
                            res = true;
                        }
                    } else if (temp.equals("+")) {
                        var = input.next();
                        sb.append(var + " ");

                        if (count.containsKey(var)) {
                            sum += count.get(var);
                        } else {
                            res = true;
                        }
                    } else {
                        break;
                    }
                }

                sb.append(count2.containsKey(sum) && !res ? count2.get(sum) + "\n" : "unknown" + "\n");
            } else {
                count.clear();
                count2.clear();
            }
        }
        System.out.println(sb);

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
