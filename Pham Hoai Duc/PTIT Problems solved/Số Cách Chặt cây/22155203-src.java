
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
        long[] dpWays = new long[n];
        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
        	forests[i] = ip.nextLong();
        }
        if (forests[n - 1] < 0) {
            dp[n - 1] = 0;
            dpWays[n - 1] = 0;
        } else {
            dp[n - 1] = forests[n - 1];
            dpWays[n - 1] = 1;
        }
        map.put(dp[n - 1], dpWays[n - 1]);
        for (int i = n - 2; i >= 0; --i) {
            if (i + 2 >= n) {
                dp[i] = Math.max(forests[i], dp[i + 1]);
                dpWays[i] = forests[i] > dp[i + 1] ? 1 : forests[i] < dp[i + 1] ? dpWays[i + 1] : dpWays[i + 1] + 1;
                dpWays[i] %= 1000000007;
                map.put(dp[i], dpWays[i]);
            } else {
                dp[i] = Math.max(forests[i] + dp[i + 2], dp[i + 1]);
                 if (forests[i] + dp[i + 2] < dp[i + 1]) {
                    dpWays[i] = dpWays[i + 1];
                } else {
                    dpWays[i] += dpWays[i + 2];
                    if (forests[i] == dp[i]) {
                        dpWays[i]++;
                    }
                    if (map.containsKey(dp[i])) {
                        dpWays[i] += map.get(dp[i]);
                    }
                }
               dpWays[i] %= 1000000007;
               map.put(dp[i], dpWays[i]);
            }
        }
        if(dp[0] <= 0) {
        	System.out.println(0 + " " + 1);
        }else {
        	System.out.println(dp[0] + " " + (dpWays[0] % 1000000007));  
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