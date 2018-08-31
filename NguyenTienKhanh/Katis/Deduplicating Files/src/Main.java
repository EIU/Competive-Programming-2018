import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main {

    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();

while (true)
    {
    int N = input.nextInt();
    if (N == 0)
        break;
        HashSet<String> listUni = new HashSet<>();
        ArrayList<String> listChars = new ArrayList<>();
    for(int i=0;i<N;i++){
        String T= input.nextLine();
        listChars.add(T);
        listUni.add(T);
        }
    int count=0;
    for (int i=0;i<listChars.size();i++)
        {
        char Char1 = hash(listChars.get(i));
        int j=i+1;
       for (;j<listChars.size();j++)
            {
            
                if(!listChars.get(i).equals(listChars.get(j))){
                char Char2 = hash(listChars.get(j));
                
                if (Char1 == Char2)
                    count++;
                }
            }
        }
       sb.append(listUni.size()+" "+ count+"\n");
    }
        System.out.println(sb);
    }
        public static char hash(String test) {
    char M = new Character(test.charAt(0));
    for (int i = 1; i < test.length(); i++)
        M ^= test.charAt(i);  
    return M;
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
