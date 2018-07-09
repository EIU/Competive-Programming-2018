
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Windows 10 Version 2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader(System.in);
        int i;

        StringBuilder sb = new StringBuilder();
        
        
        while (true) {
            int max = Integer.MIN_VALUE;

            HashMap<Integer, Integer> listLength = new HashMap<>();
            int N = input.nextInt();
            String[] Af = new String[N];
            if (N == 0) {
                break;
            }

            for (i = 0; i < N; i++) {
                Af[i] = input.nextLine();
                listLength.put(i, Af[i].length() - 1);
                if (Af[i].length() > max) {
                    max = Af[i].length();
                }
            }
            String[] Be = new String[max];
            for (i = 0; i < Be.length; i++) {
                Be[i] = "";
            }
            for (int p = 0; p < max; p++) {
                for (int q = N - 1; q >= 0; q--) {
                    if (listLength.get(q) < p) {
                        Be[p] += ' ';
                        continue;
                    }
                    if (Af[q].charAt(p) == '|') {
                        Be[p] += '-';
                    } else {
                        if (Af[q].charAt(p) == '-') {
                            Be[p] += '|';
                        } else {
                            Be[p] += Af[q].charAt(p);
                        }

                    }

                }
            }
            for (i = 0; i < max; i++) {
                sb.append(Be[i].replaceAll("\\s+$", "") + "\n");
            }
            sb.append("\n");

        }
        sb.delete(sb.lastIndexOf("\n"), sb.lastIndexOf("\n") + 1);
        System.out.print(sb);

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
