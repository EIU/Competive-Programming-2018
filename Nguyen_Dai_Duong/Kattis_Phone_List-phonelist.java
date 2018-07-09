import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            int numberOfTest = reader.nextInt();
            String[] numberArr = new String[numberOfTest];
            for (int j = 0; j < numberOfTest; j++) {
                
                String tempNumber = reader.next();
                numberArr[j] = tempNumber;
            }
            Arrays.sort(numberArr);
            int h = 0;
            boolean check = true;
            if(numberArr.length>1){
                while (h < numberArr.length - 1) {
                if (numberArr[h+1].startsWith(numberArr[h])) {
                    System.out.println("NO");
                    check = false;
                    break;
                }
                h++;
            }
            }
            if (check == true) {
                System.out.println("YES");
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