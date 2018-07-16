
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        InputReader ip = new InputReader(System.in);
        int n = ip.nextInt();
        StringBuilder[] builder = new StringBuilder[n];
        for(int i = 0; i < n; i++)
        {
        	builder[i] = new StringBuilder(ip.nextLine());
        	HashSet<Character> characters = new HashSet<>();
        	StringBuilder missing = new StringBuilder();
        	for(int j = 0 ; j < builder[i].length(); j++)
        		characters.add(builder[i].charAt(j));
        	char upper, lower;
            for(lower = 'a', upper = 'A'; lower <= 'z'; upper++, lower++)
            	if(characters.contains(lower) == false && characters.contains(upper) == false)
            		missing.append(lower);
            if(missing.length() > 0)
            	System.out.println("missing "+missing);
            else
            	System.out.println("pangram");
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