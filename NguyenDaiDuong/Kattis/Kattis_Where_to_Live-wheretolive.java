import java.io.*;
import java.util.*;

class Class {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        double n = reader.nextDouble();
        while (n != 0) {
            double sumX = 0;
            double sumY = 0;
            for (int i = 0; i < n; i++) {
                sumX += reader.nextDouble();
                sumY += reader.nextDouble();
            }
            builder.append(Math.round((sumX / n)-Math.pow(2.718281828459045, -9)) + " " + Math.round((sumY / n)-Math.pow(2.718281828459045, -9)));
            n = reader.nextDouble();
            builder.append(n != 0 ? "\n" : "");
        }
        System.out.println(builder);
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