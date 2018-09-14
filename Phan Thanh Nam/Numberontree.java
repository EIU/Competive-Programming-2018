import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Numberontree {
    public static void main(String[] args) throws IOException {
        InputReader sc = new InputReader(System.in);
        String s = sc.nextLine();
        String[] a = s.split(" ");
        int h = Integer.parseInt(a[0]);
        int x = 2;
        for (int i = 0; i < h; i++) {
            x *= 2;
        }
        x--;
        int r = 1;
        if (a.length > 1) {
            for (int i = 0; i < a[1].length(); i++) {
                if (a[1].charAt(i) == 'L') {
                    x -= r;
                    r *= 2;
                } else {
                    x -= r + 1;
                    r *= 2;
                    r++;
                }
            }
        }

        System.out.println(x);
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }

                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
