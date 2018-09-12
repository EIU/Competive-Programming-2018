import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Final {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        int numberOfTest = reader.nextInt();
        for (int i = 0; i < numberOfTest; i++) {
            int number = reader.nextInt();
            int[] arr = new int[number];
            for (int j = 0; j < number; j++) {
                arr[j] = reader.nextInt();
            }
            int acc = 0, a = arr[0], b = arr[1], c = 0;
            acc = Math.abs(a - b);
            boolean max = a >= b ? true : false;
            boolean check = true;
            for (int j = 2; j < number; j++) {
                c = arr[j];
                if (Math.abs(b - c) != acc) {
                    Arrays.sort(arr);
                    if (check(arr)) {
                        builder.append("permuted arithmetic\n");
                    } else {
                        builder.append("non-arithmetic\n");
                    }
                    check = false;
                    break;
                }
                b = c;
            }
            if (check) {
                builder.append("arithmetic\n");
            }
        }
        System.out.print(builder);
    }

    public static boolean check(int[] arr) {
        int acc = Math.abs(arr[0] - arr[1]);
        int b = arr[1], c;
        for (int j = 2; j < arr.length; j++) {
            c = arr[j];
            if (Math.abs(b - c) != acc) {
                return false;
            }
            b = c;
        }
        return true;

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
