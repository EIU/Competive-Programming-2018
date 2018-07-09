import java.io.*;
import java.util.*;

class main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numberOfPaws=reader.nextInt();
        int count=0;
        List<Integer> row=new ArrayList<>();
        List<Integer> colum=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<numberOfPaws;i++){
            row.add(reader.nextInt());
            colum.add(reader.nextInt());
            temp.add(i+1);
        }
        Collections.sort(row);
        Collections.sort(colum);
        for(int i=0;i<numberOfPaws;i++){
            count+=Math.abs(temp.get(i)-row.get(i));
            count+=Math.abs(temp.get(i)-colum.get(i));
        }
        System.out.println(count);
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
