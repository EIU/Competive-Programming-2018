import java.io.*;
import java.util.*;

class Temp {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        char[][] arr = new char[8][8];
        int count = 0;
        List<chess> list = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            char[] temp = reader.next().toCharArray();
            for (int j = 0; j <= 7; j++) {
                arr[i][j] = temp[j];
                if (temp[j] == '*') {
                    count++;
                    chess acc = new chess(i, j);
                    list.add(acc);
                }
            }
        }
        if (count != 8) {
            System.out.println("invalid");
        } else {
            boolean check = true;
            for (int i = 0; i <= 7; i++) {
                for (int j = i + 1; j <= 7; j++) {
                    if (list.get(i).idX == list.get(j).idX || list.get(i).idY == list.get(j).idY) {
                        check = false;
                    }
                    if (Math.abs(list.get(j).idX - list.get(i).idX) == Math.abs(list.get(j).idY - list.get(i).idY)) {
                        check = false;
                    }
                }
            }
            System.out.println(check == true ? "valid" : "invalid");
        }

    }

    public static class chess {
        int idX;
        int idY;

        public chess(int idX, int idY) {
            this.idX = idX;
            this.idY = idY;
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