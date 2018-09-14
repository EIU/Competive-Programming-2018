
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> Rs = new ArrayList<>();
        InputReader input = new InputReader();
        int maxLeft = 0, maxRight = 0, maxUp = 0, maxDown = 0;
        while (input.hasNext()) {
            String T = input.next();
            maxUp = T.equals("up") ? maxUp + 1 : maxUp;
            maxRight = T.equals("right") ? maxRight + 1 : maxRight;
            maxLeft = T.equals("left") ? maxLeft + 1 : maxLeft;
            maxDown = T.equals("down") ? maxDown + 1 : maxDown;
            Rs.add(T);
        }
        int col = maxUp == 0 ? maxDown + 3 : maxDown == 0 ? maxUp + 3 : Math.max(maxUp, maxDown) + 3;
        int row = maxLeft == 0 ? maxRight + 3 : maxRight == 0 ? maxLeft + 3 : Math.max(maxLeft, maxRight) + 3;
        char[][] reSult = new char[(col) * 2][(row) * 2];
        reSult[row][col] = 'S';
        maxRight = row;
        maxLeft = row;
        maxUp = col;
        maxDown = col;
        for (int i = 0; i < Rs.size(); i++) {
            row=Rs.get(i).equals("up")?row-1:row;
            row=Rs.get(i).equals("down")?row+1:row;
            col=Rs.get(i).equals("left")?col-1:col;
            col=Rs.get(i).equals("right")?col+1:col;
            maxRight= row >maxRight? row:maxRight;
            maxLeft= row <maxLeft? row:maxLeft;
            maxUp= col > maxUp? col:maxUp;
           maxDown= col <maxDown? col:maxDown;
         reSult[row][col]=reSult[row][col] != 'S'?'*':'S';
        }
        reSult[row][col] = 'E';
        for (int i = maxLeft - 1; i < maxRight + 2; i++) {
            for (int j = maxDown - 1; j < maxUp + 2; j++) {
                if ((reSult[i][j] ==(char)0 && i==maxLeft - 1)||(reSult[i][j] ==(char)0 && i==maxRight +1)||(reSult[i][j] ==(char)0 && j==maxDown - 1)||(reSult[i][j] ==(char)0 && j==maxUp + 1)) {
                    reSult[i][j] = '#';
                }else{
                    if (reSult[i][j] == (char)0) {
                    reSult[i][j] = ' ';
                }
                }
            }
        }
        for (int i = maxLeft - 1; i < maxRight + 2; i++) {
            for (int j = maxDown - 1; j < maxUp + 2; j++) {
                sb.append(reSult[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

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
