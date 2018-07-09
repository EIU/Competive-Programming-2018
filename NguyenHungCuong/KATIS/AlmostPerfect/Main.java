
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
        StringBuilder res = new StringBuilder();
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] primes = prime(n);
            long sumPrimes = calculateSum(primes)-n;
            if (sumPrimes == n){
                res.append(n).append(" ").append("perfect\n");
            } else if (Math.abs(n - sumPrimes) <= 2){
                res.append(n).append(" ").append("almost perfect\n");
                //System.out.println(Math.abs(n - sumPrimes));
            } else {
                res.append(n).append(" ").append("not perfect\n");
            }
        }
        System.out.println(res);
    }

    static long calculateSum(int[] primes) {
        long res = 1;
        int anchor = primes[0];
        int count = 1;
        for (int i = 1; i < primes.length; i++) {
            if (primes[i] == anchor) {
                count++;
            } else {
                res *= sumPrime(anchor, count);
                anchor = primes[i];
                count = 1;
            }
        }
        if (primes[primes.length-1] == anchor){
            res *= sumPrime(anchor, count);
        } else {
            res *= sumPrime(anchor, 1);
        }
        return res;
    }

    static int sumPrime(int a, int x) {
        int res = 1;
        int temp = 1;
        for (int i=1;i<=x;i++){
            temp *= a;
            res += temp;
        }
        return res;
    }

    static String pringIntArray(int[] a) {
        String res = "";
        for (int i = 0; i < a.length; i++) {
            res += a[i] + " ";
        }
        return res;
    }

    static int[] prime(int n) {
        int[] res = new int[33];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res[index++] = i;
                n /= i;
            }
        }
        //res[index++] = n;
        return Arrays.copyOf(res, index);
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
