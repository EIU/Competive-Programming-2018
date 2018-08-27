
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        InputReader input = new InputReader(System.in);
        int N = input.nextInt();
        int[]st ;
        int[] right ;
        for (int i = 0; i < N; i++) {
           int M= input.nextInt();
           st= new int[M];
           right=new int[M];
           for(int j=0;j<M;j++){
               int T = input.nextInt();
               st[j]=(T);
               right[j]=T;
           }
           Arrays.sort(right);
           int y=0,count=0;
           while(y+count<st.length){
               if(st[y+count]==right[y]){
                   y++;
               }else{
               count++;}}
           sb.append(count+"\n");
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
