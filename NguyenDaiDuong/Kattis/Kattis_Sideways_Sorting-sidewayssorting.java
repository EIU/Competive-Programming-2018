import java.io.*;
import java.util.*;

class Island {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int row = reader.nextInt();
        int colum = reader.nextInt();
        StringBuilder builder = new StringBuilder();
        while (row != 0 && colum != 0) {
            String[] temp = new String[colum];
            String[] temp1 = new String[row];
            for (int i = 0; i < row; i++) {
                char[] str = reader.next().toCharArray();
                for (int j = 0; j < colum; j++) {
                    temp[j] = temp[j] == null ? "" : temp[j];
                    temp[j] += str[j];
                }
            }
            bubbleSort(temp);
            for (int i = 0; i < colum; i++) {
                char[] str = temp[i].toCharArray();
                for (int j = 0; j < row; j++) {
                    temp1[j] = temp1[j] == null ? "" : temp1[j];
                    temp1[j] += str[j];
                }
            }
            for (int j = 0; j < row; j++) {
                builder.append(temp1[j] + "\n");
            }
            row = reader.nextInt();
            colum = reader.nextInt();
            if (row != 0 && colum != 0) {
                builder.append("\n");
            } else {
                builder.delete(builder.lastIndexOf("\n"), builder.length());
                System.out.print(builder);
            }
        }

    }

    public static void bubbleSort(String[] stringArray) {
        int n = stringArray.length;
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (stringArray[j - 1].compareToIgnoreCase(stringArray[j]) > 0) {
                    temp = stringArray[j - 1];
                    stringArray[j - 1] = stringArray[j];
                    stringArray[j] = temp;
                }

            }
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