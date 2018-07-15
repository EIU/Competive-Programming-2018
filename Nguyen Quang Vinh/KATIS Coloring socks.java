


 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.HashMap;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);

        ArrayList<Integer> arrList = new ArrayList();
        int S = reader.nextInt();
        int C = reader.nextInt();
        int K = reader.nextInt();
        
        for ( int i = 0 ; i < S ; i++){
            int temp = reader.nextInt();
            arrList.add(temp);
        }
        Collections.sort(arrList);
        int i ; int count = 1 ; int quantity = 0;
        
        for ( i = 0 ; i < S ; ){
            if (count - i < C && count < S && arrList.get(count) - arrList.get(i) <= K){
                count = count + 1;
            }
            else{
                i = count;
                count = i + 1;
                quantity = quantity + 1;
                
            }
        }
        System.out.println(quantity);
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
 