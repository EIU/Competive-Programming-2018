import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chess {
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char a = sc.next().charAt(0);
            int row1 = sc.nextInt();
            char b = sc.next().charAt(0);
            int row2 = sc.nextInt();
            int col1 = a - 'A' + 1;
            int col2 = b - 'A' + 1;

            if ((row1 + col1) % 2 != (row2 + col2) % 2) {
                System.out.println("Impossible");
            } else {
                int row = (row1 + col1 - col2 + row2) / 2;
                int col = (row1 + col1 + col2 - row2) / 2;
                if(col>8||col<1||row>8||row<1){
                    row = (row2 + col2 - col1 + row1) / 2;
                    col = (row2 + col2 + col1 - row1) / 2;
                }
                if (col1 == col2 && row1 == row2) {
                    System.out.println(0 + " " + (char)(col+'A'-1) + " " + row1);
                } else if (col1 + row1 == col2 + row2 || col1 + row2 == col2 + row1) {
                    System.out.println(1 + " " + a + " " + row1 + " " + b + " " + row2);
                } else {
                    System.out.println(2 + " " + a + " " + row1 + " " + (char)(col+'A'-1) + " " + row + " " + b + " " + row2);
                }
           }
        }
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
