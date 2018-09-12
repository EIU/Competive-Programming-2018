import java.io.*;
import java.util.*;

class Clock {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        int I = reader.nextInt(), II = reader.nextInt(), III = reader.nextInt(), IV = reader.nextInt();
        while (I + II + III + IV != 0) {
            int sum = 120;
            sum+=(I-II+40)%40;
            sum+=(III-II+40)%40;
            sum+=(III-IV+40)%40;
            builder.append(sum * 9 + "\n");
            I = reader.nextInt();
            II = reader.nextInt();
            III = reader.nextInt();
            IV = reader.nextInt();
            if (I + II + III + IV == 0) {
                builder.delete(builder.lastIndexOf("\n"), builder.length());
                System.out.print(builder);
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