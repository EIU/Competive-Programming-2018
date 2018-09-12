
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String getNum(int num, int line) {
        String[] Ze = {"+---+",
            "|   |",
            "|   |",
            "+   +",
            "|   |",
            "|   |",
            "+---+",};

        String[] one = {"    +",
            "    |",
            "    |",
            "    +",
            "    |",
            "    |",
            "    +",};

        String[] two = {"+---+",
            "    |",
            "    |",
            "+---+",
            "|    ",
            "|    ",
            "+---+",};

        String[] three = {"+---+",
            "    |",
            "    |",
            "+---+",
            "    |",
            "    |",
            "+---+",};

        String[] four = {"+   +",
            "|   |",
            "|   |",
            "+---+",
            "    |",
            "    |",
            "    +",};

        String[] five = {"+---+",
            "|    ",
            "|    ",
            "+---+",
            "    |",
            "    |",
            "+---+",};

        String[] six = {"+---+",
            "|    ",
            "|    ",
            "+---+",
            "|   |",
            "|   |",
            "+---+",};

        String[] seven = {"+---+",
            "    |",
            "    |",
            "    +",
            "    |",
            "    |",
            "    +",};

        String[] eight = {"+---+",
            "|   |",
            "|   |",
            "+---+",
            "|   |",
            "|   |",
            "+---+",};

        String[] nine = {"+---+",
            "|   |",
            "|   |",
            "+---+",
            "    |",
            "    |",
            "+---+",};

        if (num == 0) {
            return Ze[line];
        }
        if (num == 1) {
            return one[line];
        }
        if (num == 2) {
            return two[line];
        }
        if (num == 3) {
            return three[line];
        }
        if (num == 4) {
            return four[line];
        }
        if (num == 5) {
            return five[line];
        }
        if (num == 6) {
            return six[line];
        }
        if (num == 7) {
            return seven[line];
        }
        if (num == 8) {
            return eight[line];
        }

        return nine[line];

    }

    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();
        StringBuilder sb = new StringBuilder();
        while (true) {
            String time = scan.next();

            if (time.equals("end")) {
                break;
            }

            int num1 = Integer.parseInt(time.substring(0, 1));
            int num2 = Integer.parseInt(time.substring(1, 2));
            int num3 = Integer.parseInt(time.substring(3, 4));
            int num4 = Integer.parseInt(time.substring(4, 5));

            sb.append(getNum(num1, 0) + "  " + getNum(num2, 0) + "     " + getNum(num3, 0) + "  " + getNum(num4, 0) + "\n");
            sb.append(getNum(num1, 1) + "  " + getNum(num2, 1) + "     " + getNum(num3, 1) + "  " + getNum(num4, 1) + "\n");
            sb.append(getNum(num1, 2) + "  " + getNum(num2, 2) + "  o  " + getNum(num3, 2) + "  " + getNum(num4, 2) + "\n");
            sb.append(getNum(num1, 3) + "  " + getNum(num2, 3) + "     " + getNum(num3, 3) + "  " + getNum(num4, 3) + "\n");
            sb.append(getNum(num1, 4) + "  " + getNum(num2, 4) + "  o  " + getNum(num3, 4) + "  " + getNum(num4, 4) + "\n");
            sb.append(getNum(num1, 5) + "  " + getNum(num2, 5) + "     " + getNum(num3, 5) + "  " + getNum(num4, 5) + "\n");
            sb.append(getNum(num1, 6) + "  " + getNum(num2, 6) + "     " + getNum(num3, 6) + "  " + getNum(num4, 6) + "\n");
            sb.append("\n");
            sb.append("\n");
        }
        sb.append("end");
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
