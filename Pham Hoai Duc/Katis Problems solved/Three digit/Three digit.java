
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        InputReader ip = new InputReader(System.in);
        int n = ip.nextInt();
        int v_5 = 0;
        long powerOf5 = 5;
        while(true)
        {
            long count = n / powerOf5;
            if(count == 0)
                break;
            v_5 += count;
            powerOf5 *= 5;
        }
        int v_2 = v_5;
        long sum = 1;
        long sum2 = 0;
        for(int i = 1; i <= n; i++)
        {
            int temp = i;
            if(v_2 != 0)
            {
                while(temp % 2 == 0)
                {
                    temp /= 2;
                    v_2--;
                    if(v_2 == 0)
                        break;
                }
            }
            if(v_5 != 0)
            {
                while(temp % 5 == 0)
                {
                    temp /= 5;
                    v_5--;
                    if(v_5 == 0)
                        break;
                }
            }
            sum *= temp;
            sum2 = sum;
            if(sum > 1000)
            {
                sum %= 1000;
            }
        }
        StringBuilder builder = new StringBuilder();
        if(sum2 > 1000 && sum < 100)
        {
            builder.append("0"+sum);
        }
        else
        {
            builder.append(sum+"\n");
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