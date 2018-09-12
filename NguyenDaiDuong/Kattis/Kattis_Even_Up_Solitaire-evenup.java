import java.io.*;
import java.util.*;

class Even_Up_Solitaire {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfN = reader.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberOfN; i++) {
            list.add(reader.nextInt());
            if (list.size() > 1 && (list.get(list.size() - 1) + list.get(list.size() - 2)) % 2 == 0) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
        System.out.println(list.size());
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