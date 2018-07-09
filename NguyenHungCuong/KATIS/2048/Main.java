
import java.io.IOException;
import java.io.InputStream;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();

        int[][] game = nextIntArray(4, 4, scan);

        int move = scan.nextInt();

        switch (move) {
            case 0:
                for (int i = 0; i < 4; i++) {
                    int[] list = new int[4];
                    int index = 0;
                    for (int j = 0; j < 4; j++) {
                        int a = game[i][j];
                        if (a != 0) {
                            if (list[index] == a) {
                                list[index] *= 2;
                                index++;
                            } else {
                                if (list[index] == 0) {
                                    list[index] = a;
                                } else {
                                    list[++index] = a;
                                }
                            }
                        }
                    }
                    game[i] = list;
                }
                System.out.println(soutIntArrayLeftRight(game, 4));
                break;
            case 1:
                int[][] up = new int[4][];
                for (int i = 0; i < 4; i++) {
                    int[] list = new int[4];
                    int index = 0;
                    for (int j = 0; j < 4; j++) {
                        int a = game[j][i];
                        if (a != 0) {
                            if (list[index] == a) {
                                list[index] *= 2;
                                index++;
                            } else {
                                if (list[index] == 0) {
                                    list[index] = a;
                                } else {
                                    list[++index] = a;
                                }
                            }
                        }
                    }
                    up[i] = list;
                }
                System.out.println(soutIntArrayUpDown(up, 4));
                break;
            case 2:
                for (int i = 0; i < 4; i++) {
                    int[] list = new int[4];
                    int index = 3;
                    for (int j = 3; j >=0; j--) {
                        int a = game[i][j];
                        if (a != 0) {
                            if (list[index] == a) {
                                list[index] *= 2;
                                index--;
                            } else {
                                if (list[index] == 0) {
                                    list[index] = a;
                                } else {
                                    list[--index] = a;
                                }
                            }
                        }
                    }
                    game[i] = list;
                }
                System.out.println(soutIntArrayLeftRight(game, 4));
                break;
            case 3:
                int[][] down = new int[4][];
                for (int i = 0; i < 4; i++) {
                    int[] list = new int[4];
                    int index = 3;
                    for (int j = 3; j >=0; j--) {
                        int a = game[j][i];
                        if (a != 0) {
                            if (list[index] == a) {
                                list[index] *= 2;
                                index--;
                            } else {
                                if (list[index] == 0) {
                                    list[index] = a;
                                } else {
                                    list[--index] = a;
                                }
                            }
                        }
                    }
                    down[i] = list;
                }
                System.out.println(soutIntArrayUpDown(down, 4));
                break;
        }

    }

    static int[][] nextIntArray(int n, int m, InputReader scan) {
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = scan.nextInt();
            }
        }
        return res;
    }

    static StringBuilder soutIntArrayLeftRight(int[][] a, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.append(a[i][j]).append(" ");
            }
            res.append("\n");
        }
        return res;
    }

    static StringBuilder soutIntArrayUpDown(int[][] a, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                res.append(a[j][i]).append(" ");
            }
            res.append("\n");
        }
        return res;
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
