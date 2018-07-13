
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LENOVO
 */
class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();
        StringBuilder result = new StringBuilder();
        
        int n = scan.nextInt();
        ArrayList<Integer> busNumbers = new ArrayList<>();
        while (n-- > 0) {
            busNumbers.add(scan.nextInt());
        }
        if (busNumbers.size() == 1 || busNumbers.size() == 2) {
            for (int number : busNumbers) {
                System.out.print(number + " ");
            }
            return;
        }

        busNumbers.sort((n1, n2) -> n1 - n2);
        
        int startIndex = 0, endIndex;
        for (endIndex = 1; endIndex < busNumbers.size(); endIndex++) {
            if (busNumbers.get(endIndex) - busNumbers.get(endIndex - 1) != 1) {
                result.append(rangeToString(endIndex-1, startIndex, busNumbers));
                startIndex = endIndex;
                if (endIndex == busNumbers.size()-1){
                    result.append(rangeToString(endIndex, startIndex, busNumbers));
                }
            } else if (endIndex == busNumbers.size()-1){
                result.append(rangeToString(endIndex, startIndex, busNumbers));
            }
        }
        System.out.println(result);
    }

    static String rangeToString(int a, int b, ArrayList<Integer> list) {
        if (a - b == 1) {
            return list.get(b) + " " + list.get(a) + " ";
        }
        if (a - b == 0) {
            return list.get(a) + " ";
        }
        return list.get(b) + "-" + list.get(a) + " ";
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
