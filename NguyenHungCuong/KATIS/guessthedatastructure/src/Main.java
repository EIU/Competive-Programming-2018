import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();
        StringBuilder res = new StringBuilder();
        while (scan.hasNext()) {
            int n = scan.nextInt();
            Stack<Integer> s = new Stack<>();
            Queue<Integer> q = new LinkedList<Integer>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            boolean isStack = true,isQueue = true, isPri = true;
            while (n-- >0) {
                int cmd = scan.nextInt();
                int num = scan.nextInt();
                if (cmd == 1) {
                    s.add(num);
                    q.add(num);
                    pq.add(num);
                } else {
                    if (s.isEmpty() || s.pop() != num) {
                        isStack = false;
                    }
                    if (q.isEmpty() || q.poll() != num) {
                        isQueue = false;
                    }
                    if (pq.isEmpty() || pq.poll() != num) {
                        isPri = false;
                    }
                }
            }
            if (isStack && !isPri && !isQueue) {
                res.append("stack\n");
            } else if (isPri && !isStack && !isQueue) {
                res.append("priority queue\n");
            } else if (isQueue && !isStack && !isPri) {
                res.append("queue\n");
            } else if (!isPri && !isQueue && !isStack){
                res.append("impossible\n");
            } else {
                res.append("not sure\n");
            }
        }
        System.out.println(res);
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

        public int[][] nmInt(int n, int m) {
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = nextInt();
                }
            }
            return map;
        }

        public long[][] nmLong(int n, int m) {
            long[][] map = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = nextLong();
                }
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