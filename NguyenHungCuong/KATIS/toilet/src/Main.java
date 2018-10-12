import java.io.IOException;
import java.io.InputStream;
import java.util.*;

class Main {

    public static InputReader scan;

    public static void main(String[] args) throws IOException {
        scan = new InputReader();
        char[] seats = scan.next().toCharArray();
        int up = 0;
        int down = 0;
        int asYouWish = 0;
        char a = seats[0];
        char b = seats[1];
        if (a == 'U' && b == 'D') {
            up = 2;
            down = 1;
            asYouWish++;
        } else if (a == 'D' && b == 'U') {
            up = 1;
            down = 2;
            asYouWish++;
        } else if (a == 'U' && b == 'U') {
            up = 0;
            down = 1;
        } else {
            up = 1;
            down = 0;
        }
        for (int i=2;i<seats.length;i++) {
            if (seats[i] == 'D') {
                up +=2;
            } else down +=2;
            if (seats[i] != seats[i-1]) asYouWish++;
        }
        System.out.println(up);
        System.out.println(down);
        System.out.println(asYouWish);
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