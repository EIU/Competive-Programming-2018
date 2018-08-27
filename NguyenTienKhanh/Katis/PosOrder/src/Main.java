
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    public static InputReader input;
    //public static Node[] Rs;
    public static StringBuilder Rs;
    public static void main(String[] args) throws IOException {

        input = new InputReader();
        int N = input.nextInt();
        int[] inOrder = new int[N];
        int[] preOrder = new int[N];
        for(int i=0;i<N;i++){
            inOrder[i]= input.nextInt();
        }
        for(int i=0;i<N;i++){
            preOrder[i]= input.nextInt();
        }
        Node[] nodes = ReadTree(N);
        Rs = new StringBuilder();
        PrintPostOrder(nodes[0]);
        System.out.println(Rs);
    }

    public static void add(Node node) {

        Rs.append(node.Id+" ");
    }

    public static void PrintPostOrder(Node u) {
        if (u != null) {
            if (u.Left != null) {
                PrintPostOrder(u.Left);
            }
            if (u.Right != null) {
                PrintPostOrder(u.Right);
            }
        }
        add(u);

    }

    static Node[] ReadTree(int nNode) {
        Node[] nodes = new Node[nNode];
        for (int i = 0; i < nNode; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < nNode; i++) {
            int leftIndex = input.nextInt();
            nodes[i].Left = leftIndex > 0 ? nodes[leftIndex - 1] : null;
            int rightIndex = input.nextInt();
            nodes[i].Right = rightIndex > 0 ? nodes[rightIndex - 1] : null;
        }
        return nodes;
    }

    static class Node {

        public int Id;
        public Node Left;
        public Node Right;

        public Node(int id) {
            Id = id;
        }
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
