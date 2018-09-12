import java.io.*;
import java.util.*;

class Final4 {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        long[] arr = new long[31];
        arr[0] = 1;
        arr[2] = 3;
        for (int i = 4; i < arr.length; i += 2) {
            for (int j = i; j >= 0; j -= 2)
                arr[i] += ((i == j + 2) ? 3 : 2) * arr[j];
        }
        int number = reader.nextInt();
        while (number != -1) {
            builder.append(arr[number] + "\n");
            number = reader.nextInt();
        }
        System.out.print(builder);
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