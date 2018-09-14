import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfCus = reader.nextInt();
        int[] cusOutcomes = new int[numberOfCus];
        int[] tempCusOutcomes = new int[numberOfCus];
        for (int i = 0; i < numberOfCus; i++) {
            int outcome = reader.nextInt();
            cusOutcomes[i] = outcome;
            tempCusOutcomes[i] = outcome;
        }
        int temp = 0;
        boolean winner = false;
        boolean result = false;
        Arrays.sort(cusOutcomes);
        if (cusOutcomes.length == 1) {
            System.out.println("1");
        } else {
            if (cusOutcomes[numberOfCus - 1] == cusOutcomes[0]) {
                System.out.println("none");
                winner = false;
                result=true;
            } else {
                for(int i=numberOfCus-1;i>0;i--){
                    if(i==numberOfCus-1&&cusOutcomes[i]!=cusOutcomes[i-1]){
                        temp=cusOutcomes[i];
                        winner=true;
                        break;
                    }else{
                        if(cusOutcomes[i]!=cusOutcomes[i-1]&&cusOutcomes[i]!=cusOutcomes[i+1]&&cusOutcomes[i]>temp){
                            winner=true;
                            temp=cusOutcomes[i];
                        }
                        if(cusOutcomes[0]>temp&&cusOutcomes[0]!=cusOutcomes[1]){
                            winner=true;
                            temp=cusOutcomes[0];
                        }
                    }
                }
            }
            if (winner == true) {
                int h = 0;
                while (tempCusOutcomes[h] != temp&&h<numberOfCus) {
                    h++;
                }
                System.out.println(h + 1);
            }
            if(winner==false&&result==false)
                System.out.println("none");
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
