import java.io.*;
import java.util.*;

class Final5 {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfBaloon = reader.nextInt(), temp;
        List<Integer> list = new ArrayList<>();
        list.add(reader.nextInt());
        for (int i = 1; i < numberOfBaloon; i++) {
            temp = reader.nextInt();
            if (list.contains(temp + 1)) {
                list.remove(list.indexOf(temp + 1));
                list.add(temp);
            } else {
                list.add(temp);
            }
        }
        System.out.print(list.size());
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