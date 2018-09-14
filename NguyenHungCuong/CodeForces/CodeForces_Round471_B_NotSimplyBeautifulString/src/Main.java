
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputReader scan = new InputReader(System.in);
        String a = scan.next();
        if (a.length()<4){
            System.out.println("No");
            return;
        }
        int[] distinct = new int[26];
        for (int i=0;i<a.length();i++){
            distinct[a.charAt(i)-'a']++;
        }
        System.out.println(check(distinct));
    }
    static String check(int[] charCount){
        int numDistinct=0;
        for (int i=0;i<charCount.length;i++){
            if (charCount[i]>0){
                numDistinct++;
            }
        }
        if (numDistinct==1||numDistinct>4){
           return "No";
            
        }
        if (numDistinct==3||numDistinct==4){
            return "Yes";
        }
        for (int i=0;i<charCount.length;i++){
            if (charCount[i]==1){
                return "No";
            }
        }
        return "Yes";
        
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
