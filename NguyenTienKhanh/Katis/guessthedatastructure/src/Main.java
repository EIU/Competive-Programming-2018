import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Main {



public static void main(String[] args) throws IOException {
InputReader input = new InputReader();
StringBuilder sb= new StringBuilder();
while (input.hasNext()){
    String M = "impossible";
    int N = input.nextInt();

	int[] num1 = new int[N];
	int[] x = new int[N];
	
	for (int i = 0; i < N; i++)
		{
		num1[i] = input.nextInt();
		x[i] = input.nextInt();
		}
	
	int count = 0;
	
	
	
	if (stack(num1 , x))
		{
		M = "stack";
		count++;
		}

	if (queue(num1 , x))
		{
		M = "queue";
		count++;
		}

	if (prority_Queue(num1 , x))
		{
		M = "priority queue";
		count++;
		}
	
	sb.append(count > 1 ? "not sure"+"\n": M+"\n");
	}
    System.out.println(sb);
}
public static boolean stack(int[] num , int[] x) {
	ArrayList<Integer> stack = new ArrayList<>();
	
	for (int i = 0; i < num.length; i++)
		{
		if (num[i] == 1)
			stack.add(x[i]);
		
		else if (stack.isEmpty() || stack.remove(stack.size() - 1) != x[i])
			return false;
		}
	
	return true;
}

public static boolean queue(int[] num , int[] x) {
	ArrayList<Integer> queue = new ArrayList<>();
	
	for (int i = 0; i < num.length; i++)
		{
		if (num[i] == 1)
			queue.add(x[i]);
		
		else if (queue.isEmpty() || queue.remove(0) != x[i])
			return false;
		}
	
	return true;
}
public static boolean prority_Queue(int[] num , int[] x) {
	ArrayList<Integer> queue = new ArrayList<>();
	
	for (int i = 0; i < num.length; i++)
		{
		if (num[i] == 1)
			queue.add(x[i]);
		
		else
			{
			Collections.sort(queue);
			
			if (queue.isEmpty() || queue.remove(queue.size() - 1) != x[i])
				return false;
			}
		}
	
	return true;
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