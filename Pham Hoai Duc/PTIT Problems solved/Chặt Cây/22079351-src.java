
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) {
        InputReader ip = new InputReader(System.in);
        int n = ip.nextInt();
        long[] forests = new long[n];
        long[] dp = new long[n];
        for(int i = 0; i < n; i++)
        	forests[i] = ip.nextLong();
        dp[n - 1] = forests[n - 1];
        for(int i = n - 2; i >= 0; --i) {
        	if(i + 3 >= n)
        		dp[i] = Math.max(forests[i], dp[i + 1]);
        	else
        		dp[i] = Math.max(forests[i] + dp[i + 3], dp[i + 1]);
        }
        if(dp[0] >= 0)
        	System.out.println(dp[0]);
        else
        	System.out.println(0);
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