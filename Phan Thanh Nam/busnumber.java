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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int index = 0;
        while (index < n) {
            int startpoint = arr[index];
            while (index + 1 < n && arr[index] == arr[index + 1] - 1) {
               index++;
            }
            int endpoint = arr[index];
            if (startpoint == endpoint) {
                System.out.printf("%d%s", startpoint, index == n - 1 ? "\n" : " ");
            } else {
                if (startpoint == endpoint - 1) {
                    System.out.printf("%d %d%s", startpoint, endpoint, check(index,n));
                } else {
                    System.out.printf("%d-%d%s", startpoint, endpoint, check(index,n));
                }
            }
            index++;
        }

    }

    public static String check(int index, int n){
        if(index==n-1){
            return "\n";
        }else {
            return " ";
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
