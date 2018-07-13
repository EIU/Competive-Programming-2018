import java.io.*;
import java.util.*;

class Minimum {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        int numberOfTest = reader.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            long sum = 0;
            long[] vectorV1 = new long[reader.nextInt()];
            long[] vertorV2 = new long[vectorV1.length];
            for (int j = 0; j < vectorV1.length; j++) {
                vectorV1[j] = reader.nextLong();
            }
            for (int j = 0; j < vectorV1.length; j++) {
                vertorV2[j] = reader.nextLong();
            }
            Arrays.sort(vectorV1);
            Arrays.sort(vertorV2);
            for (int k = 0; k < vectorV1.length; k++) {
                sum += vectorV1[k] * vertorV2[vectorV1.length - (k + 1)];
            }
            builder.append("Case #" + (i + 1) + ": " + sum + "\n");
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