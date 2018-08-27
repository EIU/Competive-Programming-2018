import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader(System.in);
        int N= input.nextInt(),p=1,count=0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> listBit = new ArrayList<>();
        for(int i=0;i<N;i++){
            listBit.add(p);
            count+=p;
            sb.append(0+" "+p+"\n");
            p= p << 1 ;  
        }
        for(int i =1;i<=count;i++){
            for(int j=0;j<listBit.size();j++){
                if((i | listBit.get(j))>i)
                    sb.append(i+" "+(i | listBit.get(j))+"\n");
            }
        }
         System.out.println(sb);
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
