
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int N = input.nextInt();
        boolean first = true;
        while (N!=0) {
            int max = Integer.MIN_VALUE;
            String[] listChar = new String[N];
            for (int i = 0; i < N; i++) {
                listChar[i] = input.nextLine();
                if (listChar[i].length() > max) {
                    max = listChar[i].length();
                }
            }
            if(!first)
                sb.append("\n");
                first=false;
            StringBuilder charRs = null;            
            for (int p = 0; p < max; p++) {
                charRs= new StringBuilder();
                for (int q = N - 1; q >= 0; q--) {
                    char c  = listChar[q].length() <= p ? ' ':listChar[q].charAt(p)=='|'? '-':listChar[q].charAt(p) == '-'?'|':listChar[q].charAt(p);
                    charRs.append(c);
                }
                sb.append(DeleteEmp(charRs)+ "\n");
            }
            N = input.nextInt();
        }
        System.out.print(sb);

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
