import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfSeedlings=reader.nextInt();
        int []seedlings= new int[numberOfSeedlings];
        int []accSeedlings= new int[numberOfSeedlings];
        for(int i=0;i<numberOfSeedlings;i++){
            int tempSeedling=reader.nextInt();
            seedlings[i]=tempSeedling;
        }
        Arrays.sort(seedlings);
        int j=0,h=1;
        for(int i=numberOfSeedlings-1;i>=0;i--){
            accSeedlings[j++]=seedlings[i]+h++;
        }
        Arrays.sort(accSeedlings);
        System.out.println(accSeedlings[numberOfSeedlings-1]+1);
        
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