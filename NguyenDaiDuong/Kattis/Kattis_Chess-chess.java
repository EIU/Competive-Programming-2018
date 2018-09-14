
import java.io.*;
import java.util.*;

class chess {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfTest = reader.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numberOfTest; i++) {
            char row1 = reader.next().toCharArray()[0];
            int colum1 = reader.nextInt();
            char row2 = reader.next().toCharArray()[0];
            int colum2 = reader.nextInt();
            boolean check = false;
            if (colum1 == colum2 && row1==row2) {
            	check=true;
                builder.append("0"+" "+row1+" "+colum1+"\n");
            } else {
                for (char j = 'A'; j <= 'Z'; j++) {
                    for (int h = 1; h <= 8; h++) {
                    	if (Math.abs(j-row1)==Math.abs(h-colum1)&&Math.abs(j-row2)==Math.abs(h-colum2)) {
                            check = true;
                            builder.append(j==row2&&h==colum2||j==row1&&h==colum1?"1"+" "+row1+" "+colum1+" "+row2+" "+colum2+"\n" : "2"+" "+row1+" "+colum1+" "+j+" "+h+" "+row2+" "+colum2+"\n");
                            break;
                        }
                    }
                    if(check)
                    	break;
                }
            }
            if (check == false) {
                builder.append("Impossible").append("\n");
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
