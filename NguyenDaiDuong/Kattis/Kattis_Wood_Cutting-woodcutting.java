import java.io.*;
import java.util.*;

class Final2 {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        int numberOfTest = reader.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int numberOfCus = reader.nextInt();
            int[] arr = new int[numberOfCus];
            double sum = 0;
            for (int h = 0; h < numberOfCus; h++) {
                int custumer = reader.nextInt();
                for (int j = 0; j < custumer; j++) {
                    arr[h] += reader.nextInt();
                }
            }
            Arrays.sort(arr);
            sum = arr[0];
            for (int j = 1; j < numberOfCus; j++) {
                arr[j] = arr[j] + arr[j - 1];
                sum += arr[j];
            }
            builder.append(sum / numberOfCus + "\n");
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
