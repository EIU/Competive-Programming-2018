import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Final3 {
    static boolean readFile = false;

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        StringBuilder builder = new StringBuilder();
        while (reader.hasNext()) {
            Queue<Integer> queue = new ArrayDeque<>();
            Stack<Integer> stack = new Stack<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
            int number = reader.nextInt(), b, c;
            boolean checkQueue = true;
            boolean checkStack = true;
            boolean checkPrio = true;
            for (int i = 0; i < number; i++) {
                b = reader.nextInt();
                c = reader.nextInt();
                if (b == 1) {
                    queue.add(c);
                    stack.add(c);
                    priorityQueue.add(c);
                } else {
                    if (queue.isEmpty())
                        checkQueue = false;
                    else {
                        if (queue.poll() != c)
                            checkQueue = false;
                    }
                    if (stack.isEmpty())
                        checkStack = false;
                    else {
                        if (stack.pop() != c)
                            checkStack = false;
                    }
                    if (priorityQueue.isEmpty())
                        checkPrio = false;
                    else {
                        if (priorityQueue.poll() != c)
                            checkPrio = false;
                    }
                }
            }
            if (checkPrio == true && checkStack == true || checkPrio == true && checkQueue == true
                    || checkQueue == true && checkStack == true) {
                builder.append("not sure\n");
            } else {
                if (checkPrio) {
                    builder.append("priority queue\n");
                } else if (checkStack) {
                    builder.append("stack\n");
                } else if (checkQueue) {
                    builder.append("queue\n");
                } else {
                    builder.append("impossible\n");
                }
            }
        }
        System.out.print(builder);

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
            for (int i = 0; i < n; i++)
                map[i] = ns(m);
            return map;
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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
