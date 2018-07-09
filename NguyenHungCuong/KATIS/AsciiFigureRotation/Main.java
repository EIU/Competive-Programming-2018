
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader(System.in);

        boolean firstLine = true;
        int n;
        StringBuilder res = new StringBuilder();
        while ((n = scan.nextInt()) != 0) {
            String a;
            char[][] list = new char[n][];
            int width = 0;
            for (int i = 0; i < n; i++) {
                a = scan.nextLine();
                width = Math.max(width, a.length());
                list[i] = a.toCharArray();
            }

            if (firstLine) {
                firstLine = false;
            } else {
                res.append("\n");
            }

            for (int j = 0; j < width; j++) {
                String out = "";
                for (int i = n - 1; i >= 0; i--) {
                    char c;
                    if (j >= list[i].length) {
                        c = ' ';
                    } else {
                        c = list[i][j];
                        if (c == '-') {
                            c = '|';
                        } else if (c == '|') {
                            c = '-';
                        }
                    }

                    out += c;
                }
                res.append(out.replaceAll("\\s+$", "")).append("\n");
            }

        }
        System.out.println(res.substring(0,res.lastIndexOf("\n")));
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
