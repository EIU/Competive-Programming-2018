import java.io.*;
import java.util.*;

class Pseudoprime_numbers {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        for (int i = 3; i <= 31624; i++) {
            boolean check = true;
            for (Integer j : list) {
                if (i % j == 0)
                    check = false;
            }
            if (check == true)
                list.add(i);
        }
        int p = reader.nextInt();
        int a = reader.nextInt();
        StringBuilder builder = new StringBuilder();
        while (p + a != 0) {
            boolean check = true;
            for (Integer j : list) {
                if (p % j == 0 && p != j) {
                    check = false;
                    break;
                }
                if (j > p)
                    break;
            }
            builder.append(check == false && a == powMod(a, p, p) ? "yes\n" : "no\n");
            p = reader.nextInt();
            a = reader.nextInt();
        }
        System.out.println(builder.delete(builder.lastIndexOf("\n"), builder.length()));
    }

    public static long powMod(int a, int p, int k) {
        long temp = a;
        long res = 1;
        while (p > 0) {
            if ((p & 1) == 1) {
                res = (res * temp) % k;
            }
            temp = (temp * temp) % k;
            p >>= 1;
        }
        return res;
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
