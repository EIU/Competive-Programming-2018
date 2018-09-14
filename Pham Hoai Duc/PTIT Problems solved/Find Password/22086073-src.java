
import java.util.*;
import java.io.*;

public class Main {
    static boolean readFile = false;

    private static void permute(int[] arr, int index, char[] map,  ArrayList<String> list){
    	int n = arr.length;
        if(index >= n - 1){ //If we are at the last element - nothing left to permute
        	StringBuilder builder = new StringBuilder();
        	for(int i : arr) {
        		builder.append(map[i]);
        	}
        	list.add(builder.toString());
            return;
        }
        for(int i = index; i < n; ++i){ //For each index in the sub array arr[index...end]
            //Swap the elements at indices index and i
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            //Recurse on the sub array arr[index+1...end]
            permute(arr, index+1, map, list);
            //Swap the elements back
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) throws IOException {
		InputReader ip = new InputReader();
		StringBuilder builder = new StringBuilder();
		ArrayList<String> result = new ArrayList<>();
		String s = ip.next();
		int n = s.length();
		char[] map = new char[n];
		int[] p = new int[n];
		for(int i = 0; i < n; ++i) {
			map[i] = s.charAt(i);
			p[i] = i;
		}
		permute(p, 0, map, result);
		Collections.sort(result);
		int count = 0;
		int size = result.size();
		for(int i  = 0; i < size; ++i) {
			if(i > 0 && result.get(i).equals(result.get(i - 1)))
				continue;
			builder.append(result.get(i) + "\n");
			count++;
		}
		System.out.println(count);
		System.out.println(builder);
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