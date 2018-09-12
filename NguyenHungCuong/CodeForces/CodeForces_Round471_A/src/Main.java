
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
        Scanner scan = new Scanner(System.in);
        int hour = scan.nextInt();
        int minute=scan.nextInt();
        int hunger = scan.nextInt();
        int up = scan.nextInt();
        int cost = scan.nextInt();
        int down = scan.nextInt();
        if (hour >=20){
            Double res = hunger/(double)down;
            if (res>res.intValue()){
                res++;
            }
            System.out.println(res.intValue()*cost*0.8);
        } else {
            int time = (19-hour)*60+(60-minute);
            Double a = (hunger+time*up)/(double)down;
            if (a>a.intValue()){
                a++;
            }
            a=a.intValue()*cost*0.8;
            Double b = (hunger)/(double)down;
            if (b>b.intValue()){
                b++;
            }
            b=(double)(b.intValue()*cost);
            System.out.println((a<=b)?a:b);
            
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
