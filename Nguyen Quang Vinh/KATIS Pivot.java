

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
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int count = 0;
        ArrayList<Long> arrList = new ArrayList();
        ArrayList<Long> arrList2 = new ArrayList();
        ArrayList<Long> arrList3 = new ArrayList();
        for ( int i = 0 ; i < n ; i++){
            long temp = reader.nextLong();
            arrList.add(temp);
            arrList2.add(temp);
            arrList3.add(temp);
        }
        
        long pivot = arrList.get(0);
        long pivot2 = arrList.get(arrList.size() - 1);
        for (int i = 1 ; i < arrList.size() ; i++){
            if ( arrList.get(i) < pivot){
                arrList.set(i, pivot);
            }
            else if (arrList.get(i) > pivot){
                pivot = arrList.get(i);
            }
            
        }
        
        
        for ( int i = arrList2.size() - 1 ; i >= 0 ; i--){
            if ( arrList2.get(i) > pivot2){
                arrList2.set(i, pivot2);
            }
            else if (arrList2.get(i) < pivot2){
                pivot2 = arrList2.get(i);
            }
        }
        
        for ( int i = 0 ; i < arrList3.size() ; i++){
            if(arrList3.get(i) >= arrList.get(i) && arrList3.get(i) <= arrList2.get(i)){
                count++;
            }
        }
        
        System.out.println(count);
        
        
       
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
