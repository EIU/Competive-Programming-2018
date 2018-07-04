import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class busnumber {
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        int n = sc.nextInt();
        int[] bus_number = new int[n];
        for (int i = 0; i < n; i++) {
            bus_number[i] = sc.nextInt();
        }
        Arrays.sort(bus_number);
        int index = 0;
        for (; index < n; index++) {
            int startpoint = bus_number[index];
            while (index + 1 < n && bus_number[index] == bus_number[index + 1] - 1)index++;
            int endpoint = bus_number[index];
            if (startpoint == endpoint) {
                System.out.printf("%d%s", startpoint, index == n - 1 ? "\n":" ");
            } else if (startpoint == endpoint - 1) {
                System.out.printf("%d %d%s", startpoint, endpoint, index == n - 1 ? "\n":" ");
            } else
                System.out.printf("%d-%d%s", startpoint, endpoint, index == n - 1 ? "\n":" ");
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
