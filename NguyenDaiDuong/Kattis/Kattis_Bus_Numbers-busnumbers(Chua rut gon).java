import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder = new StringBuilder();
        int numberOfBus = reader.nextInt();
        int[] arrOfBus = new int[numberOfBus];
        int i = 0, first = 0, last = 0;
        for (; i < numberOfBus; i++) {
            int temp = reader.nextInt();
            arrOfBus[i] = temp;
        }
        Arrays.sort(arrOfBus);
        int j = 0;
        if (numberOfBus < 3) {
            for (i = 0; i < numberOfBus; i++) {
                builder.append(arrOfBus[i]).append(" ");
            }
        } else {
            for (i = 0; i < numberOfBus; i++) {
                first = arrOfBus[i];
                if (i + 1 < numberOfBus) {
                    if (first == arrOfBus[i + 1] - 1) {
                        j = i + 1;
                        last = arrOfBus[j];
                        if(j+1<numberOfBus){
                            while (last == arrOfBus[j + 1] - 1) {
                            j += 1;
                            last = arrOfBus[j];
                            if(j==numberOfBus-1){
                                break;
                            }
                        }
                        if (j - i >= 2) {
                            builder.append(first).append("-").append(last).append(" ");
                        } else {
                            builder.append(first).append(" ").append(last).append(" ");
                        }
                        }else{
                            builder.append(first).append(" ").append(last).append(" ");
                        }
                        i = j;
                    } else {
                        builder.append(first).append(" ");
                    }
                }else{
                    builder.append(first).append(" ");
                    break;
                }
                
            }
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