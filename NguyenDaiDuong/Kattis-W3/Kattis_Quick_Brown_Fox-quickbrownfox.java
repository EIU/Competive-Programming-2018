import java.io.*;
import java.util.*;

class Fox {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        int numberOfTest = reader.nextInt();
        boolean check = true;
        for (int i = 0; i < numberOfTest; i++) {
            String tempLine = reader.nextLine().toLowerCase();
            String str = "";
            for (char j = 'a'; j <= 'z'; j++) {
                if (tempLine.indexOf(j) < 0) {
                    check = false;
                    str = (str.indexOf("missing ") >= 0 ? str + j : "missing " + j);
                }
            }
            builder.append(check == true ? "pangram" + "\n" : str + "\n");
            check = true;
            str = "";
        }
        System.out.println(builder);
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
