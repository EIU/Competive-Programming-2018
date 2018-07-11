import java.io.*;
import java.util.*;

class Minimum {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder= new StringBuilder();
        int numberOfTest=reader.nextInt();
        for(int i=0;i<numberOfTest;i++) {
            int n=reader.nextInt();
            long sum=0;
            long[] arr1= new long [n];
            long[] arr2= new long [n];
            for(int j=0;j<n;j++) {
                arr1[j]=reader.nextLong();
            }
            for(int j=0;j<n;j++) {
                arr2[j]=reader.nextLong();
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            for(int k=0,l=n-1;k<n;k++,l--) {
                sum+=arr1[k]*arr2[l];
            }
            builder.append("Case #"+(i+1)+": "+sum+"\n");
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