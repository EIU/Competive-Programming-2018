import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketImpl;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class pivot {

    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int p_max[] = new int[n];
        int p_min[] = new int[n];
        p_max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            p_max[i] = Math.max(arr[i], p_max[i - 1]);
        }
        p_min[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            p_min[i] = Math.min(arr[i], p_min[i + 1]);
        }
        int total = 0;
        if (arr[0] < p_min[1]) {
            total++;
        }
        if (arr[n - 1] > p_min[n - 2]) {
            total++;
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] < p_min[i + 1] && arr[i] > p_max[i - 1]) {
                total++;
            }
        }
        System.out.println(total);
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
