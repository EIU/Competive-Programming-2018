import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfSocks=reader.nextInt();
        int []arrSocks= new int[numberOfSocks];
        double maxSocks=reader.nextDouble();
        int maxColour=reader.nextInt();
        for(int i=0;i<numberOfSocks;i++){
            arrSocks[i]=reader.nextInt();
        }
        Arrays.sort(arrSocks);
        int numberOfMachine=0;
        int tempSock=0;
        for(int i=0;i<numberOfSocks;i++){
            tempSock=i;
            while(i<numberOfSocks){
                if(arrSocks[i]-arrSocks[tempSock]<=maxColour&&i-tempSock<maxSocks){
                    i++;
                }else{
                    i--;
                    break;
                }
            }
            numberOfMachine+=1;
        }
        System.out.println(numberOfMachine);
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
