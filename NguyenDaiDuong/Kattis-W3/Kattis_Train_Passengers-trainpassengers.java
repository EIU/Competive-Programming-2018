import java.io.*;
import java.util.*;

class Passenger {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        StringBuilder builder= new StringBuilder();
        int capacity=reader.nextInt();
        int numberOfStation=reader.nextInt();
        int sumPass=0;
        boolean check=true;
        int passLeft=0;
        int passEnter=0;
        int passWait=0;
        for(int i=0;i<numberOfStation;i++) {
            passLeft=reader.nextInt();
            passEnter=reader.nextInt();
            passWait=reader.nextInt();
            if(passLeft>sumPass) {
                check=false;
                builder.append("impossible");
                break;
            }
            sumPass+=passEnter-passLeft;
            if(sumPass==0||sumPass<capacity) {
                while(sumPass<capacity&&passWait>0) {
                    sumPass++;
                    passWait--;
                }
            }
            if(i==0&&passLeft>0||i==numberOfStation-1&&passWait>0|sumPass>0||sumPass>capacity||sumPass<0) {
                check=false;
                builder.append("impossible");
                break;
            }
        }
        if(check)
            builder.append("possible");
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