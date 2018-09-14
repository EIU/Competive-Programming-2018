import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Main {

public static void main(String[] args) throws IOException {
InputReader scan = new InputReader();

while (true)
    {
    int num = scan.nextInt();
    
    if (num == 0)
        break;
    
    int[] nums = new int[num];
    
    for (int i = 0; i < nums.length; i++)
        nums[i] = scan.nextInt();
    
    ArrayList<Integer> maxes = new ArrayList<>();
    ArrayList<ArrayList<Integer>> subs  = new ArrayList<>();

    for (int a : nums)
        {
        if (subs.isEmpty())
            {
            ArrayList<Integer> seq = new ArrayList<Integer>();
            seq.add(a);
            subs.add(seq);
            maxes.add(a);
            }
        else
            {
            int index = Collections.binarySearch(maxes , a);
            
            if (index >= 0)
                continue;
            
            index = -index - 2;
            
            if (index == -1)
                {
                ArrayList<Integer> seq = new ArrayList<>();
                seq.add(a);
                subs.set(0 , seq);
                maxes.set(0 , a);
                }
            else
                {
                ArrayList<Integer> seq = new ArrayList<>(subs.get(index));
                seq.add(a);
                
                if (index != maxes.size() - 1)
                    {
                    subs.set(index + 1 , seq);
                    maxes.set(index + 1, a);
                    }
                else
                    {
                    subs.add(seq);
                    maxes.add(a);
                    }
                }
            }
        }
    
    ArrayList<Integer> ans = subs.get(subs.size() - 1);
    System.out.println(ans.size() + " " + ans.toString().substring(1 , ans.toString().length() - 1).replace("," , ""));
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