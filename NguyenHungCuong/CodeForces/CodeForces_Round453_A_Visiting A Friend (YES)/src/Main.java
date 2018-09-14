
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
        int numTele = reader.nextInt();
        int location = reader.nextInt();
        boolean flag = true;
        int start = 0;
        int end = 0;
        for (int i = 0; i < numTele; i++) {
            int tempStart = reader.nextInt();
            int tempEnd = reader.nextInt();
            if (tempStart <= end && tempStart >= start) {
                if (tempEnd >= end) {
                    start = tempStart;
                    end = tempEnd;
                }
            } else {
                flag = false;
            }
        }
        if (flag && end >= location) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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
