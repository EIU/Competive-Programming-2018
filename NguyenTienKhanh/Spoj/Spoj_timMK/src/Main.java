
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static int count;
    public static ArrayList<String> list;
    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader();
        String M= input.next();
        Character[] arr = new Character[M.length()];
        for(int i=0;i<M.length();i++){
            arr[i]=M.charAt(i);
        }
         count=0; 
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        swapArray(arr, 0, true);
        SortList(list);
        sb.append(list.get(0)+"\n");
        for(int i=1;i<list.size();i++){
            if(list.get(i).equals(list.get(i-1)))
                count--;
            else{
                sb.append(list.get(i)+"\n"); 
            }
            
        }

        System.out.println(count+"\n"+ sb);
    }
       public static void SortList(ArrayList<String>list){
        list.sort((a, b) -> {
             return a.compareTo(b);
        });
    }
    
    
	public static void swapArray(Character [] array, int start, boolean res){
		if(res){
                    String M= new String();
			count++;
                        for(int i=0;i<array.length;i++)
                            M+=array[i];
                        list.add(M);
		}
		
		for(int j = start; j < array.length; j++){
			Character temp = array[start];
			array[start] = array[j];
			array[j] = temp;
			if(j == start){
				swapArray(array, start+1, false);
			}else{
				swapArray(array, start+1, true);
			}	 
			temp = array[start];
			array[start] = array[j];
			array[j] = temp;
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
