
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
class Node{
    int x;
    Node pre;
    Node next;
    public Node(int x) {
        this.x = x;
    }
}
class Link{
    Node head;
    Node tail;
    public Link() {
        head = null;
        tail = null;
    }
    public void add(int x){
        if(head == null){
            tail = new Node(x);
            head = tail;
        }else{
            tail.next = new Node(x);
            tail.next.pre = tail;
            tail = tail.next;
        }
    }
    public int size(){
        int size = 0;
        for(Node cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
}
public class Main {
    public static void solve(Link list){
        Node cur = list.head;
        while(cur != null){
            Node next = cur.next;
            Node pre = cur.pre;
            if (next != null) {
                if ((cur.x + next.x) % 2 == 0) {
                    if(pre != null){
                        pre.next = next.next;
                        if(next.next != null)
                            next.next.pre = pre;
                        next.next = null;
                        cur = pre;
                    }else{
                        
                        cur = next.next;
                        if(cur != null)
                            cur.pre = null;
                        list.head = cur;
                    }
                }else{
                    pre = cur;
                    cur = next;
                }
            }else{
                break;
            }
        }
    }
    public static void main(String args[]) throws IOException {
        InputReader ip = new InputReader();
        StringBuilder sb = new StringBuilder();
        int n = ip.nextInt();
        Link list = new Link();
        for(int i = 0; i < n; ++i){
            list.add(ip.nextInt());
        }
        solve(list);
        System.out.println(list.size());
    }

    static class InputReader {

        InputStream is = System.in;
        byte[] inbuf = new byte[1 << 24];
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
