import java.io.*;
import java.util.*;

class Digital {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            int number = reader.nextInt(), pivot = reader.nextInt(), left = 0, right = 0, sum = 0, check = 0;
            for (int j = 0; j < number; j++) {
                int temp = reader.nextInt();
                check = temp == pivot ? 1 : check;
                if (temp == pivot || temp < pivot && check == 1) {
                    left = right + pivot;
                    right = 0;
                } else if (temp < pivot) {
                    right = 0;
                    left = 0;
                    check = 0;
                } else
                    right += temp;
                sum = check == 1 ? Math.max(left + right, sum) : sum;
                check = temp < pivot ? 0 : check;
            }
            builder.append(sum + "\n");
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