import java.io.*;
import java.util.*;

class main {

    public static void main(String args[]){
        InputReader reader = new InputReader(System.in);
        int numberOfTest=reader.nextInt();
        for(int i=0;i<numberOfTest;i++){
            int a=reader.nextInt();
            int b=reader.nextInt();
            int count=1;
            long c=1;
            for(int j=a+1;j<=b;j++)
                c*=j;
            for(int j=1;j<=c/2;j++)
                if(c%j==0)
                    count++;
            System.out.println(count);
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
