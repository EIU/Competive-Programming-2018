
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numYellow = reader.nextInt();
        int numBlue = reader.nextInt();
        int needYellow = reader.nextInt();
        int needGreen = reader.nextInt();
        int needBlue = reader.nextInt();
        long numNeedYellow = (long) needYellow * 2 +needGreen-numYellow;
        long numNeedBlue =  (long) needBlue * 3 +needGreen-numBlue;
        if (numNeedBlue <0) numNeedBlue=0;
        if (numNeedYellow<0) numNeedYellow=0;
        System.out.println(numNeedBlue+numNeedYellow);

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
