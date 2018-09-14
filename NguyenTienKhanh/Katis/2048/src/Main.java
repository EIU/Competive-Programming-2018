import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Main {
    
public static void move(int[] nums) {
    
boolean[] merge = new boolean[4];

for (int i = 0; i < nums.length; i++)
    for (int j = i; j - 1 >= 0 && !merge[j - 1]; j--)
        {
        if (nums[j - 1] == 0)
            {
            nums[j - 1] = nums[j];
            nums[j] = 0;
            }
        else if (nums[j - 1] == nums[j])
            {
            nums[j - 1] *= 2;
            nums[j] = 0;
            merge[j - 1] = true;
            break;
            }
        else
            break;
        }
}

public static int[][] rotate(int[][] nums) {
    
int[][] rot = new int[4][4];

for (int i = 0; i < 4; i++)
    for (int j = 0; j < 4; j++)
        rot[3 - j][i] = nums[i][j];

return rot;
}

public static void main(String[] args) {
InputReader input = new Scanner(System.in);
    
int[][] nums = new int[4][4];

for (int i = 0; i < 4; i++)
    for (int j = 0; j < 4; j++)
        nums[i][j] = input.nextInt();

int move = input.nextInt();

for (int i = 0; i < move; i++)
    nums = rotate(nums);
    
for (int i = 0; i < 4; i++)
    move(nums[i]);

for (int i = 0; i < 4 - move; i++)
    nums = rotate(nums);

for (int i = 0; i < 4; i++)
    System.out.println(Arrays.toString(nums[i]).substring(1 , Arrays.toString(nums[i]).length() - 1).replace("," , ""));

input.close();
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