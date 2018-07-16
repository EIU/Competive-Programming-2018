
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader(System.in);
        StringBuilder sb ;
        StringBuilder ts;
        int N = input.nextInt();
        String test= new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        for(int i=0;i<N;i++){
            HashSet hTest = new HashSet();
            String ip = new String(input.nextLine());
            sb = new StringBuilder();
            ts= new StringBuilder();
            for(int j=0;j<ip.length();j++){
                hTest.add(ip.charAt(j));
            }
            for(int t=0;t<(test.length())/2;t++){
                if(!hTest.contains(test.charAt(t))&& !hTest.contains(test.charAt(t+26))){ 
                    ts.append(test.charAt(t));
                }
            }
            if(ts.length()==0)
            sb.append("pangram"+"\n");
        else
            sb.append("missing "+ts+"\n");
        System.out.print(sb);
        }
        

    }
    public static StringBuilder DeleteEmp(StringBuilder listChar){
        for(int i= listChar.length()-1 ;i>=0;i--){
            if(listChar.charAt(i)!= ' '){
               break;
            }
            listChar.delete(i, listChar.length());
        }
        return listChar;
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
