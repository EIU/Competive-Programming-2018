import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfTea = reader.nextInt();
        int[] arrNumberOfTea = new int[numberOfTea];
        int i = 0;
        for (; i < numberOfTea; i++) {
            int tea = reader.nextInt();
            arrNumberOfTea[i] = tea;
        }
        int numberOfTopping = reader.nextInt();
        int[] arrNumberOfTopping = new int[numberOfTopping];
        for (i = 0; i < numberOfTopping; i++) {
            int topping = reader.nextInt();
            arrNumberOfTopping[i] = topping;
        }
        int smallestPrice = 0;
        for (i = 0; i < numberOfTea; i++) {
            int numberOfPrice = reader.nextInt();
            for (int j = 0; j < numberOfPrice; j++) {
                int price = reader.nextInt();
                if (i == 0 && j == 0) {
                    smallestPrice = arrNumberOfTopping[price-1] + arrNumberOfTea[i];
                } else {
                    if (arrNumberOfTopping[price-1] + arrNumberOfTea[i] < smallestPrice) {
                        smallestPrice = arrNumberOfTopping[price-1] + arrNumberOfTea[i];
                    }
                }
            }
        }
        int amountOfMoney = reader.nextInt();
        if (amountOfMoney / smallestPrice - 1 < 0) {
            System.out.println(0);
        } else {
            System.out.println(amountOfMoney / smallestPrice - 1);
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