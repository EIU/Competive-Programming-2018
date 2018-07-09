import java.io.*;

import java.util.*;

class main {

    public static void main(String[] args) {

        InputReader reader = new InputReader(System.in);
        int numberOfInteger = reader.nextInt();
        int[] arrayOfNumber = new int[numberOfInteger];
        int[] minRight = new int[numberOfInteger - 1];
        for (int i = 0; i < numberOfInteger; i++) {
            arrayOfNumber[i] = reader.nextInt();
            if (i > 0) {
                minRight[i - 1] = arrayOfNumber[i];
            }
        }
        Arrays.sort(minRight);
        int maxLeft = arrayOfNumber[0];
        int numberOfPivot = 0;
        if (maxLeft < minRight[0]) {
            numberOfPivot += 1;
        }
        for (int i = 1, j = 0; i < numberOfInteger; i++) {
            if (arrayOfNumber[i] == minRight[j] && j < minRight.length-1) {
                j++;
            }else{
                if(j<minRight.length-1)
                    j++;
            }
            if (arrayOfNumber[i] > maxLeft && arrayOfNumber[i] < minRight[j]) {
                numberOfPivot += 1;
            }
            if (arrayOfNumber[i] > maxLeft) {
                maxLeft = arrayOfNumber[i];
                
            }
        }
        if (arrayOfNumber[numberOfInteger - 1] >= maxLeft) {
            numberOfPivot += 1;
        }
        System.out.println(numberOfPivot);
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
