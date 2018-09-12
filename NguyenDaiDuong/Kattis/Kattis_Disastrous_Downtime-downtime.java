import java.io.*;
import java.util.*;

class Disastrous_Downtime {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int[] arr = new int[reader.nextInt()];
        double maxProcessIn1S = reader.nextDouble();
        int minProcess = 0, currentProcess = 0, maxLength = 0, h;
        for (int i = 0; i < arr.length; i++)
            arr[i] = reader.nextInt();
        minProcess = arr[h = 0];
        for (int i = 1; i < arr.length; i++) {
            currentProcess = arr[i];
            if (currentProcess - minProcess < 1000)
                maxLength = Math.max(i - h, maxLength);
            else
                while (currentProcess - minProcess >= 1000)
                    minProcess = arr[++h];
        }
        System.out.println((int) Math.ceil((maxLength + 1) / maxProcessIn1S));
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